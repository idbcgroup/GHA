package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the bpa database table.
 * 
 */
@Entity
@NamedQuery(name="Bpa.findAll", query="SELECT b FROM Bpa b")
public class Bpa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String bpacode;

	private String bpacredentialtype;

	private String bpaiddocumentnumber;

	private String bpaiddocumenttype;

	private Timestamp datecreated;

	private String legalentitytype;

	//bi-directional many-to-one association to Legalentity
	@ManyToOne
	@JoinColumn(name="legalentitycode")
	private Legalentity legalentity;

	//bi-directional many-to-one association to Systeminstance
	@ManyToOne
	@JoinColumn(name="systeminstance")
	private Systeminstance systeminstanceBean;

	//bi-directional many-to-one association to Bpaparamet
	@OneToMany(mappedBy="bpa")
	private List<Bpaparamet> bpaparamets;

	//bi-directional many-to-one association to Bpu
	@OneToMany(mappedBy="bpa")
	private List<Bpu> bpus;

	//bi-directional many-to-one association to Singlesignonuser
	@OneToMany(mappedBy="bpa")
	private List<Singlesignonuser> singlesignonusers;

	public Bpa() {
	}

	public String getBpacode() {
		return this.bpacode;
	}

	public void setBpacode(String bpacode) {
		this.bpacode = bpacode;
	}

	public String getBpacredentialtype() {
		return this.bpacredentialtype;
	}

	public void setBpacredentialtype(String bpacredentialtype) {
		this.bpacredentialtype = bpacredentialtype;
	}

	public String getBpaiddocumentnumber() {
		return this.bpaiddocumentnumber;
	}

	public void setBpaiddocumentnumber(String bpaiddocumentnumber) {
		this.bpaiddocumentnumber = bpaiddocumentnumber;
	}

	public String getBpaiddocumenttype() {
		return this.bpaiddocumenttype;
	}

	public void setBpaiddocumenttype(String bpaiddocumenttype) {
		this.bpaiddocumenttype = bpaiddocumenttype;
	}

	public Timestamp getDatecreated() {
		return this.datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public String getLegalentitytype() {
		return this.legalentitytype;
	}

	public void setLegalentitytype(String legalentitytype) {
		this.legalentitytype = legalentitytype;
	}

	public Legalentity getLegalentity() {
		return this.legalentity;
	}

	public void setLegalentity(Legalentity legalentity) {
		this.legalentity = legalentity;
	}

	public Systeminstance getSysteminstanceBean() {
		return this.systeminstanceBean;
	}

	public void setSysteminstanceBean(Systeminstance systeminstanceBean) {
		this.systeminstanceBean = systeminstanceBean;
	}

	public List<Bpaparamet> getBpaparamets() {
		return this.bpaparamets;
	}

	public void setBpaparamets(List<Bpaparamet> bpaparamets) {
		this.bpaparamets = bpaparamets;
	}

	public Bpaparamet addBpaparamet(Bpaparamet bpaparamet) {
		getBpaparamets().add(bpaparamet);
		bpaparamet.setBpa(this);

		return bpaparamet;
	}

	public Bpaparamet removeBpaparamet(Bpaparamet bpaparamet) {
		getBpaparamets().remove(bpaparamet);
		bpaparamet.setBpa(null);

		return bpaparamet;
	}

	public List<Bpu> getBpus() {
		return this.bpus;
	}

	public void setBpus(List<Bpu> bpus) {
		this.bpus = bpus;
	}

	public Bpu addBpus(Bpu bpus) {
		getBpus().add(bpus);
		bpus.setBpa(this);

		return bpus;
	}

	public Bpu removeBpus(Bpu bpus) {
		getBpus().remove(bpus);
		bpus.setBpa(null);

		return bpus;
	}

	public List<Singlesignonuser> getSinglesignonusers() {
		return this.singlesignonusers;
	}

	public void setSinglesignonusers(List<Singlesignonuser> singlesignonusers) {
		this.singlesignonusers = singlesignonusers;
	}

	public Singlesignonuser addSinglesignonuser(Singlesignonuser singlesignonuser) {
		getSinglesignonusers().add(singlesignonuser);
		singlesignonuser.setBpa(this);

		return singlesignonuser;
	}

	public Singlesignonuser removeSinglesignonuser(Singlesignonuser singlesignonuser) {
		getSinglesignonusers().remove(singlesignonuser);
		singlesignonuser.setBpa(null);

		return singlesignonuser;
	}

}