/**
 * SendNotificationsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tasks.tracking.dto.fedex;

public class SendNotificationsRequest  implements java.io.Serializable {
    /* Descriptive data to be used in authentication of the sender's
     * identity (and right to use FedEx web services). */
    private WebAuthenticationDetail webAuthenticationDetail;

    /* Descriptive data identifying the client submitting the transaction. */
    private ClientDetail clientDetail;

    /* Contains a free form field that is echoed back in the reply
     * to match requests with replies and data that governs the data payload
     * language/translations */
    private TransactionDetail transactionDetail;

    private VersionId version;

    /* The tracking number to which the notifications will be triggered
     * from. */
    private java.lang.String trackingNumber;

    /* Indicates whether to return tracking information for all associated
     * packages. */
    private java.lang.Boolean multiPiece;

    /* When the MoreDataAvailable field is true in a TrackNotificationReply
     * the PagingToken must be sent in the subsequent TrackNotificationRequest
     * to retrieve the next page of data. */
    private java.lang.String pagingToken;

    /* Use this field when your original request informs you that
     * there are duplicates of this tracking number. If you get duplicates
     * you will also receive some information about each of the duplicate
     * tracking numbers to enable you to chose one and resend that number
     * along with the TrackingNumberUniqueId to get notifications for that
     * tracking number. */
    private java.lang.String trackingNumberUniqueId;

    /* To narrow the search to a period in time the ShipDateRangeBegin
     * and ShipDateRangeEnd can be used to help eliminate duplicates. */
    private java.util.Date shipDateRangeBegin;

    /* To narrow the search to a period in time the ShipDateRangeBegin
     * and ShipDateRangeEnd can be used to help eliminate duplicates. */
    private java.util.Date shipDateRangeEnd;

    /* Included in the email notification identifying the requester
     * of this notification. */
    private java.lang.String senderEMailAddress;

    /* Included in the email notification identifying the requester
     * of this notification. */
    private java.lang.String senderContactName;

    /* This replaces eMailNotificationDetail */
    private ShipmentEventNotificationDetail eventNotificationDetail;

    public SendNotificationsRequest() {
    }

    public SendNotificationsRequest(
           WebAuthenticationDetail webAuthenticationDetail,
           ClientDetail clientDetail,
           TransactionDetail transactionDetail,
           VersionId version,
           java.lang.String trackingNumber,
           java.lang.Boolean multiPiece,
           java.lang.String pagingToken,
           java.lang.String trackingNumberUniqueId,
           java.util.Date shipDateRangeBegin,
           java.util.Date shipDateRangeEnd,
           java.lang.String senderEMailAddress,
           java.lang.String senderContactName,
           ShipmentEventNotificationDetail eventNotificationDetail) {
           this.webAuthenticationDetail = webAuthenticationDetail;
           this.clientDetail = clientDetail;
           this.transactionDetail = transactionDetail;
           this.version = version;
           this.trackingNumber = trackingNumber;
           this.multiPiece = multiPiece;
           this.pagingToken = pagingToken;
           this.trackingNumberUniqueId = trackingNumberUniqueId;
           this.shipDateRangeBegin = shipDateRangeBegin;
           this.shipDateRangeEnd = shipDateRangeEnd;
           this.senderEMailAddress = senderEMailAddress;
           this.senderContactName = senderContactName;
           this.eventNotificationDetail = eventNotificationDetail;
    }


    /**
     * Gets the webAuthenticationDetail value for this SendNotificationsRequest.
     * 
     * @return webAuthenticationDetail   * Descriptive data to be used in authentication of the sender's
     * identity (and right to use FedEx web services).
     */
    public WebAuthenticationDetail getWebAuthenticationDetail() {
        return webAuthenticationDetail;
    }


    /**
     * Sets the webAuthenticationDetail value for this SendNotificationsRequest.
     * 
     * @param webAuthenticationDetail   * Descriptive data to be used in authentication of the sender's
     * identity (and right to use FedEx web services).
     */
    public void setWebAuthenticationDetail(WebAuthenticationDetail webAuthenticationDetail) {
        this.webAuthenticationDetail = webAuthenticationDetail;
    }


    /**
     * Gets the clientDetail value for this SendNotificationsRequest.
     * 
     * @return clientDetail   * Descriptive data identifying the client submitting the transaction.
     */
    public ClientDetail getClientDetail() {
        return clientDetail;
    }


    /**
     * Sets the clientDetail value for this SendNotificationsRequest.
     * 
     * @param clientDetail   * Descriptive data identifying the client submitting the transaction.
     */
    public void setClientDetail(ClientDetail clientDetail) {
        this.clientDetail = clientDetail;
    }


    /**
     * Gets the transactionDetail value for this SendNotificationsRequest.
     * 
     * @return transactionDetail   * Contains a free form field that is echoed back in the reply
     * to match requests with replies and data that governs the data payload
     * language/translations
     */
    public TransactionDetail getTransactionDetail() {
        return transactionDetail;
    }


    /**
     * Sets the transactionDetail value for this SendNotificationsRequest.
     * 
     * @param transactionDetail   * Contains a free form field that is echoed back in the reply
     * to match requests with replies and data that governs the data payload
     * language/translations
     */
    public void setTransactionDetail(TransactionDetail transactionDetail) {
        this.transactionDetail = transactionDetail;
    }


    /**
     * Gets the version value for this SendNotificationsRequest.
     * 
     * @return version
     */
    public VersionId getVersion() {
        return version;
    }


    /**
     * Sets the version value for this SendNotificationsRequest.
     * 
     * @param version
     */
    public void setVersion(VersionId version) {
        this.version = version;
    }


    /**
     * Gets the trackingNumber value for this SendNotificationsRequest.
     * 
     * @return trackingNumber   * The tracking number to which the notifications will be triggered
     * from.
     */
    public java.lang.String getTrackingNumber() {
        return trackingNumber;
    }


    /**
     * Sets the trackingNumber value for this SendNotificationsRequest.
     * 
     * @param trackingNumber   * The tracking number to which the notifications will be triggered
     * from.
     */
    public void setTrackingNumber(java.lang.String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }


    /**
     * Gets the multiPiece value for this SendNotificationsRequest.
     * 
     * @return multiPiece   * Indicates whether to return tracking information for all associated
     * packages.
     */
    public java.lang.Boolean getMultiPiece() {
        return multiPiece;
    }


    /**
     * Sets the multiPiece value for this SendNotificationsRequest.
     * 
     * @param multiPiece   * Indicates whether to return tracking information for all associated
     * packages.
     */
    public void setMultiPiece(java.lang.Boolean multiPiece) {
        this.multiPiece = multiPiece;
    }


    /**
     * Gets the pagingToken value for this SendNotificationsRequest.
     * 
     * @return pagingToken   * When the MoreDataAvailable field is true in a TrackNotificationReply
     * the PagingToken must be sent in the subsequent TrackNotificationRequest
     * to retrieve the next page of data.
     */
    public java.lang.String getPagingToken() {
        return pagingToken;
    }


    /**
     * Sets the pagingToken value for this SendNotificationsRequest.
     * 
     * @param pagingToken   * When the MoreDataAvailable field is true in a TrackNotificationReply
     * the PagingToken must be sent in the subsequent TrackNotificationRequest
     * to retrieve the next page of data.
     */
    public void setPagingToken(java.lang.String pagingToken) {
        this.pagingToken = pagingToken;
    }


    /**
     * Gets the trackingNumberUniqueId value for this SendNotificationsRequest.
     * 
     * @return trackingNumberUniqueId   * Use this field when your original request informs you that
     * there are duplicates of this tracking number. If you get duplicates
     * you will also receive some information about each of the duplicate
     * tracking numbers to enable you to chose one and resend that number
     * along with the TrackingNumberUniqueId to get notifications for that
     * tracking number.
     */
    public java.lang.String getTrackingNumberUniqueId() {
        return trackingNumberUniqueId;
    }


    /**
     * Sets the trackingNumberUniqueId value for this SendNotificationsRequest.
     * 
     * @param trackingNumberUniqueId   * Use this field when your original request informs you that
     * there are duplicates of this tracking number. If you get duplicates
     * you will also receive some information about each of the duplicate
     * tracking numbers to enable you to chose one and resend that number
     * along with the TrackingNumberUniqueId to get notifications for that
     * tracking number.
     */
    public void setTrackingNumberUniqueId(java.lang.String trackingNumberUniqueId) {
        this.trackingNumberUniqueId = trackingNumberUniqueId;
    }


    /**
     * Gets the shipDateRangeBegin value for this SendNotificationsRequest.
     * 
     * @return shipDateRangeBegin   * To narrow the search to a period in time the ShipDateRangeBegin
     * and ShipDateRangeEnd can be used to help eliminate duplicates.
     */
    public java.util.Date getShipDateRangeBegin() {
        return shipDateRangeBegin;
    }


    /**
     * Sets the shipDateRangeBegin value for this SendNotificationsRequest.
     * 
     * @param shipDateRangeBegin   * To narrow the search to a period in time the ShipDateRangeBegin
     * and ShipDateRangeEnd can be used to help eliminate duplicates.
     */
    public void setShipDateRangeBegin(java.util.Date shipDateRangeBegin) {
        this.shipDateRangeBegin = shipDateRangeBegin;
    }


    /**
     * Gets the shipDateRangeEnd value for this SendNotificationsRequest.
     * 
     * @return shipDateRangeEnd   * To narrow the search to a period in time the ShipDateRangeBegin
     * and ShipDateRangeEnd can be used to help eliminate duplicates.
     */
    public java.util.Date getShipDateRangeEnd() {
        return shipDateRangeEnd;
    }


    /**
     * Sets the shipDateRangeEnd value for this SendNotificationsRequest.
     * 
     * @param shipDateRangeEnd   * To narrow the search to a period in time the ShipDateRangeBegin
     * and ShipDateRangeEnd can be used to help eliminate duplicates.
     */
    public void setShipDateRangeEnd(java.util.Date shipDateRangeEnd) {
        this.shipDateRangeEnd = shipDateRangeEnd;
    }


    /**
     * Gets the senderEMailAddress value for this SendNotificationsRequest.
     * 
     * @return senderEMailAddress   * Included in the email notification identifying the requester
     * of this notification.
     */
    public java.lang.String getSenderEMailAddress() {
        return senderEMailAddress;
    }


    /**
     * Sets the senderEMailAddress value for this SendNotificationsRequest.
     * 
     * @param senderEMailAddress   * Included in the email notification identifying the requester
     * of this notification.
     */
    public void setSenderEMailAddress(java.lang.String senderEMailAddress) {
        this.senderEMailAddress = senderEMailAddress;
    }


    /**
     * Gets the senderContactName value for this SendNotificationsRequest.
     * 
     * @return senderContactName   * Included in the email notification identifying the requester
     * of this notification.
     */
    public java.lang.String getSenderContactName() {
        return senderContactName;
    }


    /**
     * Sets the senderContactName value for this SendNotificationsRequest.
     * 
     * @param senderContactName   * Included in the email notification identifying the requester
     * of this notification.
     */
    public void setSenderContactName(java.lang.String senderContactName) {
        this.senderContactName = senderContactName;
    }


    /**
     * Gets the eventNotificationDetail value for this SendNotificationsRequest.
     * 
     * @return eventNotificationDetail   * This replaces eMailNotificationDetail
     */
    public ShipmentEventNotificationDetail getEventNotificationDetail() {
        return eventNotificationDetail;
    }


    /**
     * Sets the eventNotificationDetail value for this SendNotificationsRequest.
     * 
     * @param eventNotificationDetail   * This replaces eMailNotificationDetail
     */
    public void setEventNotificationDetail(ShipmentEventNotificationDetail eventNotificationDetail) {
        this.eventNotificationDetail = eventNotificationDetail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendNotificationsRequest)) return false;
        SendNotificationsRequest other = (SendNotificationsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.webAuthenticationDetail==null && other.getWebAuthenticationDetail()==null) || 
             (this.webAuthenticationDetail!=null &&
              this.webAuthenticationDetail.equals(other.getWebAuthenticationDetail()))) &&
            ((this.clientDetail==null && other.getClientDetail()==null) || 
             (this.clientDetail!=null &&
              this.clientDetail.equals(other.getClientDetail()))) &&
            ((this.transactionDetail==null && other.getTransactionDetail()==null) || 
             (this.transactionDetail!=null &&
              this.transactionDetail.equals(other.getTransactionDetail()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.trackingNumber==null && other.getTrackingNumber()==null) || 
             (this.trackingNumber!=null &&
              this.trackingNumber.equals(other.getTrackingNumber()))) &&
            ((this.multiPiece==null && other.getMultiPiece()==null) || 
             (this.multiPiece!=null &&
              this.multiPiece.equals(other.getMultiPiece()))) &&
            ((this.pagingToken==null && other.getPagingToken()==null) || 
             (this.pagingToken!=null &&
              this.pagingToken.equals(other.getPagingToken()))) &&
            ((this.trackingNumberUniqueId==null && other.getTrackingNumberUniqueId()==null) || 
             (this.trackingNumberUniqueId!=null &&
              this.trackingNumberUniqueId.equals(other.getTrackingNumberUniqueId()))) &&
            ((this.shipDateRangeBegin==null && other.getShipDateRangeBegin()==null) || 
             (this.shipDateRangeBegin!=null &&
              this.shipDateRangeBegin.equals(other.getShipDateRangeBegin()))) &&
            ((this.shipDateRangeEnd==null && other.getShipDateRangeEnd()==null) || 
             (this.shipDateRangeEnd!=null &&
              this.shipDateRangeEnd.equals(other.getShipDateRangeEnd()))) &&
            ((this.senderEMailAddress==null && other.getSenderEMailAddress()==null) || 
             (this.senderEMailAddress!=null &&
              this.senderEMailAddress.equals(other.getSenderEMailAddress()))) &&
            ((this.senderContactName==null && other.getSenderContactName()==null) || 
             (this.senderContactName!=null &&
              this.senderContactName.equals(other.getSenderContactName()))) &&
            ((this.eventNotificationDetail==null && other.getEventNotificationDetail()==null) || 
             (this.eventNotificationDetail!=null &&
              this.eventNotificationDetail.equals(other.getEventNotificationDetail())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getWebAuthenticationDetail() != null) {
            _hashCode += getWebAuthenticationDetail().hashCode();
        }
        if (getClientDetail() != null) {
            _hashCode += getClientDetail().hashCode();
        }
        if (getTransactionDetail() != null) {
            _hashCode += getTransactionDetail().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getTrackingNumber() != null) {
            _hashCode += getTrackingNumber().hashCode();
        }
        if (getMultiPiece() != null) {
            _hashCode += getMultiPiece().hashCode();
        }
        if (getPagingToken() != null) {
            _hashCode += getPagingToken().hashCode();
        }
        if (getTrackingNumberUniqueId() != null) {
            _hashCode += getTrackingNumberUniqueId().hashCode();
        }
        if (getShipDateRangeBegin() != null) {
            _hashCode += getShipDateRangeBegin().hashCode();
        }
        if (getShipDateRangeEnd() != null) {
            _hashCode += getShipDateRangeEnd().hashCode();
        }
        if (getSenderEMailAddress() != null) {
            _hashCode += getSenderEMailAddress().hashCode();
        }
        if (getSenderContactName() != null) {
            _hashCode += getSenderContactName().hashCode();
        }
        if (getEventNotificationDetail() != null) {
            _hashCode += getEventNotificationDetail().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendNotificationsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "SendNotificationsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("webAuthenticationDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "WebAuthenticationDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "WebAuthenticationDetail"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "ClientDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "ClientDetail"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "TransactionDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "TransactionDetail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "Version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "VersionId"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackingNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "TrackingNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("multiPiece");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "MultiPiece"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagingToken");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "PagingToken"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackingNumberUniqueId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "TrackingNumberUniqueId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shipDateRangeBegin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "ShipDateRangeBegin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shipDateRangeEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "ShipDateRangeEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderEMailAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "SenderEMailAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderContactName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "SenderContactName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventNotificationDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "EventNotificationDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://fedex.com/ws/track/v14", "ShipmentEventNotificationDetail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
