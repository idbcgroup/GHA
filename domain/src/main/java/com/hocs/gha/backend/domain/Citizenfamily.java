package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the citizenfamily database table.
 * 
 */
@Entity
@NamedQuery(name="Citizenfamily.findAll", query="SELECT c FROM Citizenfamily c")
public class Citizenfamily implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer citizenfamilyid;

	private String areacode;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private String citizensrelationship;

	private String countrycode;

	private String firstlastname;

	private String firstname;

	private String gender;

	private String iddocumentnumber;

	private String iddocumenttype;

	private BigDecimal legalrepresentative;

	private String nationality;

	private String telephonenumber;

	private String telephonetype;

	//bi-directional many-to-one association to Citizen
	@ManyToOne
	@JoinColumn(name="citizenid")
	private Citizen citizen1;

	//bi-directional many-to-one association to Citizen
	@ManyToOne
	@JoinColumn(name="familycitizenid")
	private Citizen citizen2;

	public Citizenfamily() {
	}

	public Integer getCitizenfamilyid() {
		return this.citizenfamilyid;
	}

	public void setCitizenfamilyid(Integer citizenfamilyid) {
		this.citizenfamilyid = citizenfamilyid;
	}

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCitizensrelationship() {
		return this.citizensrelationship;
	}

	public void setCitizensrelationship(String citizensrelationship) {
		this.citizensrelationship = citizensrelationship;
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

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIddocumentnumber() {
		return this.iddocumentnumber;
	}

	public void setIddocumentnumber(String iddocumentnumber) {
		this.iddocumentnumber = iddocumentnumber;
	}

	public String getIddocumenttype() {
		return this.iddocumenttype;
	}

	public void setIddocumenttype(String iddocumenttype) {
		this.iddocumenttype = iddocumenttype;
	}

	public BigDecimal getLegalrepresentative() {
		return this.legalrepresentative;
	}

	public void setLegalrepresentative(BigDecimal legalrepresentative) {
		this.legalrepresentative = legalrepresentative;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public Citizen getCitizen1() {
		return this.citizen1;
	}

	public void setCitizen1(Citizen citizen1) {
		this.citizen1 = citizen1;
	}

	public Citizen getCitizen2() {
		return this.citizen2;
	}

	public void setCitizen2(Citizen citizen2) {
		this.citizen2 = citizen2;
	}

}