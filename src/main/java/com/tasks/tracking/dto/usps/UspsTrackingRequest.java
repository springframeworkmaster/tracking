package com.tasks.tracking.dto.usps;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JacksonXmlRootElement(localName = "TrackFieldRequest")
public final class UspsTrackingRequest {

    @JacksonXmlProperty(localName = "USERID", isAttribute = true)
    private String userId;

    @JacksonXmlProperty(localName = "Revision", isAttribute = false)
    private String revision;

    @JacksonXmlProperty(localName = "ClientIp", isAttribute = false)
    private String clientIp;

    @JacksonXmlProperty(localName = "SourceId", isAttribute = false)
    private String sourceId;

    @JacksonXmlProperty(localName = "SourceIdZIP", isAttribute = false)
    private String sourceIdZIP;

    @JacksonXmlProperty(localName = "TrackID", isAttribute = false)
    private TrackID trackId;
}
