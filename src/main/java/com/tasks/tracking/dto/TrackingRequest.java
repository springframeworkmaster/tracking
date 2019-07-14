package com.tasks.tracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TrackingRequest {

    @JsonProperty("Carrier")
    private String carrier;
    @JsonProperty("TrackingNumber")
    private String trackingNumber;
}
