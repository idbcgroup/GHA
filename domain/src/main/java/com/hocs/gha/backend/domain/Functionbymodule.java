package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the functionbymodule database table.
 * 
 */
@Entity
@NamedQuery(name="Functionbymodule.findAll", query="SELECT f FROM Functionbymodule f")
public class Functionbymodule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer functionbymoduleid;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function;

	//bi-directional many-to-one association to Functiontype
	@ManyToOne
	@JoinColumn(name="functiontypecode")
	private Functiontype functiontype;

	//bi-directional many-to-one association to Systemmodule
	@ManyToOne
	@JoinColumn(name="modulecode")
	private Systemmodule systemmodule;

	public Functionbymodule() {
	}

	public Integer getFunctionbymoduleid() {
		return this.functionbymoduleid;
	}

	public void setFunctionbymoduleid(Integer functionbymoduleid) {
		this.functionbymoduleid = functionbymoduleid;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Functiontype getFunctiontype() {
		return this.functiontype;
	}

	public void setFunctiontype(Functiontype functiontype) {
		this.functiontype = functiontype;
	}

	public Systemmodule getSystemmodule() {
		return this.systemmodule;
	}

	public void setSystemmodule(Systemmodule systemmodule) {
		this.systemmodule = systemmodule;
	}

}