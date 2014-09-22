package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dataindataentity database table.
 * 
 */
@Entity
@NamedQuery(name="Dataindataentity.findAll", query="SELECT d FROM Dataindataentity d")
public class Dataindataentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer dataindataentityid;

	private String dataindataentitystatus;

	//bi-directional many-to-one association to Datadictionary
	@ManyToOne
	@JoinColumn(name="datadictionarycode")
	private Datadictionary datadictionary;

	//bi-directional many-to-one association to Dataentity
	@ManyToOne
	@JoinColumn(name="dataentitycode")
	private Dataentity dataentity;

	public Dataindataentity() {
	}

	public Integer getDataindataentityid() {
		return this.dataindataentityid;
	}

	public void setDataindataentityid(Integer dataindataentityid) {
		this.dataindataentityid = dataindataentityid;
	}

	public String getDataindataentitystatus() {
		return this.dataindataentitystatus;
	}

	public void setDataindataentitystatus(String dataindataentitystatus) {
		this.dataindataentitystatus = dataindataentitystatus;
	}

	public Datadictionary getDatadictionary() {
		return this.datadictionary;
	}

	public void setDatadictionary(Datadictionary datadictionary) {
		this.datadictionary = datadictionary;
	}

	public Dataentity getDataentity() {
		return this.dataentity;
	}

	public void setDataentity(Dataentity dataentity) {
		this.dataentity = dataentity;
	}

}