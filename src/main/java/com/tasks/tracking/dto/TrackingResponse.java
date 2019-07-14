package com.tasks.tracking.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrackingResponse {

    @JsonProperty("TrackingNumber")
    private String trackingId;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Error")
    private String error;
    @JsonProperty("Description")
    private String description;
}
