package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the citizennotification database table.
 * 
 */
@Entity
@NamedQuery(name="Citizennotification.findAll", query="SELECT c FROM Citizennotification c")
public class Citizennotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer citizennotificationid;

	private String areacode;

	private String availabletime;

	private String countrycode;

	private String firstlastname;

	private String firstname;

	private String primaryemail;

	private String relationship;

	private String telephonenumber;

	private String telephonetype;

	//bi-directional many-to-one association to Citizen
	@ManyToOne
	@JoinColumn(name="citizenid")
	private Citizen citizen;

	public Citizennotification() {
	}

	public Integer getCitizennotificationid() {
		return this.citizennotificationid;
	}

	public void setCitizennotificationid(Integer citizennotificationid) {
		this.citizennotificationid = citizennotificationid;
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

	public String getCountrycode() {
		return this.countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getFirstlastname() {
		return this.firstlastname;
	}

	public void setFirstlastname(String firstlastname) {
		this.firstlastname = firstlastname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPrimaryemail() {
		return this.primaryemail;
	}

	public void setPrimaryemail(String primaryemail) {
		this.primaryemail = primaryemail;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
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