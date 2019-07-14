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
@JacksonXmlRootElement(localName = "Request")
public class Request {

    @JacksonXmlProperty(localName = "TransactionReference", isAttribute = false)
    private TransactionReference transactionReference;

    @JacksonXmlProperty(localName = "RequestAction", isAttribute = false)
    private String requestAction;

    @JacksonXmlProperty(localName = "RequestOption", isAttribute = false)
    private String requestOption;

}
