package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the serviceresourcecategory database table.
 * 
 */
@Entity
@NamedQuery(name="Serviceresourcecategory.findAll", query="SELECT s FROM Serviceresourcecategory s")
public class Serviceresourcecategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ServiceresourcecategoryPK id;

	private String serviceinfotype;

	private String serviceresourcecategorycode;

	private String serviceresourcecategoryname;

	private Boolean serviceresourceinuse;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="serviceresourcecategory")
	private List<Job> jobs;

	//bi-directional many-to-one association to Locationtype
	@OneToMany(mappedBy="serviceresourcecategory")
	private List<Locationtype> locationtypes;

	//bi-directional many-to-one association to Serviceresourceclass
	@ManyToOne
	@JoinColumn(name="serviceresourceclasscode")
	private Serviceresourceclass serviceresourceclass;

	public Serviceresourcecategory() {
	}

	public ServiceresourcecategoryPK getId() {
		return this.id;
	}

	public void setId(ServiceresourcecategoryPK id) {
		this.id = id;
	}

	public String getServiceinfotype() {
		return this.serviceinfotype;
	}

	public void setServiceinfotype(String serviceinfotype) {
		this.serviceinfotype = serviceinfotype;
	}

	public String getServiceresourcecategorycode() {
		return this.serviceresourcecategorycode;
	}

	public void setServiceresourcecategorycode(String serviceresourcecategorycode) {
		this.serviceresourcecategorycode = serviceresourcecategorycode;
	}

	public String getServiceresourcecategoryname() {
		return this.serviceresourcecategoryname;
	}

	public void setServiceresourcecategoryname(String serviceresourcecategoryname) {
		this.serviceresourcecategoryname = serviceresourcecategoryname;
	}

	public Boolean getServiceresourceinuse() {
		return this.serviceresourceinuse;
	}

	public void setServiceresourceinuse(Boolean serviceresourceinuse) {
		this.serviceresourceinuse = serviceresourceinuse;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setServiceresourcecategory(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setServiceresourcecategory(null);

		return job;
	}

	public List<Locationtype> getLocationtypes() {
		return this.locationtypes;
	}

	public void setLocationtypes(List<Locationtype> locationtypes) {
		this.locationtypes = locationtypes;
	}

	public Locationtype addLocationtype(Locationtype locationtype) {
		getLocationtypes().add(locationtype);
		locationtype.setServiceresourcecategory(this);

		return locationtype;
	}

	public Locationtype removeLocationtype(Locationtype locationtype) {
		getLocationtypes().remove(locationtype);
		locationtype.setServiceresourcecategory(null);

		return locationtype;
	}

	public Serviceresourceclass getServiceresourceclass() {
		return this.serviceresourceclass;
	}

	public void setServiceresourceclass(Serviceresourceclass serviceresourceclass) {
		this.serviceresourceclass = serviceresourceclass;
	}

}