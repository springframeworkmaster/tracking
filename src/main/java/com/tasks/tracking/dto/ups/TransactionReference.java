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
@JacksonXmlRootElement(localName = "TransactionReference")
public class TransactionReference {

    @JacksonXmlProperty(localName = "CustomerContext", isAttribute = false)
    private String customerContext;

    @JacksonXmlProperty(localName = "XpciVersion", isAttribute = false)
    private String xpciVersion;
}
