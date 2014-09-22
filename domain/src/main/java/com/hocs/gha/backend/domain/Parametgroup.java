package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parametgroup database table.
 * 
 */
@Entity
@NamedQuery(name="Parametgroup.findAll", query="SELECT p FROM Parametgroup p")
public class Parametgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String parametgroupcode;

	private String applicationname;

	private String parametgroupdescription;

	//bi-directional many-to-one association to Parametdefinition
	@OneToMany(mappedBy="parametgroup")
	private List<Parametdefinition> parametdefinitions;

	//bi-directional many-to-one association to Parametgroup
	@ManyToOne
	@JoinColumn(name="parametgroupcodeparent")
	private Parametgroup parametgroup;

	//bi-directional many-to-one association to Parametgroup
	@OneToMany(mappedBy="parametgroup")
	private List<Parametgroup> parametgroups;

	public Parametgroup() {
	}

	public String getParametgroupcode() {
		return this.parametgroupcode;
	}

	public void setParametgroupcode(String parametgroupcode) {
		this.parametgroupcode = parametgroupcode;
	}

	public String getApplicationname() {
		return this.applicationname;
	}

	public void setApplicationname(String applicationname) {
		this.applicationname = applicationname;
	}

	public String getParametgroupdescription() {
		return this.parametgroupdescription;
	}

	public void setParametgroupdescription(String parametgroupdescription) {
		this.parametgroupdescription = parametgroupdescription;
	}

	public List<Parametdefinition> getParametdefinitions() {
		return this.parametdefinitions;
	}

	public void setParametdefinitions(List<Parametdefinition> parametdefinitions) {
		this.parametdefinitions = parametdefinitions;
	}

	public Parametdefinition addParametdefinition(Parametdefinition parametdefinition) {
		getParametdefinitions().add(parametdefinition);
		parametdefinition.setParametgroup(this);

		return parametdefinition;
	}

	public Parametdefinition removeParametdefinition(Parametdefinition parametdefinition) {
		getParametdefinitions().remove(parametdefinition);
		parametdefinition.setParametgroup(null);

		return parametdefinition;
	}

	public Parametgroup getParametgroup() {
		return this.parametgroup;
	}

	public void setParametgroup(Parametgroup parametgroup) {
		this.parametgroup = parametgroup;
	}

	public List<Parametgroup> getParametgroups() {
		return this.parametgroups;
	}

	public void setParametgroups(List<Parametgroup> parametgroups) {
		this.parametgroups = parametgroups;
	}

	public Parametgroup addParametgroup(Parametgroup parametgroup) {
		getParametgroups().add(parametgroup);
		parametgroup.setParametgroup(this);

		return parametgroup;
	}

	public Parametgroup removeParametgroup(Parametgroup parametgroup) {
		getParametgroups().remove(parametgroup);
		parametgroup.setParametgroup(null);

		return parametgroup;
	}

}