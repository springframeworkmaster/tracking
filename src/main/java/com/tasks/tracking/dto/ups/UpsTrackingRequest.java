package com.tasks.tracking.dto.ups;

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
@JacksonXmlRootElement(localName = "TrackRequest")
public class UpsTrackingRequest {

    @JacksonXmlProperty(localName = "Request", isAttribute = false)
    private Request request;

    @JacksonXmlProperty(localName = "TrackingNumber", isAttribute = false)
    private String trackingNumber;
}
