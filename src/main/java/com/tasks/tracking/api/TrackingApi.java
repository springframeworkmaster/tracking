package com.tasks.tracking.api;



import org.springframework.web.client.RestClientException;

import com.tasks.tracking.dto.fedex.TrackReply;
import com.tasks.tracking.dto.fedex.TrackRequest;

public interface TrackingApi {

    String getUSPSResponse(String xmlRequest) throws RestClientException;

    String getUPSResponse(String xmlRequest);

    TrackReply getFEDEXResponse(TrackRequest request);
}
