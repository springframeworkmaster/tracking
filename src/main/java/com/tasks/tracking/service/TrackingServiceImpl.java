package com.tasks.tracking.service;

import java.io.StringReader;

import com.tasks.tracking.api.TrackingApi;
import com.tasks.tracking.dto.TrackingRequest;
import com.tasks.tracking.dto.TrackingResponse;
import com.tasks.tracking.dto.fedex.ClientDetail;
import com.tasks.tracking.dto.fedex.CompletedTrackDetail;
import com.tasks.tracking.dto.fedex.Notification;
import com.tasks.tracking.dto.fedex.NotificationSeverityType;
import com.tasks.tracking.dto.fedex.TrackDetail;
import com.tasks.tracking.dto.fedex.TrackIdentifierType;
import com.tasks.tracking.dto.fedex.TrackPackageIdentifier;
import com.tasks.tracking.dto.fedex.TrackReply;
import com.tasks.tracking.dto.fedex.TrackRequest;
import com.tasks.tracking.dto.fedex.TrackRequestProcessingOptionType;
import com.tasks.tracking.dto.fedex.TrackSelectionDetail;
import com.tasks.tracking.dto.fedex.TransactionDetail;
import com.tasks.tracking.dto.fedex.VersionId;
import com.tasks.tracking.dto.fedex.WebAuthenticationCredential;
import com.tasks.tracking.dto.fedex.WebAuthenticationDetail;
import com.tasks.tracking.dto.ups.Request;
import com.tasks.tracking.dto.ups.TransactionReference;
import com.tasks.tracking.dto.ups.UpsAccessRequest;
import com.tasks.tracking.dto.ups.UpsTrackingRequest;
import com.tasks.tracking.dto.usps.TrackID;
import com.tasks.tracking.dto.usps.UspsTrackingRequest;
import com.tasks.tracking.utils.Constants;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
@RefreshScope
public class TrackingServiceImpl implements TrackingService {

	private final TrackingApi trackingApi;

	@Value("${usps.user.id}")
	protected String uspsUserId;

	@Value("${ups.user.id}")
	protected String upsUserId;

	@Value("${ups.user.password}")
	protected String upsUserPassword;

	@Value("${ups.user.accesslicensenumber}")
	protected String upsAccessLicenseNumber;

	@Value("${fedex.user.accountnumber}")
	protected String accountNumber;

	@Value("${fedex.user.meternumber}")
	protected String meterNumber;

	@Value("${fedex.user.key}")
	protected String key;

	@Value("${fedex.user.password}")
	protected String password;

	public TrackingServiceImpl(TrackingApi trackingApi) {
		this.trackingApi = trackingApi;
	}

	@Override
	public TrackingResponse sendRequest(TrackingRequest trackingRequest) {
		String xmlTrackingRequest = null;
		String xmlUpsAccessRequest = null;
		String xmlTrackingResponse = null;
		ObjectMapper objectMapper = new XmlMapper();
		if (Constants.USPS.equalsIgnoreCase(trackingRequest.getCarrier())) {
			TrackID trackId = new TrackID(trackingRequest.getTrackingNumber());
			UspsTrackingRequest uspsTrackingRequest = UspsTrackingRequest.builder().trackId(trackId).userId(uspsUserId)
					.revision("1").sourceId(Constants.SOURCE_ID).clientIp(Constants.CLINET_IP)
					.sourceIdZIP(Constants.SOURCE_ID_ZIP).build();
			try {
				xmlTrackingRequest = objectMapper.writeValueAsString(uspsTrackingRequest);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			xmlTrackingResponse = trackingApi.getUSPSResponse(xmlTrackingRequest);
			return buildTrackingResponseFromUSPS(xmlTrackingResponse, trackingRequest);
		}

		else if (Constants.UPS.equalsIgnoreCase(trackingRequest.getCarrier())) {
			UpsAccessRequest upsAccessRequest = UpsAccessRequest.builder().accessLicenseNumber(upsAccessLicenseNumber)
					.userId(upsUserId).password(upsUserPassword).build();
			TransactionReference tf = TransactionReference.builder().customerContext("Shipment Tracking")
					.xpciVersion("1.0").build();
			Request request = Request.builder().transactionReference(tf).requestAction("Track")
					.requestOption("activity").build();
			UpsTrackingRequest upsTrackingRequest = UpsTrackingRequest.builder().request(request)
					.trackingNumber(trackingRequest.getTrackingNumber()).build();
			try {
				xmlUpsAccessRequest = objectMapper.writeValueAsString(upsAccessRequest);
				xmlTrackingRequest = xmlUpsAccessRequest + objectMapper.writeValueAsString(upsTrackingRequest);

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			xmlTrackingResponse = trackingApi.getUPSResponse(xmlTrackingRequest);
			return buildTrackingResponseFromUPS(xmlTrackingResponse, trackingRequest);
		}

		else if (Constants.FEDEX.equalsIgnoreCase(trackingRequest.getCarrier())) {
			TrackRequest request = new TrackRequest();
			request.setClientDetail(createClientDetail());
			request.setWebAuthenticationDetail(createWebAuthenticationDetail());
			//
			TransactionDetail transactionDetail = new TransactionDetail();
			transactionDetail.setCustomerTransactionId("java sample - Tracking Request");
			request.setTransactionDetail(transactionDetail);
			//
			VersionId versionId = new VersionId("trck", 14, 0, 0);
			request.setVersion(versionId);
			//
			TrackSelectionDetail selectionDetail = new TrackSelectionDetail();
			TrackPackageIdentifier packageIdentifier = new TrackPackageIdentifier();
			packageIdentifier.setType(TrackIdentifierType.TRACKING_NUMBER_OR_DOORTAG);
			packageIdentifier.setValue(trackingRequest.getTrackingNumber());
			selectionDetail.setPackageIdentifier(packageIdentifier);
			request.setSelectionDetails(new TrackSelectionDetail[] { selectionDetail });
			TrackRequestProcessingOptionType processingOption = TrackRequestProcessingOptionType.INCLUDE_DETAILED_SCANS;
			request.setProcessingOptions(new TrackRequestProcessingOptionType[] { processingOption });

			TrackReply reply = trackingApi.getFEDEXResponse(request);
			return buildTrackingResponseFromFEDEX(reply, trackingRequest);
		}
		return TrackingResponse.builder().error("Unsupported Carrier or Carrier is missing to track shipment status")
				.build();
	}

	private TrackingResponse buildTrackingResponseFromUSPS(String uspsXmlResponse, TrackingRequest trackingRequest) {
		TrackingResponse trackingResponse = new TrackingResponse();
		try {
			SAXBuilder xmlToDocumentBuilder = new SAXBuilder();
			Document document = xmlToDocumentBuilder.build(new StringReader(uspsXmlResponse));
			if (document.getRootElement().getChild("TrackInfo") != null) {
				if (document.getRootElement().getChild("TrackInfo").getChild("StatusCategory") != null) {
					String status = document.getRootElement().getChild("TrackInfo").getChild("StatusCategory")
							.getValue();
					trackingResponse.setStatus(status);
				}
				if (document.getRootElement().getChild("TrackInfo").getChild("StatusSummary") != null) {
					String statusSummary = document.getRootElement().getChild("TrackInfo").getChild("StatusSummary")
							.getValue();
					trackingResponse.setDescription(statusSummary);
				} else if (document.getRootElement().getChild("TrackInfo").getChild("Error") != null) {
					String error = document.getRootElement().getChild("TrackInfo").getChild("Error")
							.getChild("Description").getValue();
					trackingResponse.setError(error);
				}
			} else if ("Error".equals(document.getRootElement().getName())) {
				String error = document.getRootElement().getChild("Description").getValue();
				trackingResponse.setError(error);
			}
			trackingResponse.setTrackingId(trackingRequest.getTrackingNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trackingResponse;
	}

	private TrackingResponse buildTrackingResponseFromUPS(String upsXmlResponse, TrackingRequest trackingRequest) {
		TrackingResponse trackingResponse = new TrackingResponse();
		try {
			SAXBuilder xmlToDocumentBuilder = new SAXBuilder();
			Document document = xmlToDocumentBuilder.build(new StringReader(upsXmlResponse));
			if (document.getRootElement().getChild("Shipment") != null) {
				if (document.getRootElement().getChild("Shipment").getChild("Package").getChild("Activity")
						.getChild("Status").getChild("StatusType").getChild("Description") != null) {
					String status = document.getRootElement().getChild("Shipment").getChild("Package")
							.getChild("Activity").getChild("Status").getChild("StatusType").getChild("Description")
							.getValue();
					trackingResponse.setStatus(status);
				}
			} else if ("Error".equals(document.getRootElement().getChild("Response").getChild("Error").getName())) {
				String error = document.getRootElement().getChild("Response").getChild("Error")
						.getChild("ErrorDescription").getValue();
				trackingResponse.setError(error);
			}
			trackingResponse.setTrackingId(trackingRequest.getTrackingNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trackingResponse;
	}

	private TrackingResponse buildTrackingResponseFromFEDEX(TrackReply reply, TrackingRequest trackingRequest) {
		String status = null;
		String error = null;
		boolean isSuccess = isNotificationSuccess(reply.getNotifications());
		if (isSuccess) {
			status = getCompletedTrackDetail(reply.getCompletedTrackDetails());
		}
		if (status == null && isSuccess)
			error = reply.getCompletedTrackDetails()[0].getTrackDetails(0).getNotification().getMessage();
		else if (!isSuccess)
			error = reply.getNotifications()[0].getMessage();

		return TrackingResponse.builder().trackingId(trackingRequest.getTrackingNumber()).status(status).error(error)
				.build();
	}

	private static boolean isNotificationSuccess(Object n) {
		boolean cont = true;
		if (n != null) {
			Notification[] notifications = null;
			Notification notification = null;
			if (n instanceof Notification[]) {
				notifications = (Notification[]) n;
				if (notifications == null || notifications.length == 0) {
					System.out.println("  No notifications returned");
				}
				for (int i = 0; i < notifications.length; i++) {
					if (!success(notifications[i])) {
						cont = false;
					}
				}
			} else if (n instanceof Notification) {
				notification = (Notification) n;
				if (!success(notification)) {
					cont = false;
				}
			}
		}
		return cont;
	}

	private static boolean success(Notification notification) {
		Boolean cont = true;
		if (notification != null) {
			if (notification.getSeverity() == NotificationSeverityType.FAILURE
					|| notification.getSeverity() == NotificationSeverityType.ERROR) {
				cont = false;
			}
		}
		return cont;
	}

	private static String getCompletedTrackDetail(CompletedTrackDetail[] ctd) {
		String status = null;
		for (int i = 0; i < ctd.length; i++) { // package detail information
			CompletedTrackDetail completedTrackDetail = ctd[i];
			if (completedTrackDetail.getTrackDetails() != null) {
				status = getTrackDetail(completedTrackDetail.getTrackDetails());
			}
		}
		return status;
	}

	private static String getTrackDetail(TrackDetail[] td) {
		String status = null;
		for (int i = 0; i < td.length; i++) {
			TrackDetail trackDetail = td[i];
			if (trackDetail.getStatusDetail() != null) {
				status = trackDetail.getStatusDetail().getDescription();
			}
		}
		return status;
	}

	private ClientDetail createClientDetail() {
		ClientDetail clientDetail = new ClientDetail();
		clientDetail.setAccountNumber(accountNumber);
		clientDetail.setMeterNumber(meterNumber);
		return clientDetail;
	}

	private WebAuthenticationDetail createWebAuthenticationDetail() {
		WebAuthenticationCredential userCredential = new WebAuthenticationCredential();
		userCredential.setKey(key);
		userCredential.setPassword(password);
		WebAuthenticationCredential parentCredential = null;
		Boolean useParentCredential = false; // Set this value to true is using a parent credential

		if (useParentCredential) {
			String parentKey = "XXX";
			String parentPassword = "XXX";
			parentCredential = new WebAuthenticationCredential();
			parentCredential.setKey(parentKey);
			parentCredential.setPassword(parentPassword);
		}
		return new WebAuthenticationDetail(parentCredential, userCredential);
	}
}
