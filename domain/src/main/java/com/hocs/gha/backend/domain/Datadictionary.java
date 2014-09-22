package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the datadictionary database table.
 * 
 */
@Entity
@NamedQuery(name="Datadictionary.findAll", query="SELECT d FROM Datadictionary d")
public class Datadictionary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String datadictionarycode;

	private String datadictionarybpo;

	private Boolean datadictionaryccdi;

	private String datadictionarydatatype;

	private String datadictionarydescription;

	private BigDecimal datadictionarylong;

	private String datadictionaryname;

	private String datadictionarynature;

	private BigDecimal datadictionaryprecision;

	//bi-directional many-to-one association to Dataindataentity
	@OneToMany(mappedBy="datadictionary")
	private List<Dataindataentity> dataindataentities;

	//bi-directional many-to-one association to Datainfunction
	@OneToMany(mappedBy="datadictionary")
	private List<Datainfunction> datainfunctions;

	public Datadictionary() {
	}

	public String getDatadictionarycode() {
		return this.datadictionarycode;
	}

	public void setDatadictionarycode(String datadictionarycode) {
		this.datadictionarycode = datadictionarycode;
	}

	public String getDatadictionarybpo() {
		return this.datadictionarybpo;
	}

	public void setDatadictionarybpo(String datadictionarybpo) {
		this.datadictionarybpo = datadictionarybpo;
	}

	public Boolean getDatadictionaryccdi() {
		return this.datadictionaryccdi;
	}

	public void setDatadictionaryccdi(Boolean datadictionaryccdi) {
		this.datadictionaryccdi = datadictionaryccdi;
	}

	public String getDatadictionarydatatype() {
		return this.datadictionarydatatype;
	}

	public void setDatadictionarydatatype(String datadictionarydatatype) {
		this.datadictionarydatatype = datadictionarydatatype;
	}

	public String getDatadictionarydescription() {
		return this.datadictionarydescription;
	}

	public void setDatadictionarydescription(String datadictionarydescription) {
		this.datadictionarydescription = datadictionarydescription;
	}

	public BigDecimal getDatadictionarylong() {
		return this.datadictionarylong;
	}

	public void setDatadictionarylong(BigDecimal datadictionarylong) {
		this.datadictionarylong = datadictionarylong;
	}

	public String getDatadictionaryname() {
		return this.datadictionaryname;
	}

	public void setDatadictionaryname(String datadictionaryname) {
		this.datadictionaryname = datadictionaryname;
	}

	public String getDatadictionarynature() {
		return this.datadictionarynature;
	}

	public void setDatadictionarynature(String datadictionarynature) {
		this.datadictionarynature = datadictionarynature;
	}

	public BigDecimal getDatadictionaryprecision() {
		return this.datadictionaryprecision;
	}

	public void setDatadictionaryprecision(BigDecimal datadictionaryprecision) {
		this.datadictionaryprecision = datadictionaryprecision;
	}

	public List<Dataindataentity> getDataindataentities() {
		return this.dataindataentities;
	}

	public void setDataindataentities(List<Dataindataentity> dataindataentities) {
		this.dataindataentities = dataindataentities;
	}

	public Dataindataentity addDataindataentity(Dataindataentity dataindataentity) {
		getDataindataentities().add(dataindataentity);
		dataindataentity.setDatadictionary(this);

		return dataindataentity;
	}

	public Dataindataentity removeDataindataentity(Dataindataentity dataindataentity) {
		getDataindataentities().remove(dataindataentity);
		dataindataentity.setDatadictionary(null);

		return dataindataentity;
	}

	public List<Datainfunction> getDatainfunctions() {
		return this.datainfunctions;
	}

	public void setDatainfunctions(List<Datainfunction> datainfunctions) {
		this.datainfunctions = datainfunctions;
	}

	public Datainfunction addDatainfunction(Datainfunction datainfunction) {
		getDatainfunctions().add(datainfunction);
		datainfunction.setDatadictionary(this);

		return datainfunction;
	}

	public Datainfunction removeDatainfunction(Datainfunction datainfunction) {
		getDatainfunctions().remove(datainfunction);
		datainfunction.setDatadictionary(null);

		return datainfunction;
	}

}