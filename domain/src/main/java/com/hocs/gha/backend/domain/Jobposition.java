package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the jobposition database table.
 * 
 */
@Entity
@NamedQuery(name="Jobposition.findAll", query="SELECT j FROM Jobposition j")
public class Jobposition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer jobpositionid;

	private String baseroleassociatedcode;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	private String jobpositionstatus;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	//bi-directional many-to-one association to Bpu
	@OneToMany(mappedBy="jobposition")
	private List<Bpu> bpus;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="jobcode")
	private Job job;

	//bi-directional many-to-one association to Jobposition
	@ManyToOne
	@JoinColumn(name="jobpositionparentid")
	private Jobposition jobposition;

	//bi-directional many-to-one association to Jobposition
	@OneToMany(mappedBy="jobposition")
	private List<Jobposition> jobpositions;

	//bi-directional many-to-one association to Workingarea
	@ManyToOne
	@JoinColumn(name="workingareacode")
	private Workingarea workingarea;

	public Jobposition() {
	}

	public Integer getJobpositionid() {
		return this.jobpositionid;
	}

	public void setJobpositionid(Integer jobpositionid) {
		this.jobpositionid = jobpositionid;
	}

	public String getBaseroleassociatedcode() {
		return this.baseroleassociatedcode;
	}

	public void setBaseroleassociatedcode(String baseroleassociatedcode) {
		this.baseroleassociatedcode = baseroleassociatedcode;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getJobpositionstatus() {
		return this.jobpositionstatus;
	}

	public void setJobpositionstatus(String jobpositionstatus) {
		this.jobpositionstatus = jobpositionstatus;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public List<Bpu> getBpus() {
		return this.bpus;
	}

	public void setBpus(List<Bpu> bpus) {
		this.bpus = bpus;
	}

	public Bpu addBpus(Bpu bpus) {
		getBpus().add(bpus);
		bpus.setJobposition(this);

		return bpus;
	}

	public Bpu removeBpus(Bpu bpus) {
		getBpus().remove(bpus);
		bpus.setJobposition(null);

		return bpus;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Jobposition getJobposition() {
		return this.jobposition;
	}

	public void setJobposition(Jobposition jobposition) {
		this.jobposition = jobposition;
	}

	public List<Jobposition> getJobpositions() {
		return this.jobpositions;
	}

	public void setJobpositions(List<Jobposition> jobpositions) {
		this.jobpositions = jobpositions;
	}

	public Jobposition addJobposition(Jobposition jobposition) {
		getJobpositions().add(jobposition);
		jobposition.setJobposition(this);

		return jobposition;
	}

	public Jobposition removeJobposition(Jobposition jobposition) {
		getJobpositions().remove(jobposition);
		jobposition.setJobposition(null);

		return jobposition;
	}

	public Workingarea getWorkingarea() {
		return this.workingarea;
	}

	public void setWorkingarea(Workingarea workingarea) {
		this.workingarea = workingarea;
	}

}