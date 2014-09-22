package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametbyfunction database table.
 * 
 */
@Entity
@NamedQuery(name="Parametbyfunction.findAll", query="SELECT p FROM Parametbyfunction p")
public class Parametbyfunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer parametfunctionid;

	private String parametervalue;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function;

	//bi-directional many-to-one association to Itsystem
	@ManyToOne
	@JoinColumn(name="itsystemcode")
	private Itsystem itsystem;

	//bi-directional many-to-one association to Parametdefinition
	@ManyToOne
	@JoinColumn(name="parametdefinitionid")
	private Parametdefinition parametdefinition;

	//bi-directional many-to-one association to Parametvaluescode
	@ManyToOne
	@JoinColumn(name="parametcodeid")
	private Parametvaluescode parametvaluescode;

	//bi-directional many-to-one association to Systemmodule
	@ManyToOne
	@JoinColumn(name="modulecode")
	private Systemmodule systemmodule;

	//bi-directional many-to-one association to Workingarea
	@ManyToOne
	@JoinColumn(name="workingareacode")
	private Workingarea workingarea;

	public Parametbyfunction() {
	}

	public Integer getParametfunctionid() {
		return this.parametfunctionid;
	}

	public void setParametfunctionid(Integer parametfunctionid) {
		this.parametfunctionid = parametfunctionid;
	}

	public String getParametervalue() {
		return this.parametervalue;
	}

	public void setParametervalue(String parametervalue) {
		this.parametervalue = parametervalue;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Itsystem getItsystem() {
		return this.itsystem;
	}

	public void setItsystem(Itsystem itsystem) {
		this.itsystem = itsystem;
	}

	public Parametdefinition getParametdefinition() {
		return this.parametdefinition;
	}

	public void setParametdefinition(Parametdefinition parametdefinition) {
		this.parametdefinition = parametdefinition;
	}

	public Parametvaluescode getParametvaluescode() {
		return this.parametvaluescode;
	}

	public void setParametvaluescode(Parametvaluescode parametvaluescode) {
		this.parametvaluescode = parametvaluescode;
	}

	public Systemmodule getSystemmodule() {
		return this.systemmodule;
	}

	public void setSystemmodule(Systemmodule systemmodule) {
		this.systemmodule = systemmodule;
	}

	public Workingarea getWorkingarea() {
		return this.workingarea;
	}

	public void setWorkingarea(Workingarea workingarea) {
		this.workingarea = workingarea;
	}

}