package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the itsystem database table.
 * 
 */
@Entity
@NamedQuery(name="Itsystem.findAll", query="SELECT i FROM Itsystem i")
public class Itsystem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String itsystemcode;

	private String devlastversion;

	private String itsysteminterface;

	private String itsystemname;

	private String itsystemstatus;

	private String itsystemtype;

	private String prodlastversion;

	private String qalastversion;

	//bi-directional many-to-one association to Itsysteminterface
	@OneToMany(mappedBy="itsystem1")
	private List<Itsysteminterface> itsysteminterfaces1;

	//bi-directional many-to-one association to Itsysteminterface
	@OneToMany(mappedBy="itsystem2")
	private List<Itsysteminterface> itsysteminterfaces2;

	//bi-directional many-to-one association to Logonlog
	@OneToMany(mappedBy="itsystem")
	private List<Logonlog> logonlogs;

	//bi-directional many-to-one association to Parametbyfunction
	@OneToMany(mappedBy="itsystem")
	private List<Parametbyfunction> parametbyfunctions;

	//bi-directional many-to-one association to Pmemessage
	@OneToMany(mappedBy="itsystem")
	private List<Pmemessage> pmemessages;

	//bi-directional many-to-one association to Systeminstance
	@OneToMany(mappedBy="itsystem")
	private List<Systeminstance> systeminstances;

	//bi-directional many-to-one association to Systemmodule
	@OneToMany(mappedBy="itsystem")
	private List<Systemmodule> systemmodules;

	public Itsystem() {
	}

	public String getItsystemcode() {
		return this.itsystemcode;
	}

	public void setItsystemcode(String itsystemcode) {
		this.itsystemcode = itsystemcode;
	}

	public String getDevlastversion() {
		return this.devlastversion;
	}

	public void setDevlastversion(String devlastversion) {
		this.devlastversion = devlastversion;
	}

	public String getItsysteminterface() {
		return this.itsysteminterface;
	}

	public void setItsysteminterface(String itsysteminterface) {
		this.itsysteminterface = itsysteminterface;
	}

	public String getItsystemname() {
		return this.itsystemname;
	}

	public void setItsystemname(String itsystemname) {
		this.itsystemname = itsystemname;
	}

	public String getItsystemstatus() {
		return this.itsystemstatus;
	}

	public void setItsystemstatus(String itsystemstatus) {
		this.itsystemstatus = itsystemstatus;
	}

	public String getItsystemtype() {
		return this.itsystemtype;
	}

	public void setItsystemtype(String itsystemtype) {
		this.itsystemtype = itsystemtype;
	}

	public String getProdlastversion() {
		return this.prodlastversion;
	}

	public void setProdlastversion(String prodlastversion) {
		this.prodlastversion = prodlastversion;
	}

	public String getQalastversion() {
		return this.qalastversion;
	}

	public void setQalastversion(String qalastversion) {
		this.qalastversion = qalastversion;
	}

	public List<Itsysteminterface> getItsysteminterfaces1() {
		return this.itsysteminterfaces1;
	}

	public void setItsysteminterfaces1(List<Itsysteminterface> itsysteminterfaces1) {
		this.itsysteminterfaces1 = itsysteminterfaces1;
	}

	public Itsysteminterface addItsysteminterfaces1(Itsysteminterface itsysteminterfaces1) {
		getItsysteminterfaces1().add(itsysteminterfaces1);
		itsysteminterfaces1.setItsystem1(this);

		return itsysteminterfaces1;
	}

	public Itsysteminterface removeItsysteminterfaces1(Itsysteminterface itsysteminterfaces1) {
		getItsysteminterfaces1().remove(itsysteminterfaces1);
		itsysteminterfaces1.setItsystem1(null);

		return itsysteminterfaces1;
	}

	public List<Itsysteminterface> getItsysteminterfaces2() {
		return this.itsysteminterfaces2;
	}

	public void setItsysteminterfaces2(List<Itsysteminterface> itsysteminterfaces2) {
		this.itsysteminterfaces2 = itsysteminterfaces2;
	}

	public Itsysteminterface addItsysteminterfaces2(Itsysteminterface itsysteminterfaces2) {
		getItsysteminterfaces2().add(itsysteminterfaces2);
		itsysteminterfaces2.setItsystem2(this);

		return itsysteminterfaces2;
	}

	public Itsysteminterface removeItsysteminterfaces2(Itsysteminterface itsysteminterfaces2) {
		getItsysteminterfaces2().remove(itsysteminterfaces2);
		itsysteminterfaces2.setItsystem2(null);

		return itsysteminterfaces2;
	}

	public List<Logonlog> getLogonlogs() {
		return this.logonlogs;
	}

	public void setLogonlogs(List<Logonlog> logonlogs) {
		this.logonlogs = logonlogs;
	}

	public Logonlog addLogonlog(Logonlog logonlog) {
		getLogonlogs().add(logonlog);
		logonlog.setItsystem(this);

		return logonlog;
	}

	public Logonlog removeLogonlog(Logonlog logonlog) {
		getLogonlogs().remove(logonlog);
		logonlog.setItsystem(null);

		return logonlog;
	}

	public List<Parametbyfunction> getParametbyfunctions() {
		return this.parametbyfunctions;
	}

	public void setParametbyfunctions(List<Parametbyfunction> parametbyfunctions) {
		this.parametbyfunctions = parametbyfunctions;
	}

	public Parametbyfunction addParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().add(parametbyfunction);
		parametbyfunction.setItsystem(this);

		return parametbyfunction;
	}

	public Parametbyfunction removeParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().remove(parametbyfunction);
		parametbyfunction.setItsystem(null);

		return parametbyfunction;
	}

	public List<Pmemessage> getPmemessages() {
		return this.pmemessages;
	}

	public void setPmemessages(List<Pmemessage> pmemessages) {
		this.pmemessages = pmemessages;
	}

	public Pmemessage addPmemessage(Pmemessage pmemessage) {
		getPmemessages().add(pmemessage);
		pmemessage.setItsystem(this);

		return pmemessage;
	}

	public Pmemessage removePmemessage(Pmemessage pmemessage) {
		getPmemessages().remove(pmemessage);
		pmemessage.setItsystem(null);

		return pmemessage;
	}

	public List<Systeminstance> getSysteminstances() {
		return this.systeminstances;
	}

	public void setSysteminstances(List<Systeminstance> systeminstances) {
		this.systeminstances = systeminstances;
	}

	public Systeminstance addSysteminstance(Systeminstance systeminstance) {
		getSysteminstances().add(systeminstance);
		systeminstance.setItsystem(this);

		return systeminstance;
	}

	public Systeminstance removeSysteminstance(Systeminstance systeminstance) {
		getSysteminstances().remove(systeminstance);
		systeminstance.setItsystem(null);

		return systeminstance;
	}

	public List<Systemmodule> getSystemmodules() {
		return this.systemmodules;
	}

	public void setSystemmodules(List<Systemmodule> systemmodules) {
		this.systemmodules = systemmodules;
	}

	public Systemmodule addSystemmodule(Systemmodule systemmodule) {
		getSystemmodules().add(systemmodule);
		systemmodule.setItsystem(this);

		return systemmodule;
	}

	public Systemmodule removeSystemmodule(Systemmodule systemmodule) {
		getSystemmodules().remove(systemmodule);
		systemmodule.setItsystem(null);

		return systemmodule;
	}

}