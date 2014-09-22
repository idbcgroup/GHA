package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String jobcode;

	private Boolean administrativedelegation;

	private String defauworkingarea;

	private Boolean functionsauthorizations;

	private String initialactiononlogon;

	private String initialform;

	private Boolean jobdelegateactivity;

	private Boolean jobdelegationon;

	private String jobdescription;

	private String jobexternalid;

	private String jobexternalname;

	private Boolean jobfreedactivity;

	private Boolean jobhoraryrestricted;

	private Boolean jobingroup;

	private Boolean jobisuser;

	private String joblevel;

	private String jobmainfunction;

	private String jobname;

	private String jobownactivitytype;

	private String jobpkirequired;

	private BigDecimal jobpositions;

	private BigDecimal jobpositionsavailable;

	private String jobprimarywa;

	private String jobstatus;

	private Boolean jobwarestricted;

	//bi-directional many-to-one association to Accessgroupassigned
	@OneToMany(mappedBy="job")
	private List<Accessgroupassigned> accessgroupassigneds;

	//bi-directional many-to-one association to Baserole
	@ManyToOne
	@JoinColumn(name="baserolcode")
	private Baserole baserole;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="jobcodeparent")
	private Job job;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="job")
	private List<Job> jobs;

	//bi-directional many-to-one association to Obu
	@ManyToOne
	@JoinColumn(name="obucode")
	private Obu obu;

	//bi-directional many-to-one association to Serviceresourcecategory
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="serviceresourcearea", referencedColumnName="serviceresourcearea"),
		@JoinColumn(name="serviceresourcesubtype", referencedColumnName="serviceresourcesubtype"),
		@JoinColumn(name="serviceresourcetype", referencedColumnName="serviceresourcetype")
		})
	private Serviceresourcecategory serviceresourcecategory;

	//bi-directional many-to-one association to Jobposition
	@OneToMany(mappedBy="job")
	private List<Jobposition> jobpositionsSet;

	public Job() {
	}

	public String getJobcode() {
		return this.jobcode;
	}

	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	public Boolean getAdministrativedelegation() {
		return this.administrativedelegation;
	}

	public void setAdministrativedelegation(Boolean administrativedelegation) {
		this.administrativedelegation = administrativedelegation;
	}

	public String getDefauworkingarea() {
		return this.defauworkingarea;
	}

	public void setDefauworkingarea(String defauworkingarea) {
		this.defauworkingarea = defauworkingarea;
	}

	public Boolean getFunctionsauthorizations() {
		return this.functionsauthorizations;
	}

	public void setFunctionsauthorizations(Boolean functionsauthorizations) {
		this.functionsauthorizations = functionsauthorizations;
	}

	public String getInitialactiononlogon() {
		return this.initialactiononlogon;
	}

	public void setInitialactiononlogon(String initialactiononlogon) {
		this.initialactiononlogon = initialactiononlogon;
	}

	public String getInitialform() {
		return this.initialform;
	}

	public void setInitialform(String initialform) {
		this.initialform = initialform;
	}

	public Boolean getJobdelegateactivity() {
		return this.jobdelegateactivity;
	}

	public void setJobdelegateactivity(Boolean jobdelegateactivity) {
		this.jobdelegateactivity = jobdelegateactivity;
	}

	public Boolean getJobdelegationon() {
		return this.jobdelegationon;
	}

	public void setJobdelegationon(Boolean jobdelegationon) {
		this.jobdelegationon = jobdelegationon;
	}

	public String getJobdescription() {
		return this.jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public String getJobexternalid() {
		return this.jobexternalid;
	}

	public void setJobexternalid(String jobexternalid) {
		this.jobexternalid = jobexternalid;
	}

	public String getJobexternalname() {
		return this.jobexternalname;
	}

	public void setJobexternalname(String jobexternalname) {
		this.jobexternalname = jobexternalname;
	}

	public Boolean getJobfreedactivity() {
		return this.jobfreedactivity;
	}

	public void setJobfreedactivity(Boolean jobfreedactivity) {
		this.jobfreedactivity = jobfreedactivity;
	}

	public Boolean getJobhoraryrestricted() {
		return this.jobhoraryrestricted;
	}

	public void setJobhoraryrestricted(Boolean jobhoraryrestricted) {
		this.jobhoraryrestricted = jobhoraryrestricted;
	}

	public Boolean getJobingroup() {
		return this.jobingroup;
	}

	public void setJobingroup(Boolean jobingroup) {
		this.jobingroup = jobingroup;
	}

	public Boolean getJobisuser() {
		return this.jobisuser;
	}

	public void setJobisuser(Boolean jobisuser) {
		this.jobisuser = jobisuser;
	}

	public String getJoblevel() {
		return this.joblevel;
	}

	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	public String getJobmainfunction() {
		return this.jobmainfunction;
	}

	public void setJobmainfunction(String jobmainfunction) {
		this.jobmainfunction = jobmainfunction;
	}

	public String getJobname() {
		return this.jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getJobownactivitytype() {
		return this.jobownactivitytype;
	}

	public void setJobownactivitytype(String jobownactivitytype) {
		this.jobownactivitytype = jobownactivitytype;
	}

	public String getJobpkirequired() {
		return this.jobpkirequired;
	}

	public void setJobpkirequired(String jobpkirequired) {
		this.jobpkirequired = jobpkirequired;
	}

	public BigDecimal getJobpositions() {
		return this.jobpositions;
	}

	public void setJobpositions(BigDecimal jobpositions) {
		this.jobpositions = jobpositions;
	}

	public BigDecimal getJobpositionsavailable() {
		return this.jobpositionsavailable;
	}

	public void setJobpositionsavailable(BigDecimal jobpositionsavailable) {
		this.jobpositionsavailable = jobpositionsavailable;
	}

	public String getJobprimarywa() {
		return this.jobprimarywa;
	}

	public void setJobprimarywa(String jobprimarywa) {
		this.jobprimarywa = jobprimarywa;
	}

	public String getJobstatus() {
		return this.jobstatus;
	}

	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}

	public Boolean getJobwarestricted() {
		return this.jobwarestricted;
	}

	public void setJobwarestricted(Boolean jobwarestricted) {
		this.jobwarestricted = jobwarestricted;
	}

	public List<Accessgroupassigned> getAccessgroupassigneds() {
		return this.accessgroupassigneds;
	}

	public void setAccessgroupassigneds(List<Accessgroupassigned> accessgroupassigneds) {
		this.accessgroupassigneds = accessgroupassigneds;
	}

	public Accessgroupassigned addAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().add(accessgroupassigned);
		accessgroupassigned.setJob(this);

		return accessgroupassigned;
	}

	public Accessgroupassigned removeAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().remove(accessgroupassigned);
		accessgroupassigned.setJob(null);

		return accessgroupassigned;
	}

	public Baserole getBaserole() {
		return this.baserole;
	}

	public void setBaserole(Baserole baserole) {
		this.baserole = baserole;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setJob(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setJob(null);

		return job;
	}

	public Obu getObu() {
		return this.obu;
	}

	public void setObu(Obu obu) {
		this.obu = obu;
	}

	public Serviceresourcecategory getServiceresourcecategory() {
		return this.serviceresourcecategory;
	}

	public void setServiceresourcecategory(Serviceresourcecategory serviceresourcecategory) {
		this.serviceresourcecategory = serviceresourcecategory;
	}

	public List<Jobposition> getJobpositionsSet() {
		return this.jobpositionsSet;
	}

	public void setJobpositionsSet(List<Jobposition> jobpositionsSet) {
		this.jobpositionsSet = jobpositionsSet;
	}

	public Jobposition addJobpositionsSet(Jobposition jobpositionsSet) {
		getJobpositionsSet().add(jobpositionsSet);
		jobpositionsSet.setJob(this);

		return jobpositionsSet;
	}

	public Jobposition removeJobpositionsSet(Jobposition jobpositionsSet) {
		getJobpositionsSet().remove(jobpositionsSet);
		jobpositionsSet.setJob(null);

		return jobpositionsSet;
	}

}