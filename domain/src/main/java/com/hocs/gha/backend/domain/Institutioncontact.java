package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institutioncontact database table.
 * 
 */
@Entity
@NamedQuery(name="Institutioncontact.findAll", query="SELECT i FROM Institutioncontact i")
public class Institutioncontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer institutioncontactid;

	private String alternativeemail;

	private String areacode;

	private String availabletime;

	private String contactstype;

	private String countrycode;

	private String firstlastname;

	private String firstname;

	private String jobposition;

	private String primaryemail;

	private String telephonenumber;

	private String telephonetype;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	public Institutioncontact() {
	}

	public Integer getInstitutioncontactid() {
		return this.institutioncontactid;
	}

	public void setInstitutioncontactid(Integer institutioncontactid) {
		this.institutioncontactid = institutioncontactid;
	}

	public String getAlternativeemail() {
		return this.alternativeemail;
	}

	public void setAlternativeemail(String alternativeemail) {
		this.alternativeemail = alternativeemail;
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

	public String getContactstype() {
		return this.contactstype;
	}

	public void setContactstype(String contactstype) {
		this.contactstype = contactstype;
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

	public String getJobposition() {
		return this.jobposition;
	}

	public void setJobposition(String jobposition) {
		this.jobposition = jobposition;
	}

	public String getPrimaryemail() {
		return this.primaryemail;
	}

	public void setPrimaryemail(String primaryemail) {
		this.primaryemail = primaryemail;
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

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}