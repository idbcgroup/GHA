package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the institution database table.
 * 
 */
@Entity
@NamedQuery(name="Institution.findAll", query="SELECT i FROM Institution i")
public class Institution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer institutionid;

	private String iddocumentnumber;

	private String institutiondescription;

	private String institutionhealthcode;

	private String institutionlevel;

	private String institutionname;

	private String institutionprincipalproduct;

	private String institutionproductivesector;

	private String institutionproductivesubsector;

	private String institutionrisk;

	private String institutionsectortype;

	private String institutiontaxcode;

	private String institutiontype;

	//bi-directional many-to-one association to Bpi
	@OneToMany(mappedBy="institution")
	private List<Bpi> bpis;

	//bi-directional many-to-one association to Bpu
	@OneToMany(mappedBy="institution")
	private List<Bpu> bpus;

	//bi-directional many-to-one association to Bpuinstitution
	@OneToMany(mappedBy="institution")
	private List<Bpuinstitution> bpuinstitutions;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionparent")
	private Institution institution;

	//bi-directional many-to-one association to Institution
	@OneToMany(mappedBy="institution")
	private List<Institution> institutions;

	//bi-directional many-to-one association to Legalentity
	@ManyToOne
	@JoinColumn(name="legalentitycode")
	private Legalentity legalentity;

	//bi-directional many-to-one association to Institutioncontact
	@OneToMany(mappedBy="institution")
	private List<Institutioncontact> institutioncontacts;

	//bi-directional many-to-one association to Systeminstance
	@OneToMany(mappedBy="institution")
	private List<Systeminstance> systeminstances;

	//bi-directional many-to-one association to Workingholiday
	@OneToMany(mappedBy="institution")
	private List<Workingholiday> workingholidays;

	public Institution() {
	}

	public Integer getInstitutionid() {
		return this.institutionid;
	}

	public void setInstitutionid(Integer institutionid) {
		this.institutionid = institutionid;
	}

	public String getIddocumentnumber() {
		return this.iddocumentnumber;
	}

	public void setIddocumentnumber(String iddocumentnumber) {
		this.iddocumentnumber = iddocumentnumber;
	}

	public String getInstitutiondescription() {
		return this.institutiondescription;
	}

	public void setInstitutiondescription(String institutiondescription) {
		this.institutiondescription = institutiondescription;
	}

	public String getInstitutionhealthcode() {
		return this.institutionhealthcode;
	}

	public void setInstitutionhealthcode(String institutionhealthcode) {
		this.institutionhealthcode = institutionhealthcode;
	}

	public String getInstitutionlevel() {
		return this.institutionlevel;
	}

	public void setInstitutionlevel(String institutionlevel) {
		this.institutionlevel = institutionlevel;
	}

	public String getInstitutionname() {
		return this.institutionname;
	}

	public void setInstitutionname(String institutionname) {
		this.institutionname = institutionname;
	}

	public String getInstitutionprincipalproduct() {
		return this.institutionprincipalproduct;
	}

	public void setInstitutionprincipalproduct(String institutionprincipalproduct) {
		this.institutionprincipalproduct = institutionprincipalproduct;
	}

	public String getInstitutionproductivesector() {
		return this.institutionproductivesector;
	}

	public void setInstitutionproductivesector(String institutionproductivesector) {
		this.institutionproductivesector = institutionproductivesector;
	}

	public String getInstitutionproductivesubsector() {
		return this.institutionproductivesubsector;
	}

	public void setInstitutionproductivesubsector(String institutionproductivesubsector) {
		this.institutionproductivesubsector = institutionproductivesubsector;
	}

	public String getInstitutionrisk() {
		return this.institutionrisk;
	}

	public void setInstitutionrisk(String institutionrisk) {
		this.institutionrisk = institutionrisk;
	}

	public String getInstitutionsectortype() {
		return this.institutionsectortype;
	}

	public void setInstitutionsectortype(String institutionsectortype) {
		this.institutionsectortype = institutionsectortype;
	}

	public String getInstitutiontaxcode() {
		return this.institutiontaxcode;
	}

	public void setInstitutiontaxcode(String institutiontaxcode) {
		this.institutiontaxcode = institutiontaxcode;
	}

	public String getInstitutiontype() {
		return this.institutiontype;
	}

	public void setInstitutiontype(String institutiontype) {
		this.institutiontype = institutiontype;
	}

	public List<Bpi> getBpis() {
		return this.bpis;
	}

	public void setBpis(List<Bpi> bpis) {
		this.bpis = bpis;
	}

	public Bpi addBpi(Bpi bpi) {
		getBpis().add(bpi);
		bpi.setInstitution(this);

		return bpi;
	}

	public Bpi removeBpi(Bpi bpi) {
		getBpis().remove(bpi);
		bpi.setInstitution(null);

		return bpi;
	}

	public List<Bpu> getBpus() {
		return this.bpus;
	}

	public void setBpus(List<Bpu> bpus) {
		this.bpus = bpus;
	}

	public Bpu addBpus(Bpu bpus) {
		getBpus().add(bpus);
		bpus.setInstitution(this);

		return bpus;
	}

	public Bpu removeBpus(Bpu bpus) {
		getBpus().remove(bpus);
		bpus.setInstitution(null);

		return bpus;
	}

	public List<Bpuinstitution> getBpuinstitutions() {
		return this.bpuinstitutions;
	}

	public void setBpuinstitutions(List<Bpuinstitution> bpuinstitutions) {
		this.bpuinstitutions = bpuinstitutions;
	}

	public Bpuinstitution addBpuinstitution(Bpuinstitution bpuinstitution) {
		getBpuinstitutions().add(bpuinstitution);
		bpuinstitution.setInstitution(this);

		return bpuinstitution;
	}

	public Bpuinstitution removeBpuinstitution(Bpuinstitution bpuinstitution) {
		getBpuinstitutions().remove(bpuinstitution);
		bpuinstitution.setInstitution(null);

		return bpuinstitution;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<Institution> getInstitutions() {
		return this.institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}

	public Institution addInstitution(Institution institution) {
		getInstitutions().add(institution);
		institution.setInstitution(this);

		return institution;
	}

	public Institution removeInstitution(Institution institution) {
		getInstitutions().remove(institution);
		institution.setInstitution(null);

		return institution;
	}

	public Legalentity getLegalentity() {
		return this.legalentity;
	}

	public void setLegalentity(Legalentity legalentity) {
		this.legalentity = legalentity;
	}

	public List<Institutioncontact> getInstitutioncontacts() {
		return this.institutioncontacts;
	}

	public void setInstitutioncontacts(List<Institutioncontact> institutioncontacts) {
		this.institutioncontacts = institutioncontacts;
	}

	public Institutioncontact addInstitutioncontact(Institutioncontact institutioncontact) {
		getInstitutioncontacts().add(institutioncontact);
		institutioncontact.setInstitution(this);

		return institutioncontact;
	}

	public Institutioncontact removeInstitutioncontact(Institutioncontact institutioncontact) {
		getInstitutioncontacts().remove(institutioncontact);
		institutioncontact.setInstitution(null);

		return institutioncontact;
	}

	public List<Systeminstance> getSysteminstances() {
		return this.systeminstances;
	}

	public void setSysteminstances(List<Systeminstance> systeminstances) {
		this.systeminstances = systeminstances;
	}

	public Systeminstance addSysteminstance(Systeminstance systeminstance) {
		getSysteminstances().add(systeminstance);
		systeminstance.setInstitution(this);

		return systeminstance;
	}

	public Systeminstance removeSysteminstance(Systeminstance systeminstance) {
		getSysteminstances().remove(systeminstance);
		systeminstance.setInstitution(null);

		return systeminstance;
	}

	public List<Workingholiday> getWorkingholidays() {
		return this.workingholidays;
	}

	public void setWorkingholidays(List<Workingholiday> workingholidays) {
		this.workingholidays = workingholidays;
	}

	public Workingholiday addWorkingholiday(Workingholiday workingholiday) {
		getWorkingholidays().add(workingholiday);
		workingholiday.setInstitution(this);

		return workingholiday;
	}

	public Workingholiday removeWorkingholiday(Workingholiday workingholiday) {
		getWorkingholidays().remove(workingholiday);
		workingholiday.setInstitution(null);

		return workingholiday;
	}

}