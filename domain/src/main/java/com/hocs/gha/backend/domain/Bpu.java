package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bpu database table.
 * 
 */
@Entity
@NamedQuery(name="Bpu.findAll", query="SELECT b FROM Bpu b")
public class Bpu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String bpucode;

	private BigDecimal bpuabsencetime;

	@Temporal(TemporalType.DATE)
	private Date bpubirthdate;

	private String bpubpirelationship;

	private BigDecimal bpucitizenid;

	private BigDecimal bpucurrentshift;

	private String bpudelegationstatus;

	private String bpuemail;

	private String bpufullname;

	private String bpugender;

	private String bpuhomephone;

	@Temporal(TemporalType.DATE)
	private Date bpuhoraryabsence;

	private Boolean bpuisemployee;

	private Boolean bpuissystemuser;

	private String bpulogstatus;

	private String bpumobilephone;

	private String bpumotiveabsence;

	private Boolean bpumultipleroles;

	private String bpunotifemail;

	private String bpuofficephone;

	private String bpuprefix;

	private String bpurank;

	private String bpushiftonduty;

	private String bpuspecialtycode;

	private String bpuspecialtyname;

	private String bpustatus;

	@Temporal(TemporalType.DATE)
	private Date bpustatuscurrentdate;

	private String bpustatuscurrentday;

	private String bpusubspecialtycode;

	private String bpusubspecialtyname;

	private String bpuusername;

	private String initialactiononlogon;

	private String initialform;

	//bi-directional many-to-one association to Accessgroupassigned
	@OneToMany(mappedBy="bpu")
	private List<Accessgroupassigned> accessgroupassigneds;

	//bi-directional many-to-one association to Bpa
	@ManyToOne
	@JoinColumn(name="bpacode")
	private Bpa bpa;

	//bi-directional many-to-one association to Bpi
	@ManyToOne
	@JoinColumn(name="bpicode")
	private Bpi bpi;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	//bi-directional many-to-one association to Jobposition
	@ManyToOne
	@JoinColumn(name="jobpositionid")
	private Jobposition jobposition;

	//bi-directional many-to-one association to Shift
	@ManyToOne
	@JoinColumn(name="shiftid")
	private Shift shift;

	//bi-directional many-to-one association to Bpuinstitution
	@OneToMany(mappedBy="bpu")
	private List<Bpuinstitution> bpuinstitutions;

	//bi-directional many-to-one association to Bpuinwa
	@OneToMany(mappedBy="bpu")
	private List<Bpuinwa> bpuinwas;

	//bi-directional many-to-one association to Systemerrlog
	@OneToMany(mappedBy="bpu")
	private List<Systemerrlog> systemerrlogs;

	public Bpu() {
	}

	public String getBpucode() {
		return this.bpucode;
	}

	public void setBpucode(String bpucode) {
		this.bpucode = bpucode;
	}

	public BigDecimal getBpuabsencetime() {
		return this.bpuabsencetime;
	}

	public void setBpuabsencetime(BigDecimal bpuabsencetime) {
		this.bpuabsencetime = bpuabsencetime;
	}

	public Date getBpubirthdate() {
		return this.bpubirthdate;
	}

	public void setBpubirthdate(Date bpubirthdate) {
		this.bpubirthdate = bpubirthdate;
	}

	public String getBpubpirelationship() {
		return this.bpubpirelationship;
	}

	public void setBpubpirelationship(String bpubpirelationship) {
		this.bpubpirelationship = bpubpirelationship;
	}

	public BigDecimal getBpucitizenid() {
		return this.bpucitizenid;
	}

	public void setBpucitizenid(BigDecimal bpucitizenid) {
		this.bpucitizenid = bpucitizenid;
	}

	public BigDecimal getBpucurrentshift() {
		return this.bpucurrentshift;
	}

	public void setBpucurrentshift(BigDecimal bpucurrentshift) {
		this.bpucurrentshift = bpucurrentshift;
	}

	public String getBpudelegationstatus() {
		return this.bpudelegationstatus;
	}

	public void setBpudelegationstatus(String bpudelegationstatus) {
		this.bpudelegationstatus = bpudelegationstatus;
	}

	public String getBpuemail() {
		return this.bpuemail;
	}

	public void setBpuemail(String bpuemail) {
		this.bpuemail = bpuemail;
	}

	public String getBpufullname() {
		return this.bpufullname;
	}

	public void setBpufullname(String bpufullname) {
		this.bpufullname = bpufullname;
	}

	public String getBpugender() {
		return this.bpugender;
	}

	public void setBpugender(String bpugender) {
		this.bpugender = bpugender;
	}

	public String getBpuhomephone() {
		return this.bpuhomephone;
	}

	public void setBpuhomephone(String bpuhomephone) {
		this.bpuhomephone = bpuhomephone;
	}

	public Date getBpuhoraryabsence() {
		return this.bpuhoraryabsence;
	}

	public void setBpuhoraryabsence(Date bpuhoraryabsence) {
		this.bpuhoraryabsence = bpuhoraryabsence;
	}

	public Boolean getBpuisemployee() {
		return this.bpuisemployee;
	}

	public void setBpuisemployee(Boolean bpuisemployee) {
		this.bpuisemployee = bpuisemployee;
	}

	public Boolean getBpuissystemuser() {
		return this.bpuissystemuser;
	}

	public void setBpuissystemuser(Boolean bpuissystemuser) {
		this.bpuissystemuser = bpuissystemuser;
	}

	public String getBpulogstatus() {
		return this.bpulogstatus;
	}

	public void setBpulogstatus(String bpulogstatus) {
		this.bpulogstatus = bpulogstatus;
	}

	public String getBpumobilephone() {
		return this.bpumobilephone;
	}

	public void setBpumobilephone(String bpumobilephone) {
		this.bpumobilephone = bpumobilephone;
	}

	public String getBpumotiveabsence() {
		return this.bpumotiveabsence;
	}

	public void setBpumotiveabsence(String bpumotiveabsence) {
		this.bpumotiveabsence = bpumotiveabsence;
	}

	public Boolean getBpumultipleroles() {
		return this.bpumultipleroles;
	}

	public void setBpumultipleroles(Boolean bpumultipleroles) {
		this.bpumultipleroles = bpumultipleroles;
	}

	public String getBpunotifemail() {
		return this.bpunotifemail;
	}

	public void setBpunotifemail(String bpunotifemail) {
		this.bpunotifemail = bpunotifemail;
	}

	public String getBpuofficephone() {
		return this.bpuofficephone;
	}

	public void setBpuofficephone(String bpuofficephone) {
		this.bpuofficephone = bpuofficephone;
	}

	public String getBpuprefix() {
		return this.bpuprefix;
	}

	public void setBpuprefix(String bpuprefix) {
		this.bpuprefix = bpuprefix;
	}

	public String getBpurank() {
		return this.bpurank;
	}

	public void setBpurank(String bpurank) {
		this.bpurank = bpurank;
	}

	public String getBpushiftonduty() {
		return this.bpushiftonduty;
	}

	public void setBpushiftonduty(String bpushiftonduty) {
		this.bpushiftonduty = bpushiftonduty;
	}

	public String getBpuspecialtycode() {
		return this.bpuspecialtycode;
	}

	public void setBpuspecialtycode(String bpuspecialtycode) {
		this.bpuspecialtycode = bpuspecialtycode;
	}

	public String getBpuspecialtyname() {
		return this.bpuspecialtyname;
	}

	public void setBpuspecialtyname(String bpuspecialtyname) {
		this.bpuspecialtyname = bpuspecialtyname;
	}

	public String getBpustatus() {
		return this.bpustatus;
	}

	public void setBpustatus(String bpustatus) {
		this.bpustatus = bpustatus;
	}

	public Date getBpustatuscurrentdate() {
		return this.bpustatuscurrentdate;
	}

	public void setBpustatuscurrentdate(Date bpustatuscurrentdate) {
		this.bpustatuscurrentdate = bpustatuscurrentdate;
	}

	public String getBpustatuscurrentday() {
		return this.bpustatuscurrentday;
	}

	public void setBpustatuscurrentday(String bpustatuscurrentday) {
		this.bpustatuscurrentday = bpustatuscurrentday;
	}

	public String getBpusubspecialtycode() {
		return this.bpusubspecialtycode;
	}

	public void setBpusubspecialtycode(String bpusubspecialtycode) {
		this.bpusubspecialtycode = bpusubspecialtycode;
	}

	public String getBpusubspecialtyname() {
		return this.bpusubspecialtyname;
	}

	public void setBpusubspecialtyname(String bpusubspecialtyname) {
		this.bpusubspecialtyname = bpusubspecialtyname;
	}

	public String getBpuusername() {
		return this.bpuusername;
	}

	public void setBpuusername(String bpuusername) {
		this.bpuusername = bpuusername;
	}

	public String getInitialactiononlogon() {
		return this.initialactiononlogon;
	}

	public void setInitialactiononlogon(String initialactiononlogon) {
		this.initialactiononlogon = initialactiononlogon;
	}

	public String getInitialform() {
		return this.initialform;
	}

	public void setInitialform(String initialform) {
		this.initialform = initialform;
	}

	public List<Accessgroupassigned> getAccessgroupassigneds() {
		return this.accessgroupassigneds;
	}

	public void setAccessgroupassigneds(List<Accessgroupassigned> accessgroupassigneds) {
		this.accessgroupassigneds = accessgroupassigneds;
	}

	public Accessgroupassigned addAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().add(accessgroupassigned);
		accessgroupassigned.setBpu(this);

		return accessgroupassigned;
	}

	public Accessgroupassigned removeAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().remove(accessgroupassigned);
		accessgroupassigned.setBpu(null);

		return accessgroupassigned;
	}

	public Bpa getBpa() {
		return this.bpa;
	}

	public void setBpa(Bpa bpa) {
		this.bpa = bpa;
	}

	public Bpi getBpi() {
		return this.bpi;
	}

	public void setBpi(Bpi bpi) {
		this.bpi = bpi;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Jobposition getJobposition() {
		return this.jobposition;
	}

	public void setJobposition(Jobposition jobposition) {
		this.jobposition = jobposition;
	}

	public Shift getShift() {
		return this.shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public List<Bpuinstitution> getBpuinstitutions() {
		return this.bpuinstitutions;
	}

	public void setBpuinstitutions(List<Bpuinstitution> bpuinstitutions) {
		this.bpuinstitutions = bpuinstitutions;
	}

	public Bpuinstitution addBpuinstitution(Bpuinstitution bpuinstitution) {
		getBpuinstitutions().add(bpuinstitution);
		bpuinstitution.setBpu(this);

		return bpuinstitution;
	}

	public Bpuinstitution removeBpuinstitution(Bpuinstitution bpuinstitution) {
		getBpuinstitutions().remove(bpuinstitution);
		bpuinstitution.setBpu(null);

		return bpuinstitution;
	}

	public List<Bpuinwa> getBpuinwas() {
		return this.bpuinwas;
	}

	public void setBpuinwas(List<Bpuinwa> bpuinwas) {
		this.bpuinwas = bpuinwas;
	}

	public Bpuinwa addBpuinwa(Bpuinwa bpuinwa) {
		getBpuinwas().add(bpuinwa);
		bpuinwa.setBpu(this);

		return bpuinwa;
	}

	public Bpuinwa removeBpuinwa(Bpuinwa bpuinwa) {
		getBpuinwas().remove(bpuinwa);
		bpuinwa.setBpu(null);

		return bpuinwa;
	}

	public List<Systemerrlog> getSystemerrlogs() {
		return this.systemerrlogs;
	}

	public void setSystemerrlogs(List<Systemerrlog> systemerrlogs) {
		this.systemerrlogs = systemerrlogs;
	}

	public Systemerrlog addSystemerrlog(Systemerrlog systemerrlog) {
		getSystemerrlogs().add(systemerrlog);
		systemerrlog.setBpu(this);

		return systemerrlog;
	}

	public Systemerrlog removeSystemerrlog(Systemerrlog systemerrlog) {
		getSystemerrlogs().remove(systemerrlog);
		systemerrlog.setBpu(null);

		return systemerrlog;
	}

}