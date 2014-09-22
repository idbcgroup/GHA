package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the systeminstance database table.
 * 
 */
@Entity
@NamedQuery(name="Systeminstance.findAll", query="SELECT s FROM Systeminstance s")
public class Systeminstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer systeminstanceid;

	//bi-directional many-to-one association to Bpa
	@OneToMany(mappedBy="systeminstanceBean")
	private List<Bpa> bpas;

	//bi-directional many-to-one association to Instancelogon
	@OneToMany(mappedBy="systeminstance")
	private List<Instancelogon> instancelogons;

	//bi-directional many-to-one association to Logonlog
	@OneToMany(mappedBy="systeminstance")
	private List<Logonlog> logonlogs;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	//bi-directional many-to-one association to Itsystem
	@ManyToOne
	@JoinColumn(name="itsystemcode")
	private Itsystem itsystem;

	public Systeminstance() {
	}

	public Integer getSysteminstanceid() {
		return this.systeminstanceid;
	}

	public void setSysteminstanceid(Integer systeminstanceid) {
		this.systeminstanceid = systeminstanceid;
	}

	public List<Bpa> getBpas() {
		return this.bpas;
	}

	public void setBpas(List<Bpa> bpas) {
		this.bpas = bpas;
	}

	public Bpa addBpa(Bpa bpa) {
		getBpas().add(bpa);
		bpa.setSysteminstanceBean(this);

		return bpa;
	}

	public Bpa removeBpa(Bpa bpa) {
		getBpas().remove(bpa);
		bpa.setSysteminstanceBean(null);

		return bpa;
	}

	public List<Instancelogon> getInstancelogons() {
		return this.instancelogons;
	}

	public void setInstancelogons(List<Instancelogon> instancelogons) {
		this.instancelogons = instancelogons;
	}

	public Instancelogon addInstancelogon(Instancelogon instancelogon) {
		getInstancelogons().add(instancelogon);
		instancelogon.setSysteminstance(this);

		return instancelogon;
	}

	public Instancelogon removeInstancelogon(Instancelogon instancelogon) {
		getInstancelogons().remove(instancelogon);
		instancelogon.setSysteminstance(null);

		return instancelogon;
	}

	public List<Logonlog> getLogonlogs() {
		return this.logonlogs;
	}

	public void setLogonlogs(List<Logonlog> logonlogs) {
		this.logonlogs = logonlogs;
	}

	public Logonlog addLogonlog(Logonlog logonlog) {
		getLogonlogs().add(logonlog);
		logonlog.setSysteminstance(this);

		return logonlog;
	}

	public Logonlog removeLogonlog(Logonlog logonlog) {
		getLogonlogs().remove(logonlog);
		logonlog.setSysteminstance(null);

		return logonlog;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Itsystem getItsystem() {
		return this.itsystem;
	}

	public void setItsystem(Itsystem itsystem) {
		this.itsystem = itsystem;
	}

}