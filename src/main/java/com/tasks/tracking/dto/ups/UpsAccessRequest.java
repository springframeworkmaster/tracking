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
@JacksonXmlRootElement(localName = "AccessRequest")
public class UpsAccessRequest {
    @JacksonXmlProperty(localName = "AccessLicenseNumber", isAttribute = false)
    private String accessLicenseNumber;

    @JacksonXmlProperty(localName = "UserId", isAttribute = false)
    private String userId;

    @JacksonXmlProperty(localName = "Password", isAttribute = false)
    private String password;
}
