package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dataentity database table.
 * 
 */
@Entity
@NamedQuery(name="Dataentity.findAll", query="SELECT d FROM Dataentity d")
public class Dataentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String dataentitycode;

	private String businessprocessobject;

	private String dataentitymodule;

	private String dataentityname;

	private String dataentitystatus;

	//bi-directional many-to-one association to Dataindataentity
	@OneToMany(mappedBy="dataentity")
	private List<Dataindataentity> dataindataentities;

	public Dataentity() {
	}

	public String getDataentitycode() {
		return this.dataentitycode;
	}

	public void setDataentitycode(String dataentitycode) {
		this.dataentitycode = dataentitycode;
	}

	public String getBusinessprocessobject() {
		return this.businessprocessobject;
	}

	public void setBusinessprocessobject(String businessprocessobject) {
		this.businessprocessobject = businessprocessobject;
	}

	public String getDataentitymodule() {
		return this.dataentitymodule;
	}

	public void setDataentitymodule(String dataentitymodule) {
		this.dataentitymodule = dataentitymodule;
	}

	public String getDataentityname() {
		return this.dataentityname;
	}

	public void setDataentityname(String dataentityname) {
		this.dataentityname = dataentityname;
	}

	public String getDataentitystatus() {
		return this.dataentitystatus;
	}

	public void setDataentitystatus(String dataentitystatus) {
		this.dataentitystatus = dataentitystatus;
	}

	public List<Dataindataentity> getDataindataentities() {
		return this.dataindataentities;
	}

	public void setDataindataentities(List<Dataindataentity> dataindataentities) {
		this.dataindataentities = dataindataentities;
	}

	public Dataindataentity addDataindataentity(Dataindataentity dataindataentity) {
		getDataindataentities().add(dataindataentity);
		dataindataentity.setDataentity(this);

		return dataindataentity;
	}

	public Dataindataentity removeDataindataentity(Dataindataentity dataindataentity) {
		getDataindataentities().remove(dataindataentity);
		dataindataentity.setDataentity(null);

		return dataindataentity;
	}

}