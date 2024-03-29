//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.05 at 05:22:28 PM UTC 
//


package com.hocs.gha.frontend.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataGlobalParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataGlobalParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bpiParameter" type="{http://www.example.org/schema3}bpiParameter"/>
 *         &lt;element name="operationParameter" type="{http://www.example.org/schema3}operationParameter"/>
 *         &lt;element name="messageParameter" type="{http://www.example.org/schema3}messageParameter"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataGlobalParameters", namespace = "http://www.example.org/schema3", propOrder = {
    "bpiParameter",
    "operationParameter",
    "messageParameter"
})
public class DataGlobalParameters {

    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected BpiParameter bpiParameter;
    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected OperationParameter operationParameter;
    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected MessageParameter messageParameter;

    /**
     * Gets the value of the bpiParameter property.
     * 
     * @return
     *     possible object is
     *     {@link BpiParameter }
     *     
     */
    public BpiParameter getBpiParameter() {
        return bpiParameter;
    }

    /**
     * Sets the value of the bpiParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BpiParameter }
     *     
     */
    public void setBpiParameter(BpiParameter value) {
        this.bpiParameter = value;
    }

    /**
     * Gets the value of the operationParameter property.
     * 
     * @return
     *     possible object is
     *     {@link OperationParameter }
     *     
     */
    public OperationParameter getOperationParameter() {
        return operationParameter;
    }

    /**
     * Sets the value of the operationParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationParameter }
     *     
     */
    public void setOperationParameter(OperationParameter value) {
        this.operationParameter = value;
    }

    /**
     * Gets the value of the messageParameter property.
     * 
     * @return
     *     possible object is
     *     {@link MessageParameter }
     *     
     */
    public MessageParameter getMessageParameter() {
        return messageParameter;
    }

    /**
     * Sets the value of the messageParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageParameter }
     *     
     */
    public void setMessageParameter(MessageParameter value) {
        this.messageParameter = value;
    }

}
