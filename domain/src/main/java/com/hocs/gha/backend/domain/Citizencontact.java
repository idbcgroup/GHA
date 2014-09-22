package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the citizencontact database table.
 * 
 */
@Entity
@NamedQuery(name="Citizencontact.findAll", query="SELECT c FROM Citizencontact c")
public class Citizencontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer citizencontactid;

	private String areacode;

	private String availabletime;

	private String contactemail;

	private String contactfirstname;

	private String contactlastname;

	private String contactrelation;

	private String contactrelationtype;

	private String countrycode;

	private String telephonenumber;

	private String telephonetype;

	//bi-directional many-to-one association to Citizen
	@ManyToOne
	@JoinColumn(name="citizenid")
	private Citizen citizen;

	public Citizencontact() {
	}

	public Integer getCitizencontactid() {
		return this.citizencontactid;
	}

	public void setCitizencontactid(Integer citizencontactid) {
		this.citizencontactid = citizencontactid;
	}

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getAvailabletime() {
		return this.availabletime;
	}

	public void setAvailabletime(String availabletime) {
		this.availabletime = availabletime;
	}

	public String getContactemail() {
		return this.contactemail;
	}

	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	public String getContactfirstname() {
		return this.contactfirstname;
	}

	public void setContactfirstname(String contactfirstname) {
		this.contactfirstname = contactfirstname;
	}

	public String getContactlastname() {
		return this.contactlastname;
	}

	public void setContactlastname(String contactlastname) {
		this.contactlastname = contactlastname;
	}

	public String getContactrelation() {
		return this.contactrelation;
	}

	public void setContactrelation(String contactrelation) {
		this.contactrelation = contactrelation;
	}

	public String getContactrelationtype() {
		return this.contactrelationtype;
	}

	public void setContactrelationtype(String contactrelationtype) {
		this.contactrelationtype = contactrelationtype;
	}

	public String getCountrycode() {
		return this.countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
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

	public Citizen getCitizen() {
		return this.citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

}