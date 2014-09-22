package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the shift database table.
 * 
 */
@Entity
@NamedQuery(name="Shift.findAll", query="SELECT s FROM Shift s")
public class Shift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer shiftid;

	private String shiftclase;

	private String shiftname;

	private String shiftstatus;

	private String shifttype;

	//bi-directional many-to-one association to Bpu
	@OneToMany(mappedBy="shift")
	private List<Bpu> bpus;

	//bi-directional many-to-one association to Horarydefinition
	@ManyToOne
	@JoinColumn(name="horaryid")
	private Horarydefinition horarydefinition;

	public Shift() {
	}

	public Integer getShiftid() {
		return this.shiftid;
	}

	public void setShiftid(Integer shiftid) {
		this.shiftid = shiftid;
	}

	public String getShiftclase() {
		return this.shiftclase;
	}

	public void setShiftclase(String shiftclase) {
		this.shiftclase = shiftclase;
	}

	public String getShiftname() {
		return this.shiftname;
	}

	public void setShiftname(String shiftname) {
		this.shiftname = shiftname;
	}

	public String getShiftstatus() {
		return this.shiftstatus;
	}

	public void setShiftstatus(String shiftstatus) {
		this.shiftstatus = shiftstatus;
	}

	public String getShifttype() {
		return this.shifttype;
	}

	public void setShifttype(String shifttype) {
		this.shifttype = shifttype;
	}

	public List<Bpu> getBpus() {
		return this.bpus;
	}

	public void setBpus(List<Bpu> bpus) {
		this.bpus = bpus;
	}

	public Bpu addBpus(Bpu bpus) {
		getBpus().add(bpus);
		bpus.setShift(this);

		return bpus;
	}

	public Bpu removeBpus(Bpu bpus) {
		getBpus().remove(bpus);
		bpus.setShift(null);

		return bpus;
	}

	public Horarydefinition getHorarydefinition() {
		return this.horarydefinition;
	}

	public void setHorarydefinition(Horarydefinition horarydefinition) {
		this.horarydefinition = horarydefinition;
	}

}