package com.tasks.tracking.api;

import java.util.Locale;

import com.tasks.tracking.dto.fedex.TrackPortType;
import com.tasks.tracking.dto.fedex.TrackReply;
import com.tasks.tracking.dto.fedex.TrackRequest;
import com.tasks.tracking.dto.fedex.TrackServiceLocator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RefreshScope
public class TrackingApiImpl implements TrackingApi {

    private final RestTemplate restTemplate;
    private final MessageSource messageSource;

    @Value("${usps.api.url}")
    protected String uspsUrl;

    @Value("${ups.api.url}")
    protected String upsUrl;

    @Value("${fedex.api.url}")
    protected String fedexUrl;

    public TrackingApiImpl(RestTemplate client, MessageSource messageSource) {
        this.restTemplate = client;
        this.messageSource = messageSource;
    }

    @Override
    public String getUSPSResponse(String xmlRequest) {
        String apiUrl = uspsUrl + xmlRequest;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        ResponseEntity<String> uspsResponse = restTemplate.exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers),
                String.class);
        return uspsResponse.getBody();
    }

    @Override
    public String getUPSResponse(String xmlRequest) {
        String apiUrl = upsUrl;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> httpEntity = new HttpEntity<String>(xmlRequest, headers);
        ResponseEntity<String> upsResponse = restTemplate.exchange(apiUrl, HttpMethod.POST, httpEntity, String.class);
        return upsResponse.getBody();
    }

    @Override
    public TrackReply getFEDEXResponse(TrackRequest request) {
        TrackReply reply = null;
        try {
            TrackServiceLocator service;
            TrackPortType port;
            service = new TrackServiceLocator();
            updateEndPoint(service);
            port = service.getTrackServicePort();
            reply = port.track(request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    messageSource.getMessage("uri.not.found", new Object[] {  }, Locale.US));
        }
        return reply;
    }

    private void updateEndPoint(TrackServiceLocator serviceLocator) {
        if (fedexUrl != null) {
            serviceLocator.setTrackServicePortEndpointAddress(fedexUrl);
        }
    }
}
