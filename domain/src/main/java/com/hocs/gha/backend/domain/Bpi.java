package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the bpi database table.
 * 
 */
@Entity
@NamedQuery(name="Bpi.findAll", query="SELECT b FROM Bpi b")
public class Bpi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String bpicode;

	private String bpidescription;

	private String bpiinstitutionrelationship;

	private String bpilogonameroute;

	private String bpiname;

	private String bpiorigin;

	private BigDecimal bpiparametdefaultvalues;

	private String bpiprincipalproduct;

	private String bpiproductivesector;

	private String bpirisk;

	private String bpisector;

	private String bpitype;

	private String healthcode;

	private String iddocumentnumber;

	private String legalentitycode;

	private String taxcode;

	//bi-directional many-to-one association to Accessgroupassigned
	@OneToMany(mappedBy="bpi")
	private List<Accessgroupassigned> accessgroupassigneds;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	//bi-directional many-to-one association to Bpiparamet
	@OneToMany(mappedBy="bpi")
	private List<Bpiparamet> bpiparamets;

	//bi-directional many-to-one association to Bpu
	@OneToMany(mappedBy="bpi")
	private List<Bpu> bpus;

	//bi-directional many-to-one association to Buildinglocation
	@OneToMany(mappedBy="bpi")
	private List<Buildinglocation> buildinglocations;

	//bi-directional many-to-one association to Obu
	@OneToMany(mappedBy="bpi")
	private List<Obu> obus;

	public Bpi() {
	}

	public String getBpicode() {
		return this.bpicode;
	}

	public void setBpicode(String bpicode) {
		this.bpicode = bpicode;
	}

	public String getBpidescription() {
		return this.bpidescription;
	}

	public void setBpidescription(String bpidescription) {
		this.bpidescription = bpidescription;
	}

	public String getBpiinstitutionrelationship() {
		return this.bpiinstitutionrelationship;
	}

	public void setBpiinstitutionrelationship(String bpiinstitutionrelationship) {
		this.bpiinstitutionrelationship = bpiinstitutionrelationship;
	}

	public String getBpilogonameroute() {
		return this.bpilogonameroute;
	}

	public void setBpilogonameroute(String bpilogonameroute) {
		this.bpilogonameroute = bpilogonameroute;
	}

	public String getBpiname() {
		return this.bpiname;
	}

	public void setBpiname(String bpiname) {
		this.bpiname = bpiname;
	}

	public String getBpiorigin() {
		return this.bpiorigin;
	}

	public void setBpiorigin(String bpiorigin) {
		this.bpiorigin = bpiorigin;
	}

	public BigDecimal getBpiparametdefaultvalues() {
		return this.bpiparametdefaultvalues;
	}

	public void setBpiparametdefaultvalues(BigDecimal bpiparametdefaultvalues) {
		this.bpiparametdefaultvalues = bpiparametdefaultvalues;
	}

	public String getBpiprincipalproduct() {
		return this.bpiprincipalproduct;
	}

	public void setBpiprincipalproduct(String bpiprincipalproduct) {
		this.bpiprincipalproduct = bpiprincipalproduct;
	}

	public String getBpiproductivesector() {
		return this.bpiproductivesector;
	}

	public void setBpiproductivesector(String bpiproductivesector) {
		this.bpiproductivesector = bpiproductivesector;
	}

	public String getBpirisk() {
		return this.bpirisk;
	}

	public void setBpirisk(String bpirisk) {
		this.bpirisk = bpirisk;
	}

	public String getBpisector() {
		return this.bpisector;
	}

	public void setBpisector(String bpisector) {
		this.bpisector = bpisector;
	}

	public String getBpitype() {
		return this.bpitype;
	}

	public void setBpitype(String bpitype) {
		this.bpitype = bpitype;
	}

	public String getHealthcode() {
		return this.healthcode;
	}

	public void setHealthcode(String healthcode) {
		this.healthcode = healthcode;
	}

	public String getIddocumentnumber() {
		return this.iddocumentnumber;
	}

	public void setIddocumentnumber(String iddocumentnumber) {
		this.iddocumentnumber = iddocumentnumber;
	}

	public String getLegalentitycode() {
		return this.legalentitycode;
	}

	public void setLegalentitycode(String legalentitycode) {
		this.legalentitycode = legalentitycode;
	}

	public String getTaxcode() {
		return this.taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}

	public List<Accessgroupassigned> getAccessgroupassigneds() {
		return this.accessgroupassigneds;
	}

	public void setAccessgroupassigneds(List<Accessgroupassigned> accessgroupassigneds) {
		this.accessgroupassigneds = accessgroupassigneds;
	}

	public Accessgroupassigned addAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().add(accessgroupassigned);
		accessgroupassigned.setBpi(this);

		return accessgroupassigned;
	}

	public Accessgroupassigned removeAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().remove(accessgroupassigned);
		accessgroupassigned.setBpi(null);

		return accessgroupassigned;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<Bpiparamet> getBpiparamets() {
		return this.bpiparamets;
	}

	public void setBpiparamets(List<Bpiparamet> bpiparamets) {
		this.bpiparamets = bpiparamets;
	}

	public Bpiparamet addBpiparamet(Bpiparamet bpiparamet) {
		getBpiparamets().add(bpiparamet);
		bpiparamet.setBpi(this);

		return bpiparamet;
	}

	public Bpiparamet removeBpiparamet(Bpiparamet bpiparamet) {
		getBpiparamets().remove(bpiparamet);
		bpiparamet.setBpi(null);

		return bpiparamet;
	}

	public List<Bpu> getBpus() {
		return this.bpus;
	}

	public void setBpus(List<Bpu> bpus) {
		this.bpus = bpus;
	}

	public Bpu addBpus(Bpu bpus) {
		getBpus().add(bpus);
		bpus.setBpi(this);

		return bpus;
	}

	public Bpu removeBpus(Bpu bpus) {
		getBpus().remove(bpus);
		bpus.setBpi(null);

		return bpus;
	}

	public List<Buildinglocation> getBuildinglocations() {
		return this.buildinglocations;
	}

	public void setBuildinglocations(List<Buildinglocation> buildinglocations) {
		this.buildinglocations = buildinglocations;
	}

	public Buildinglocation addBuildinglocation(Buildinglocation buildinglocation) {
		getBuildinglocations().add(buildinglocation);
		buildinglocation.setBpi(this);

		return buildinglocation;
	}

	public Buildinglocation removeBuildinglocation(Buildinglocation buildinglocation) {
		getBuildinglocations().remove(buildinglocation);
		buildinglocation.setBpi(null);

		return buildinglocation;
	}

	public List<Obu> getObus() {
		return this.obus;
	}

	public void setObus(List<Obu> obus) {
		this.obus = obus;
	}

	public Obu addObus(Obu obus) {
		getObus().add(obus);
		obus.setBpi(this);

		return obus;
	}

	public Obu removeObus(Obu obus) {
		getObus().remove(obus);
		obus.setBpi(null);

		return obus;
	}

}