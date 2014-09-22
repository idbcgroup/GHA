package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the legalentityaddress database table.
 * 
 */
@Entity
@NamedQuery(name="Legalentityaddress.findAll", query="SELECT l FROM Legalentityaddress l")
public class Legalentityaddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer addressid;

	private String addressrelationtype;

	private String addresstype;

	private String areacode;

	private String avenuename;

	private String avenuetype;

	private String city;

	private String country;

	private String countrycode;

	private String floor;

	private String municipality;

	private String parish;

	private String propertyname;

	private String propertynumber;

	private String propertytype;

	private String referenceplace;

	private String residentialzone;

	private String residentialzonename;

	private String state;

	private String telephonenumber;

	private String telephonetype;

	private BigDecimal zipcode;

	//bi-directional many-to-one association to Legalentity
	@ManyToOne
	@JoinColumn(name="legalentitycode")
	private Legalentity legalentity;

	public Legalentityaddress() {
	}

	public Integer getAddressid() {
		return this.addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public String getAddressrelationtype() {
		return this.addressrelationtype;
	}

	public void setAddressrelationtype(String addressrelationtype) {
		this.addressrelationtype = addressrelationtype;
	}

	public String getAddresstype() {
		return this.addresstype;
	}

	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getAvenuename() {
		return this.avenuename;
	}

	public void setAvenuename(String avenuename) {
		this.avenuename = avenuename;
	}

	public String getAvenuetype() {
		return this.avenuetype;
	}

	public void setAvenuetype(String avenuetype) {
		this.avenuetype = avenuetype;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountrycode() {
		return this.countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getFloor() {
		return this.floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getMunicipality() {
		return this.municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getParish() {
		return this.parish;
	}

	public void setParish(String parish) {
		this.parish = parish;
	}

	public String getPropertyname() {
		return this.propertyname;
	}

	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}

	public String getPropertynumber() {
		return this.propertynumber;
	}

	public void setPropertynumber(String propertynumber) {
		this.propertynumber = propertynumber;
	}

	public String getPropertytype() {
		return this.propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}

	public String getReferenceplace() {
		return this.referenceplace;
	}

	public void setReferenceplace(String referenceplace) {
		this.referenceplace = referenceplace;
	}

	public String getResidentialzone() {
		return this.residentialzone;
	}

	public void setResidentialzone(String residentialzone) {
		this.residentialzone = residentialzone;
	}

	public String getResidentialzonename() {
		return this.residentialzonename;
	}

	public void setResidentialzonename(String residentialzonename) {
		this.residentialzonename = residentialzonename;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTelephonenumber() {
		return this.telephonenumber;
	}

	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}

	public String getTelephonetype() {
		return this.telephonetype;
	}

	public void setTelephonetype(String telephonetype) {
		this.telephonetype = telephonetype;
	}

	public BigDecimal getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(BigDecimal zipcode) {
		this.zipcode = zipcode;
	}

	public Legalentity getLegalentity() {
		return this.legalentity;
	}

	public void setLegalentity(Legalentity legalentity) {
		this.legalentity = legalentity;
	}

}