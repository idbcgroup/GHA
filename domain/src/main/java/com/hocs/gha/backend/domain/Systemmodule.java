package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the systemmodule database table.
 * 
 */
@Entity
@NamedQuery(name="Systemmodule.findAll", query="SELECT s FROM Systemmodule s")
public class Systemmodule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String modulecode;

	private String devlastversion;

	private String functionalareacode;

	private String modulename;

	private String modulestatus;

	private String prodlastversion;

	private String qalastversion;

	//bi-directional many-to-one association to Catalogbyfunction
	@OneToMany(mappedBy="systemmodule")
	private List<Catalogbyfunction> catalogbyfunctions;

	//bi-directional many-to-one association to Functionbymodule
	@OneToMany(mappedBy="systemmodule")
	private List<Functionbymodule> functionbymodules;

	//bi-directional many-to-one association to Parametbyfunction
	@OneToMany(mappedBy="systemmodule")
	private List<Parametbyfunction> parametbyfunctions;

	//bi-directional many-to-one association to Pmemessage
	@OneToMany(mappedBy="systemmodule")
	private List<Pmemessage> pmemessages;

	//bi-directional many-to-one association to Itsystem
	@ManyToOne
	@JoinColumn(name="itsystemcode")
	private Itsystem itsystem;

	//bi-directional many-to-one association to Systemmodule
	@ManyToOne
	@JoinColumn(name="moduleparentcode")
	private Systemmodule systemmodule;

	//bi-directional many-to-one association to Systemmodule
	@OneToMany(mappedBy="systemmodule")
	private List<Systemmodule> systemmodules;

	public Systemmodule() {
	}

	public String getModulecode() {
		return this.modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}

	public String getDevlastversion() {
		return this.devlastversion;
	}

	public void setDevlastversion(String devlastversion) {
		this.devlastversion = devlastversion;
	}

	public String getFunctionalareacode() {
		return this.functionalareacode;
	}

	public void setFunctionalareacode(String functionalareacode) {
		this.functionalareacode = functionalareacode;
	}

	public String getModulename() {
		return this.modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public String getModulestatus() {
		return this.modulestatus;
	}

	public void setModulestatus(String modulestatus) {
		this.modulestatus = modulestatus;
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

	public List<Catalogbyfunction> getCatalogbyfunctions() {
		return this.catalogbyfunctions;
	}

	public void setCatalogbyfunctions(List<Catalogbyfunction> catalogbyfunctions) {
		this.catalogbyfunctions = catalogbyfunctions;
	}

	public Catalogbyfunction addCatalogbyfunction(Catalogbyfunction catalogbyfunction) {
		getCatalogbyfunctions().add(catalogbyfunction);
		catalogbyfunction.setSystemmodule(this);

		return catalogbyfunction;
	}

	public Catalogbyfunction removeCatalogbyfunction(Catalogbyfunction catalogbyfunction) {
		getCatalogbyfunctions().remove(catalogbyfunction);
		catalogbyfunction.setSystemmodule(null);

		return catalogbyfunction;
	}

	public List<Functionbymodule> getFunctionbymodules() {
		return this.functionbymodules;
	}

	public void setFunctionbymodules(List<Functionbymodule> functionbymodules) {
		this.functionbymodules = functionbymodules;
	}

	public Functionbymodule addFunctionbymodule(Functionbymodule functionbymodule) {
		getFunctionbymodules().add(functionbymodule);
		functionbymodule.setSystemmodule(this);

		return functionbymodule;
	}

	public Functionbymodule removeFunctionbymodule(Functionbymodule functionbymodule) {
		getFunctionbymodules().remove(functionbymodule);
		functionbymodule.setSystemmodule(null);

		return functionbymodule;
	}

	public List<Parametbyfunction> getParametbyfunctions() {
		return this.parametbyfunctions;
	}

	public void setParametbyfunctions(List<Parametbyfunction> parametbyfunctions) {
		this.parametbyfunctions = parametbyfunctions;
	}

	public Parametbyfunction addParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().add(parametbyfunction);
		parametbyfunction.setSystemmodule(this);

		return parametbyfunction;
	}

	public Parametbyfunction removeParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().remove(parametbyfunction);
		parametbyfunction.setSystemmodule(null);

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
		pmemessage.setSystemmodule(this);

		return pmemessage;
	}

	public Pmemessage removePmemessage(Pmemessage pmemessage) {
		getPmemessages().remove(pmemessage);
		pmemessage.setSystemmodule(null);

		return pmemessage;
	}

	public Itsystem getItsystem() {
		return this.itsystem;
	}

	public void setItsystem(Itsystem itsystem) {
		this.itsystem = itsystem;
	}

	public Systemmodule getSystemmodule() {
		return this.systemmodule;
	}

	public void setSystemmodule(Systemmodule systemmodule) {
		this.systemmodule = systemmodule;
	}

	public List<Systemmodule> getSystemmodules() {
		return this.systemmodules;
	}

	public void setSystemmodules(List<Systemmodule> systemmodules) {
		this.systemmodules = systemmodules;
	}

	public Systemmodule addSystemmodule(Systemmodule systemmodule) {
		getSystemmodules().add(systemmodule);
		systemmodule.setSystemmodule(this);

		return systemmodule;
	}

	public Systemmodule removeSystemmodule(Systemmodule systemmodule) {
		getSystemmodules().remove(systemmodule);
		systemmodule.setSystemmodule(null);

		return systemmodule;
	}

}