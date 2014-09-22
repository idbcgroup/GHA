package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dateperiod database table.
 * 
 */
@Entity
@NamedQuery(name="Dateperiod.findAll", query="SELECT d FROM Dateperiod d")
public class Dateperiod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String dateperiodcode;

	private String dateperiodend;

	private String dateperiodstart;

	private String periodevaluation;

	private String periodtype;

	//bi-directional many-to-one association to Horarydefinition
	@OneToMany(mappedBy="dateperiod")
	private List<Horarydefinition> horarydefinitions;

	public Dateperiod() {
	}

	public String getDateperiodcode() {
		return this.dateperiodcode;
	}

	public void setDateperiodcode(String dateperiodcode) {
		this.dateperiodcode = dateperiodcode;
	}

	public String getDateperiodend() {
		return this.dateperiodend;
	}

	public void setDateperiodend(String dateperiodend) {
		this.dateperiodend = dateperiodend;
	}

	public String getDateperiodstart() {
		return this.dateperiodstart;
	}

	public void setDateperiodstart(String dateperiodstart) {
		this.dateperiodstart = dateperiodstart;
	}

	public String getPeriodevaluation() {
		return this.periodevaluation;
	}

	public void setPeriodevaluation(String periodevaluation) {
		this.periodevaluation = periodevaluation;
	}

	public String getPeriodtype() {
		return this.periodtype;
	}

	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	public List<Horarydefinition> getHorarydefinitions() {
		return this.horarydefinitions;
	}

	public void setHorarydefinitions(List<Horarydefinition> horarydefinitions) {
		this.horarydefinitions = horarydefinitions;
	}

	public Horarydefinition addHorarydefinition(Horarydefinition horarydefinition) {
		getHorarydefinitions().add(horarydefinition);
		horarydefinition.setDateperiod(this);

		return horarydefinition;
	}

	public Horarydefinition removeHorarydefinition(Horarydefinition horarydefinition) {
		getHorarydefinitions().remove(horarydefinition);
		horarydefinition.setDateperiod(null);

		return horarydefinition;
	}

}