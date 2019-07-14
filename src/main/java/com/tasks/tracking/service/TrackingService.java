package com.tasks.tracking.service;

import com.tasks.tracking.dto.TrackingRequest;
import com.tasks.tracking.dto.TrackingResponse;

public interface TrackingService {
	TrackingResponse sendRequest(TrackingRequest trackingRequest);
}
