package com.tasks.tracking.dto.usps;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JacksonXmlRootElement(localName = "TrackID")
public final class TrackID {
    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String id;
}
