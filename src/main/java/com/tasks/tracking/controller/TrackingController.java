
package com.tasks.tracking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.tracking.dto.TrackingRequest;
import com.tasks.tracking.dto.TrackingResponse;
import com.tasks.tracking.service.TrackingService;

import lombok.AllArgsConstructor;

@RequestMapping(value = "/v1/tracking")
@RestController
@AllArgsConstructor
public class TrackingController {
    private final TrackingService trackingService;

    @PostMapping
    public TrackingResponse sendRequest(@RequestBody TrackingRequest trackingRequest) {
        return trackingService.sendRequest(trackingRequest);
    }
}