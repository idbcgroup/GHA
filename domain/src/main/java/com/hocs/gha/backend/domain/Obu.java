package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the obu database table.
 * 
 */
@Entity
@NamedQuery(name="Obu.findAll", query="SELECT o FROM Obu o")
public class Obu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String obucode;

	private String obuexternalcode;

	private String obuexternalname;

	private String obufunctionalarea;

	private String obufunctionalsubarea;

	private BigDecimal obulevel;

	private String obuname;

	private String obustatus;

	//bi-directional many-to-one association to Accessgroupassigned
	@OneToMany(mappedBy="obu")
	private List<Accessgroupassigned> accessgroupassigneds;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="obu")
	private List<Job> jobs;

	//bi-directional many-to-one association to Bpi
	@ManyToOne
	@JoinColumn(name="bpicode")
	private Bpi bpi;

	//bi-directional many-to-one association to Obu
	@ManyToOne
	@JoinColumn(name="obucodeparent")
	private Obu obu;

	//bi-directional many-to-one association to Obu
	@OneToMany(mappedBy="obu")
	private List<Obu> obus;

	//bi-directional many-to-one association to Workingarea
	@OneToMany(mappedBy="obu")
	private List<Workingarea> workingareas;

	public Obu() {
	}

	public String getObucode() {
		return this.obucode;
	}

	public void setObucode(String obucode) {
		this.obucode = obucode;
	}

	public String getObuexternalcode() {
		return this.obuexternalcode;
	}

	public void setObuexternalcode(String obuexternalcode) {
		this.obuexternalcode = obuexternalcode;
	}

	public String getObuexternalname() {
		return this.obuexternalname;
	}

	public void setObuexternalname(String obuexternalname) {
		this.obuexternalname = obuexternalname;
	}

	public String getObufunctionalarea() {
		return this.obufunctionalarea;
	}

	public void setObufunctionalarea(String obufunctionalarea) {
		this.obufunctionalarea = obufunctionalarea;
	}

	public String getObufunctionalsubarea() {
		return this.obufunctionalsubarea;
	}

	public void setObufunctionalsubarea(String obufunctionalsubarea) {
		this.obufunctionalsubarea = obufunctionalsubarea;
	}

	public BigDecimal getObulevel() {
		return this.obulevel;
	}

	public void setObulevel(BigDecimal obulevel) {
		this.obulevel = obulevel;
	}

	public String getObuname() {
		return this.obuname;
	}

	public void setObuname(String obuname) {
		this.obuname = obuname;
	}

	public String getObustatus() {
		return this.obustatus;
	}

	public void setObustatus(String obustatus) {
		this.obustatus = obustatus;
	}

	public List<Accessgroupassigned> getAccessgroupassigneds() {
		return this.accessgroupassigneds;
	}

	public void setAccessgroupassigneds(List<Accessgroupassigned> accessgroupassigneds) {
		this.accessgroupassigneds = accessgroupassigneds;
	}

	public Accessgroupassigned addAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().add(accessgroupassigned);
		accessgroupassigned.setObu(this);

		return accessgroupassigned;
	}

	public Accessgroupassigned removeAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().remove(accessgroupassigned);
		accessgroupassigned.setObu(null);

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
		job.setObu(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setObu(null);

		return job;
	}

	public Bpi getBpi() {
		return this.bpi;
	}

	public void setBpi(Bpi bpi) {
		this.bpi = bpi;
	}

	public Obu getObu() {
		return this.obu;
	}

	public void setObu(Obu obu) {
		this.obu = obu;
	}

	public List<Obu> getObus() {
		return this.obus;
	}

	public void setObus(List<Obu> obus) {
		this.obus = obus;
	}

	public Obu addObus(Obu obus) {
		getObus().add(obus);
		obus.setObu(this);

		return obus;
	}

	public Obu removeObus(Obu obus) {
		getObus().remove(obus);
		obus.setObu(null);

		return obus;
	}

	public List<Workingarea> getWorkingareas() {
		return this.workingareas;
	}

	public void setWorkingareas(List<Workingarea> workingareas) {
		this.workingareas = workingareas;
	}

	public Workingarea addWorkingarea(Workingarea workingarea) {
		getWorkingareas().add(workingarea);
		workingarea.setObu(this);

		return workingarea;
	}

	public Workingarea removeWorkingarea(Workingarea workingarea) {
		getWorkingareas().remove(workingarea);
		workingarea.setObu(null);

		return workingarea;
	}

}