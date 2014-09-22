package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the accessgroup database table.
 * 
 */
@Entity
@NamedQuery(name="Accessgroup.findAll", query="SELECT a FROM Accessgroup a")
public class Accessgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String accessgroupcode;

	private String accessgroupname;

	private String accessgroupstatus;

	private String accessgroupuse;

	private String accessgroupuserlevel;

	//bi-directional many-to-one association to Accessbyfunction
	@OneToMany(mappedBy="accessgroup")
	private List<Accessbyfunction> accessbyfunctions;

	//bi-directional many-to-one association to Accessgroupassigned
	@OneToMany(mappedBy="accessgroup")
	private List<Accessgroupassigned> accessgroupassigneds;

	//bi-directional many-to-one association to Functionsbyaccessgroup
	@OneToMany(mappedBy="accessgroup")
	private List<Functionsbyaccessgroup> functionsbyaccessgroups;

	public Accessgroup() {
	}

	public String getAccessgroupcode() {
		return this.accessgroupcode;
	}

	public void setAccessgroupcode(String accessgroupcode) {
		this.accessgroupcode = accessgroupcode;
	}

	public String getAccessgroupname() {
		return this.accessgroupname;
	}

	public void setAccessgroupname(String accessgroupname) {
		this.accessgroupname = accessgroupname;
	}

	public String getAccessgroupstatus() {
		return this.accessgroupstatus;
	}

	public void setAccessgroupstatus(String accessgroupstatus) {
		this.accessgroupstatus = accessgroupstatus;
	}

	public String getAccessgroupuse() {
		return this.accessgroupuse;
	}

	public void setAccessgroupuse(String accessgroupuse) {
		this.accessgroupuse = accessgroupuse;
	}

	public String getAccessgroupuserlevel() {
		return this.accessgroupuserlevel;
	}

	public void setAccessgroupuserlevel(String accessgroupuserlevel) {
		this.accessgroupuserlevel = accessgroupuserlevel;
	}

	public List<Accessbyfunction> getAccessbyfunctions() {
		return this.accessbyfunctions;
	}

	public void setAccessbyfunctions(List<Accessbyfunction> accessbyfunctions) {
		this.accessbyfunctions = accessbyfunctions;
	}

	public Accessbyfunction addAccessbyfunction(Accessbyfunction accessbyfunction) {
		getAccessbyfunctions().add(accessbyfunction);
		accessbyfunction.setAccessgroup(this);

		return accessbyfunction;
	}

	public Accessbyfunction removeAccessbyfunction(Accessbyfunction accessbyfunction) {
		getAccessbyfunctions().remove(accessbyfunction);
		accessbyfunction.setAccessgroup(null);

		return accessbyfunction;
	}

	public List<Accessgroupassigned> getAccessgroupassigneds() {
		return this.accessgroupassigneds;
	}

	public void setAccessgroupassigneds(List<Accessgroupassigned> accessgroupassigneds) {
		this.accessgroupassigneds = accessgroupassigneds;
	}

	public Accessgroupassigned addAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().add(accessgroupassigned);
		accessgroupassigned.setAccessgroup(this);

		return accessgroupassigned;
	}

	public Accessgroupassigned removeAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().remove(accessgroupassigned);
		accessgroupassigned.setAccessgroup(null);

		return accessgroupassigned;
	}

	public List<Functionsbyaccessgroup> getFunctionsbyaccessgroups() {
		return this.functionsbyaccessgroups;
	}

	public void setFunctionsbyaccessgroups(List<Functionsbyaccessgroup> functionsbyaccessgroups) {
		this.functionsbyaccessgroups = functionsbyaccessgroups;
	}

	public Functionsbyaccessgroup addFunctionsbyaccessgroup(Functionsbyaccessgroup functionsbyaccessgroup) {
		getFunctionsbyaccessgroups().add(functionsbyaccessgroup);
		functionsbyaccessgroup.setAccessgroup(this);

		return functionsbyaccessgroup;
	}

	public Functionsbyaccessgroup removeFunctionsbyaccessgroup(Functionsbyaccessgroup functionsbyaccessgroup) {
		getFunctionsbyaccessgroups().remove(functionsbyaccessgroup);
		functionsbyaccessgroup.setAccessgroup(null);

		return functionsbyaccessgroup;
	}

}