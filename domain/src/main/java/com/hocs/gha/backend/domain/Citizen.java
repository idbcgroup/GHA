package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the citizen database table.
 * 
 */
@Entity
@NamedQuery(name="Citizen.findAll", query="SELECT c FROM Citizen c")
public class Citizen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer citizenid;

	private String alternativeemail;

	private String birthcity;

	private String birthcountry;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private String birthmunicipality;

	private String birthparish;

	private String birthstate;

	private String bloodgroup;

	private String ethnicgroup;

	private String firstlastname;

	private String firstname;

	private String fiscalregistrationcode;

	private String gender;

	private String iddocumentnumber;

	private String iddocumenttype;

	private BigDecimal illiterate;

	private String instructiondegree;

	private String joblevel;

	private String jobtype;

	private String laterality;

	private String maritalstatus;

	private String migratorystatus;

	private String mixstatus;

	private String nationality;

	private String nationalitytype;

	private String occupation;

	private String primaryemail;

	private String race;

	private String religion;

	private String rhfactor;

	private String secondlastname;

	private String secondname;

	private String socialsecuritycode;

	private BigDecimal timeincountry;

	private String transportationtype;

	private String unitoftime;

	private BigDecimal vehicleowner;

	private String vehicletype;

	//bi-directional many-to-one association to Legalentity
	@ManyToOne
	@JoinColumn(name="legalentitycode")
	private Legalentity legalentity;

	//bi-directional many-to-one association to Citizencontact
	@OneToMany(mappedBy="citizen")
	private List<Citizencontact> citizencontacts;

	//bi-directional many-to-one association to Citizeneducation
	@OneToMany(mappedBy="citizen")
	private List<Citizeneducation> citizeneducations;

	//bi-directional many-to-one association to Citizenfamily
	@OneToMany(mappedBy="citizen1")
	private List<Citizenfamily> citizenfamilies1;

	//bi-directional many-to-one association to Citizenfamily
	@OneToMany(mappedBy="citizen2")
	private List<Citizenfamily> citizenfamilies2;

	//bi-directional many-to-one association to Citizennotification
	@OneToMany(mappedBy="citizen")
	private List<Citizennotification> citizennotifications;

	//bi-directional many-to-one association to Indexbycitizen
	@OneToMany(mappedBy="citizen")
	private List<Indexbycitizen> indexbycitizens;

	public Citizen() {
	}

	public Integer getCitizenid() {
		return this.citizenid;
	}

	public void setCitizenid(Integer citizenid) {
		this.citizenid = citizenid;
	}

	public String getAlternativeemail() {
		return this.alternativeemail;
	}

	public void setAlternativeemail(String alternativeemail) {
		this.alternativeemail = alternativeemail;
	}

	public String getBirthcity() {
		return this.birthcity;
	}

	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}

	public String getBirthcountry() {
		return this.birthcountry;
	}

	public void setBirthcountry(String birthcountry) {
		this.birthcountry = birthcountry;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthmunicipality() {
		return this.birthmunicipality;
	}

	public void setBirthmunicipality(String birthmunicipality) {
		this.birthmunicipality = birthmunicipality;
	}

	public String getBirthparish() {
		return this.birthparish;
	}

	public void setBirthparish(String birthparish) {
		this.birthparish = birthparish;
	}

	public String getBirthstate() {
		return this.birthstate;
	}

	public void setBirthstate(String birthstate) {
		this.birthstate = birthstate;
	}

	public String getBloodgroup() {
		return this.bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getEthnicgroup() {
		return this.ethnicgroup;
	}

	public void setEthnicgroup(String ethnicgroup) {
		this.ethnicgroup = ethnicgroup;
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

	public String getFiscalregistrationcode() {
		return this.fiscalregistrationcode;
	}

	public void setFiscalregistrationcode(String fiscalregistrationcode) {
		this.fiscalregistrationcode = fiscalregistrationcode;
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

	public BigDecimal getIlliterate() {
		return this.illiterate;
	}

	public void setIlliterate(BigDecimal illiterate) {
		this.illiterate = illiterate;
	}

	public String getInstructiondegree() {
		return this.instructiondegree;
	}

	public void setInstructiondegree(String instructiondegree) {
		this.instructiondegree = instructiondegree;
	}

	public String getJoblevel() {
		return this.joblevel;
	}

	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	public String getJobtype() {
		return this.jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getLaterality() {
		return this.laterality;
	}

	public void setLaterality(String laterality) {
		this.laterality = laterality;
	}

	public String getMaritalstatus() {
		return this.maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getMigratorystatus() {
		return this.migratorystatus;
	}

	public void setMigratorystatus(String migratorystatus) {
		this.migratorystatus = migratorystatus;
	}

	public String getMixstatus() {
		return this.mixstatus;
	}

	public void setMixstatus(String mixstatus) {
		this.mixstatus = mixstatus;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationalitytype() {
		return this.nationalitytype;
	}

	public void setNationalitytype(String nationalitytype) {
		this.nationalitytype = nationalitytype;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPrimaryemail() {
		return this.primaryemail;
	}

	public void setPrimaryemail(String primaryemail) {
		this.primaryemail = primaryemail;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getRhfactor() {
		return this.rhfactor;
	}

	public void setRhfactor(String rhfactor) {
		this.rhfactor = rhfactor;
	}

	public String getSecondlastname() {
		return this.secondlastname;
	}

	public void setSecondlastname(String secondlastname) {
		this.secondlastname = secondlastname;
	}

	public String getSecondname() {
		return this.secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getSocialsecuritycode() {
		return this.socialsecuritycode;
	}

	public void setSocialsecuritycode(String socialsecuritycode) {
		this.socialsecuritycode = socialsecuritycode;
	}

	public BigDecimal getTimeincountry() {
		return this.timeincountry;
	}

	public void setTimeincountry(BigDecimal timeincountry) {
		this.timeincountry = timeincountry;
	}

	public String getTransportationtype() {
		return this.transportationtype;
	}

	public void setTransportationtype(String transportationtype) {
		this.transportationtype = transportationtype;
	}

	public String getUnitoftime() {
		return this.unitoftime;
	}

	public void setUnitoftime(String unitoftime) {
		this.unitoftime = unitoftime;
	}

	public BigDecimal getVehicleowner() {
		return this.vehicleowner;
	}

	public void setVehicleowner(BigDecimal vehicleowner) {
		this.vehicleowner = vehicleowner;
	}

	public String getVehicletype() {
		return this.vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public Legalentity getLegalentity() {
		return this.legalentity;
	}

	public void setLegalentity(Legalentity legalentity) {
		this.legalentity = legalentity;
	}

	public List<Citizencontact> getCitizencontacts() {
		return this.citizencontacts;
	}

	public void setCitizencontacts(List<Citizencontact> citizencontacts) {
		this.citizencontacts = citizencontacts;
	}

	public Citizencontact addCitizencontact(Citizencontact citizencontact) {
		getCitizencontacts().add(citizencontact);
		citizencontact.setCitizen(this);

		return citizencontact;
	}

	public Citizencontact removeCitizencontact(Citizencontact citizencontact) {
		getCitizencontacts().remove(citizencontact);
		citizencontact.setCitizen(null);

		return citizencontact;
	}

	public List<Citizeneducation> getCitizeneducations() {
		return this.citizeneducations;
	}

	public void setCitizeneducations(List<Citizeneducation> citizeneducations) {
		this.citizeneducations = citizeneducations;
	}

	public Citizeneducation addCitizeneducation(Citizeneducation citizeneducation) {
		getCitizeneducations().add(citizeneducation);
		citizeneducation.setCitizen(this);

		return citizeneducation;
	}

	public Citizeneducation removeCitizeneducation(Citizeneducation citizeneducation) {
		getCitizeneducations().remove(citizeneducation);
		citizeneducation.setCitizen(null);

		return citizeneducation;
	}

	public List<Citizenfamily> getCitizenfamilies1() {
		return this.citizenfamilies1;
	}

	public void setCitizenfamilies1(List<Citizenfamily> citizenfamilies1) {
		this.citizenfamilies1 = citizenfamilies1;
	}

	public Citizenfamily addCitizenfamilies1(Citizenfamily citizenfamilies1) {
		getCitizenfamilies1().add(citizenfamilies1);
		citizenfamilies1.setCitizen1(this);

		return citizenfamilies1;
	}

	public Citizenfamily removeCitizenfamilies1(Citizenfamily citizenfamilies1) {
		getCitizenfamilies1().remove(citizenfamilies1);
		citizenfamilies1.setCitizen1(null);

		return citizenfamilies1;
	}

	public List<Citizenfamily> getCitizenfamilies2() {
		return this.citizenfamilies2;
	}

	public void setCitizenfamilies2(List<Citizenfamily> citizenfamilies2) {
		this.citizenfamilies2 = citizenfamilies2;
	}

	public Citizenfamily addCitizenfamilies2(Citizenfamily citizenfamilies2) {
		getCitizenfamilies2().add(citizenfamilies2);
		citizenfamilies2.setCitizen2(this);

		return citizenfamilies2;
	}

	public Citizenfamily removeCitizenfamilies2(Citizenfamily citizenfamilies2) {
		getCitizenfamilies2().remove(citizenfamilies2);
		citizenfamilies2.setCitizen2(null);

		return citizenfamilies2;
	}

	public List<Citizennotification> getCitizennotifications() {
		return this.citizennotifications;
	}

	public void setCitizennotifications(List<Citizennotification> citizennotifications) {
		this.citizennotifications = citizennotifications;
	}

	public Citizennotification addCitizennotification(Citizennotification citizennotification) {
		getCitizennotifications().add(citizennotification);
		citizennotification.setCitizen(this);

		return citizennotification;
	}

	public Citizennotification removeCitizennotification(Citizennotification citizennotification) {
		getCitizennotifications().remove(citizennotification);
		citizennotification.setCitizen(null);

		return citizennotification;
	}

	public List<Indexbycitizen> getIndexbycitizens() {
		return this.indexbycitizens;
	}

	public void setIndexbycitizens(List<Indexbycitizen> indexbycitizens) {
		this.indexbycitizens = indexbycitizens;
	}

	public Indexbycitizen addIndexbycitizen(Indexbycitizen indexbycitizen) {
		getIndexbycitizens().add(indexbycitizen);
		indexbycitizen.setCitizen(this);

		return indexbycitizen;
	}

	public Indexbycitizen removeIndexbycitizen(Indexbycitizen indexbycitizen) {
		getIndexbycitizens().remove(indexbycitizen);
		indexbycitizen.setCitizen(null);

		return indexbycitizen;
	}

}