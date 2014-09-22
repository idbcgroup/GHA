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
 * <p>Java class for dataGlobalInfoPacks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataGlobalInfoPacks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bpiPack" type="{http://www.example.org/schema3}InfoPack"/>
 *         &lt;element name="accessPack" type="{http://www.example.org/schema3}InfoPack"/>
 *         &lt;element name="terminalPack" type="{http://www.example.org/schema3}InfoPack"/>
 *         &lt;element name="peripherialPack" type="{http://www.example.org/schema3}InfoPack"/>
 *         &lt;element name="bpuPack" type="{http://www.example.org/schema3}bpuPack"/>
 *         &lt;element name="bpuAccessPack" type="{http://www.example.org/schema3}bpuAccessPack"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataGlobalInfoPacks", namespace = "http://www.example.org/schema3", propOrder = {
    "bpiPack",
    "accessPack",
    "terminalPack",
    "peripherialPack",
    "bpuPack",
    "bpuAccessPack"
})
public class DataGlobalInfoPacks {

    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected InfoPack bpiPack;
    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected InfoPack accessPack;
    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected InfoPack terminalPack;
    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected InfoPack peripherialPack;
    @XmlElement(required = true)
    protected BpuPack bpuPack;
    @XmlElement(required = true)
    protected BpuAccessPack bpuAccessPack;

    /**
     * Gets the value of the bpiPack property.
     * 
     * @return
     *     possible object is
     *     {@link InfoPack }
     *     
     */
    public InfoPack getBpiPack() {
        return bpiPack;
    }

    /**
     * Sets the value of the bpiPack property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoPack }
     *     
     */
    public void setBpiPack(InfoPack value) {
        this.bpiPack = value;
    }

    /**
     * Gets the value of the accessPack property.
     * 
     * @return
     *     possible object is
     *     {@link InfoPack }
     *     
     */
    public InfoPack getAccessPack() {
        return accessPack;
    }

    /**
     * Sets the value of the accessPack property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoPack }
     *     
     */
    public void setAccessPack(InfoPack value) {
        this.accessPack = value;
    }

    /**
     * Gets the value of the terminalPack property.
     * 
     * @return
     *     possible object is
     *     {@link InfoPack }
     *     
     */
    public InfoPack getTerminalPack() {
        return terminalPack;
    }

    /**
     * Sets the value of the terminalPack property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoPack }
     *     
     */
    public void setTerminalPack(InfoPack value) {
        this.terminalPack = value;
    }

    /**
     * Gets the value of the peripherialPack property.
     * 
     * @return
     *     possible object is
     *     {@link InfoPack }
     *     
     */
    public InfoPack getPeripherialPack() {
        return peripherialPack;
    }

    /**
     * Sets the value of the peripherialPack property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoPack }
     *     
     */
    public void setPeripherialPack(InfoPack value) {
        this.peripherialPack = value;
    }

    /**
     * Gets the value of the bpuPack property.
     * 
     * @return
     *     possible object is
     *     {@link BpuPack }
     *     
     */
    public BpuPack getBpuPack() {
        return bpuPack;
    }

    /**
     * Sets the value of the bpuPack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BpuPack }
     *     
     */
    public void setBpuPack(BpuPack value) {
        this.bpuPack = value;
    }

    /**
     * Gets the value of the bpuAccessPack property.
     * 
     * @return
     *     possible object is
     *     {@link BpuAccessPack }
     *     
     */
    public BpuAccessPack getBpuAccessPack() {
        return bpuAccessPack;
    }

    /**
     * Sets the value of the bpuAccessPack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BpuAccessPack }
     *     
     */
    public void setBpuAccessPack(BpuAccessPack value) {
        this.bpuAccessPack = value;
    }

}