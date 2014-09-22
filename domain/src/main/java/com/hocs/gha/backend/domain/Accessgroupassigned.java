package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the accessgroupassigned database table.
 * 
 */
@Entity
@NamedQuery(name="Accessgroupassigned.findAll", query="SELECT a FROM Accessgroupassigned a")
public class Accessgroupassigned implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long accessgroupassignedid;

	private String accessgroupassignedstatus;

	//bi-directional many-to-one association to Accessgroup
	@ManyToOne
	@JoinColumn(name="accessgroupcode")
	private Accessgroup accessgroup;

	//bi-directional many-to-one association to Baserole
	@ManyToOne
	@JoinColumn(name="baserolecode")
	private Baserole baserole;

	//bi-directional many-to-one association to Bpi
	@ManyToOne
	@JoinColumn(name="bpicode")
	private Bpi bpi;

	//bi-directional many-to-one association to Bpu
	@ManyToOne
	@JoinColumn(name="bpucode")
	private Bpu bpu;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="jobcode")
	private Job job;

	//bi-directional many-to-one association to Obu
	@ManyToOne
	@JoinColumn(name="obucode")
	private Obu obu;

	//bi-directional many-to-one association to Workingarea
	@ManyToOne
	@JoinColumn(name="workingareacode")
	private Workingarea workingarea;

	public Accessgroupassigned() {
	}

	public long getAccessgroupassignedid() {
		return this.accessgroupassignedid;
	}

	public void setAccessgroupassignedid(long accessgroupassignedid) {
		this.accessgroupassignedid = accessgroupassignedid;
	}

	public String getAccessgroupassignedstatus() {
		return this.accessgroupassignedstatus;
	}

	public void setAccessgroupassignedstatus(String accessgroupassignedstatus) {
		this.accessgroupassignedstatus = accessgroupassignedstatus;
	}

	public Accessgroup getAccessgroup() {
		return this.accessgroup;
	}

	public void setAccessgroup(Accessgroup accessgroup) {
		this.accessgroup = accessgroup;
	}

	public Baserole getBaserole() {
		return this.baserole;
	}

	public void setBaserole(Baserole baserole) {
		this.baserole = baserole;
	}

	public Bpi getBpi() {
		return this.bpi;
	}

	public void setBpi(Bpi bpi) {
		this.bpi = bpi;
	}

	public Bpu getBpu() {
		return this.bpu;
	}

	public void setBpu(Bpu bpu) {
		this.bpu = bpu;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Obu getObu() {
		return this.obu;
	}

	public void setObu(Obu obu) {
		this.obu = obu;
	}

	public Workingarea getWorkingarea() {
		return this.workingarea;
	}

	public void setWorkingarea(Workingarea workingarea) {
		this.workingarea = workingarea;
	}

}