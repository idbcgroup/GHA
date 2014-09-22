package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the baserole database table.
 * 
 */
@Entity
@NamedQuery(name="Baserole.findAll", query="SELECT b FROM Baserole b")
public class Baserole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String baserolecode;

	private String baseroledescription;

	private String baserolename;

	private String baseroleprofession;

	private String baserolespecialty;

	private String baserolestatus;

	private String baseroletype;

	private BigDecimal functionsauthorizations;

	//bi-directional many-to-one association to Accessgroupassigned
	@OneToMany(mappedBy="baserole")
	private List<Accessgroupassigned> accessgroupassigneds;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="baserole")
	private List<Job> jobs;

	public Baserole() {
	}

	public String getBaserolecode() {
		return this.baserolecode;
	}

	public void setBaserolecode(String baserolecode) {
		this.baserolecode = baserolecode;
	}

	public String getBaseroledescription() {
		return this.baseroledescription;
	}

	public void setBaseroledescription(String baseroledescription) {
		this.baseroledescription = baseroledescription;
	}

	public String getBaserolename() {
		return this.baserolename;
	}

	public void setBaserolename(String baserolename) {
		this.baserolename = baserolename;
	}

	public String getBaseroleprofession() {
		return this.baseroleprofession;
	}

	public void setBaseroleprofession(String baseroleprofession) {
		this.baseroleprofession = baseroleprofession;
	}

	public String getBaserolespecialty() {
		return this.baserolespecialty;
	}

	public void setBaserolespecialty(String baserolespecialty) {
		this.baserolespecialty = baserolespecialty;
	}

	public String getBaserolestatus() {
		return this.baserolestatus;
	}

	public void setBaserolestatus(String baserolestatus) {
		this.baserolestatus = baserolestatus;
	}

	public String getBaseroletype() {
		return this.baseroletype;
	}

	public void setBaseroletype(String baseroletype) {
		this.baseroletype = baseroletype;
	}

	public BigDecimal getFunctionsauthorizations() {
		return this.functionsauthorizations;
	}

	public void setFunctionsauthorizations(BigDecimal functionsauthorizations) {
		this.functionsauthorizations = functionsauthorizations;
	}

	public List<Accessgroupassigned> getAccessgroupassigneds() {
		return this.accessgroupassigneds;
	}

	public void setAccessgroupassigneds(List<Accessgroupassigned> accessgroupassigneds) {
		this.accessgroupassigneds = accessgroupassigneds;
	}

	public Accessgroupassigned addAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().add(accessgroupassigned);
		accessgroupassigned.setBaserole(this);

		return accessgroupassigned;
	}

	public Accessgroupassigned removeAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().remove(accessgroupassigned);
		accessgroupassigned.setBaserole(null);

		return accessgroupassigned;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setBaserole(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setBaserole(null);

		return job;
	}

}