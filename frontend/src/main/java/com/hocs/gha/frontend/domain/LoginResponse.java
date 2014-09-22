

package com.hocs.gha.frontend.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loginResponse complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="loginResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/schema3}ghaResponse">
 *       &lt;sequence>
 *         &lt;element name="blocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="invalidPassword" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="accountInactivate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="userNotExists" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="numAttemps" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bpuData" type="{http://www.example.org/schema3}bpuData"/>
 *         &lt;element name="bpiDefault" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginResponse", propOrder = {
    "blocked",
    "invalidPassword",
    "accountInactivate",
    "userNotExists",
    "numAttemps",
    "bpuData",
    "bpiDefault"
})
public class LoginResponse extends GhaResponse {

    @XmlElement(namespace = "http://www.example.org/schema3")
    protected boolean blocked;
    @XmlElement(namespace = "http://www.example.org/schema3")
    protected boolean invalidPassword;
    @XmlElement(namespace = "http://www.example.org/schema3")
    protected boolean accountInactivate;
    @XmlElement(namespace = "http://www.example.org/schema3")
    protected boolean userNotExists;
    @XmlElement(namespace = "http://www.example.org/schema3")
    protected int numAttemps;
    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected BpuData bpuData;
    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected int bpiDefault;

    /**
     * Gets the value of the blocked property.
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * Sets the value of the blocked property.
     */
    public void setBlocked(boolean value) {
        this.blocked = value;
    }

    /**
     * Gets the value of the invalidPassword property.
     */
    public boolean isInvalidPassword() {
        return invalidPassword;
    }

    /**
     * Sets the value of the invalidPassword property.
     */
    public void setInvalidPassword(boolean value) {
        this.invalidPassword = value;
    }

    /**
     * Gets the value of the accountInactivate property.
     */
    public boolean isAccountInactivate() {
        return accountInactivate;
    }

    /**
     * Sets the value of the accountInactivate property.
     */
    public void setAccountInactivate(boolean value) {
        this.accountInactivate = value;
    }

    /**
     * Gets the value of the userNotExists property.
     */
    public boolean isUserNotExists() {
        return userNotExists;
    }

    /**
     * Sets the value of the userNotExists property.
     */
    public void setUserNotExists(boolean value) {
        this.userNotExists = value;
    }

    /**
     * Gets the value of the numAttemps property.
     */
    public int getNumAttemps() {
        return numAttemps;
    }

    /**
     * Sets the value of the numAttemps property.
     */
    public void setNumAttemps(int value) {
        this.numAttemps = value;
    }

    /**
     * Gets the value of the bpuData property.
     *
     * @return possible object is
     * {@link BpuData }
     */
    public BpuData getBpuData() {
        return bpuData;
    }

    /**
     * Sets the value of the bpuData property.
     *
     * @param value allowed object is
     *              {@link BpuData }
     */
    public void setBpuData(BpuData value) {
        this.bpuData = value;
    }

    /**
     * Gets the value of the bpiDefault property.
     */
    public int getBpiDefault() {
        return bpiDefault;
    }

    /**
     * Sets the value of the bpiDefault property.
     */
    public void setBpiDefault(int value) {
        this.bpiDefault = value;
    }

}
