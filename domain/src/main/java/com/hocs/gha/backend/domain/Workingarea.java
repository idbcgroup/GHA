package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the workingarea database table.
 * 
 */
@Entity
@NamedQuery(name="Workingarea.findAll", query="SELECT w FROM Workingarea w")
public class Workingarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String workingareacode;

	private String operationareatype;

	private String workingareadescription;

	private String workingareaname;

	//bi-directional many-to-one association to Accessgroupassigned
	@OneToMany(mappedBy="workingarea")
	private List<Accessgroupassigned> accessgroupassigneds;

	//bi-directional many-to-one association to Bpuinwa
	@OneToMany(mappedBy="workingarea")
	private List<Bpuinwa> bpuinwas;

	//bi-directional many-to-one association to Jobposition
	@OneToMany(mappedBy="workingarea")
	private List<Jobposition> jobpositions;

	//bi-directional many-to-one association to Parametbyfunction
	@OneToMany(mappedBy="workingarea")
	private List<Parametbyfunction> parametbyfunctions;

	//bi-directional many-to-one association to Terminal
	@OneToMany(mappedBy="workingarea")
	private List<Terminal> terminals;

	//bi-directional many-to-one association to Buildinglocation
	@ManyToOne
	@JoinColumn(name="buildinglocationcode")
	private Buildinglocation buildinglocation;

	//bi-directional many-to-one association to Locationtype
	@ManyToOne
	@JoinColumn(name="locationtypecode")
	private Locationtype locationtype;

	//bi-directional many-to-one association to Obu
	@ManyToOne
	@JoinColumn(name="obucode")
	private Obu obu;

	public Workingarea() {
	}

	public String getWorkingareacode() {
		return this.workingareacode;
	}

	public void setWorkingareacode(String workingareacode) {
		this.workingareacode = workingareacode;
	}

	public String getOperationareatype() {
		return this.operationareatype;
	}

	public void setOperationareatype(String operationareatype) {
		this.operationareatype = operationareatype;
	}

	public String getWorkingareadescription() {
		return this.workingareadescription;
	}

	public void setWorkingareadescription(String workingareadescription) {
		this.workingareadescription = workingareadescription;
	}

	public String getWorkingareaname() {
		return this.workingareaname;
	}

	public void setWorkingareaname(String workingareaname) {
		this.workingareaname = workingareaname;
	}

	public List<Accessgroupassigned> getAccessgroupassigneds() {
		return this.accessgroupassigneds;
	}

	public void setAccessgroupassigneds(List<Accessgroupassigned> accessgroupassigneds) {
		this.accessgroupassigneds = accessgroupassigneds;
	}

	public Accessgroupassigned addAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().add(accessgroupassigned);
		accessgroupassigned.setWorkingarea(this);

		return accessgroupassigned;
	}

	public Accessgroupassigned removeAccessgroupassigned(Accessgroupassigned accessgroupassigned) {
		getAccessgroupassigneds().remove(accessgroupassigned);
		accessgroupassigned.setWorkingarea(null);

		return accessgroupassigned;
	}

	public List<Bpuinwa> getBpuinwas() {
		return this.bpuinwas;
	}

	public void setBpuinwas(List<Bpuinwa> bpuinwas) {
		this.bpuinwas = bpuinwas;
	}

	public Bpuinwa addBpuinwa(Bpuinwa bpuinwa) {
		getBpuinwas().add(bpuinwa);
		bpuinwa.setWorkingarea(this);

		return bpuinwa;
	}

	public Bpuinwa removeBpuinwa(Bpuinwa bpuinwa) {
		getBpuinwas().remove(bpuinwa);
		bpuinwa.setWorkingarea(null);

		return bpuinwa;
	}

	public List<Jobposition> getJobpositions() {
		return this.jobpositions;
	}

	public void setJobpositions(List<Jobposition> jobpositions) {
		this.jobpositions = jobpositions;
	}

	public Jobposition addJobposition(Jobposition jobposition) {
		getJobpositions().add(jobposition);
		jobposition.setWorkingarea(this);

		return jobposition;
	}

	public Jobposition removeJobposition(Jobposition jobposition) {
		getJobpositions().remove(jobposition);
		jobposition.setWorkingarea(null);

		return jobposition;
	}

	public List<Parametbyfunction> getParametbyfunctions() {
		return this.parametbyfunctions;
	}

	public void setParametbyfunctions(List<Parametbyfunction> parametbyfunctions) {
		this.parametbyfunctions = parametbyfunctions;
	}

	public Parametbyfunction addParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().add(parametbyfunction);
		parametbyfunction.setWorkingarea(this);

		return parametbyfunction;
	}

	public Parametbyfunction removeParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().remove(parametbyfunction);
		parametbyfunction.setWorkingarea(null);

		return parametbyfunction;
	}

	public List<Terminal> getTerminals() {
		return this.terminals;
	}

	public void setTerminals(List<Terminal> terminals) {
		this.terminals = terminals;
	}

	public Terminal addTerminal(Terminal terminal) {
		getTerminals().add(terminal);
		terminal.setWorkingarea(this);

		return terminal;
	}

	public Terminal removeTerminal(Terminal terminal) {
		getTerminals().remove(terminal);
		terminal.setWorkingarea(null);

		return terminal;
	}

	public Buildinglocation getBuildinglocation() {
		return this.buildinglocation;
	}

	public void setBuildinglocation(Buildinglocation buildinglocation) {
		this.buildinglocation = buildinglocation;
	}

	public Locationtype getLocationtype() {
		return this.locationtype;
	}

	public void setLocationtype(Locationtype locationtype) {
		this.locationtype = locationtype;
	}

	public Obu getObu() {
		return this.obu;
	}

	public void setObu(Obu obu) {
		this.obu = obu;
	}

}