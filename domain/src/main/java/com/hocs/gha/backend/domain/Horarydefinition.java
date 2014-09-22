package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the horarydefinition database table.
 * 
 */
@Entity
@NamedQuery(name="Horarydefinition.findAll", query="SELECT h FROM Horarydefinition h")
public class Horarydefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer horaryid;

	private String horarydayix;

	private String horaryend01;

	private String horaryend02;

	private String horaryname;

	private String horarystart01;

	private String horarystart02;

	private String horarystatus;

	private String horarytype;

	//bi-directional many-to-one association to Dateperiod
	@ManyToOne
	@JoinColumn(name="validindateperiodcode")
	private Dateperiod dateperiod;

	//bi-directional many-to-one association to Shift
	@OneToMany(mappedBy="horarydefinition")
	private List<Shift> shifts;

	public Horarydefinition() {
	}

	public Integer getHoraryid() {
		return this.horaryid;
	}

	public void setHoraryid(Integer horaryid) {
		this.horaryid = horaryid;
	}

	public String getHorarydayix() {
		return this.horarydayix;
	}

	public void setHorarydayix(String horarydayix) {
		this.horarydayix = horarydayix;
	}

	public String getHoraryend01() {
		return this.horaryend01;
	}

	public void setHoraryend01(String horaryend01) {
		this.horaryend01 = horaryend01;
	}

	public String getHoraryend02() {
		return this.horaryend02;
	}

	public void setHoraryend02(String horaryend02) {
		this.horaryend02 = horaryend02;
	}

	public String getHoraryname() {
		return this.horaryname;
	}

	public void setHoraryname(String horaryname) {
		this.horaryname = horaryname;
	}

	public String getHorarystart01() {
		return this.horarystart01;
	}

	public void setHorarystart01(String horarystart01) {
		this.horarystart01 = horarystart01;
	}

	public String getHorarystart02() {
		return this.horarystart02;
	}

	public void setHorarystart02(String horarystart02) {
		this.horarystart02 = horarystart02;
	}

	public String getHorarystatus() {
		return this.horarystatus;
	}

	public void setHorarystatus(String horarystatus) {
		this.horarystatus = horarystatus;
	}

	public String getHorarytype() {
		return this.horarytype;
	}

	public void setHorarytype(String horarytype) {
		this.horarytype = horarytype;
	}

	public Dateperiod getDateperiod() {
		return this.dateperiod;
	}

	public void setDateperiod(Dateperiod dateperiod) {
		this.dateperiod = dateperiod;
	}

	public List<Shift> getShifts() {
		return this.shifts;
	}

	public void setShifts(List<Shift> shifts) {
		this.shifts = shifts;
	}

	public Shift addShift(Shift shift) {
		getShifts().add(shift);
		shift.setHorarydefinition(this);

		return shift;
	}

	public Shift removeShift(Shift shift) {
		getShifts().remove(shift);
		shift.setHorarydefinition(null);

		return shift;
	}

}