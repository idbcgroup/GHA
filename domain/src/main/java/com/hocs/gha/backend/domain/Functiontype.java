package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the functiontype database table.
 * 
 */
@Entity
@NamedQuery(name="Functiontype.findAll", query="SELECT f FROM Functiontype f")
public class Functiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String functiontypecode;

	private String functiontypename;

	//bi-directional many-to-one association to Function
	@OneToMany(mappedBy="functiontype")
	private List<Function> functions;

	//bi-directional many-to-one association to Functionbymodule
	@OneToMany(mappedBy="functiontype")
	private List<Functionbymodule> functionbymodules;

	//bi-directional many-to-one association to Functiontype
	@ManyToOne
	@JoinColumn(name="functiontypecodeparent")
	private Functiontype functiontype;

	//bi-directional many-to-one association to Functiontype
	@OneToMany(mappedBy="functiontype")
	private List<Functiontype> functiontypes;

	public Functiontype() {
	}

	public String getFunctiontypecode() {
		return this.functiontypecode;
	}

	public void setFunctiontypecode(String functiontypecode) {
		this.functiontypecode = functiontypecode;
	}

	public String getFunctiontypename() {
		return this.functiontypename;
	}

	public void setFunctiontypename(String functiontypename) {
		this.functiontypename = functiontypename;
	}

	public List<Function> getFunctions() {
		return this.functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	public Function addFunction(Function function) {
		getFunctions().add(function);
		function.setFunctiontype(this);

		return function;
	}

	public Function removeFunction(Function function) {
		getFunctions().remove(function);
		function.setFunctiontype(null);

		return function;
	}

	public List<Functionbymodule> getFunctionbymodules() {
		return this.functionbymodules;
	}

	public void setFunctionbymodules(List<Functionbymodule> functionbymodules) {
		this.functionbymodules = functionbymodules;
	}

	public Functionbymodule addFunctionbymodule(Functionbymodule functionbymodule) {
		getFunctionbymodules().add(functionbymodule);
		functionbymodule.setFunctiontype(this);

		return functionbymodule;
	}

	public Functionbymodule removeFunctionbymodule(Functionbymodule functionbymodule) {
		getFunctionbymodules().remove(functionbymodule);
		functionbymodule.setFunctiontype(null);

		return functionbymodule;
	}

	public Functiontype getFunctiontype() {
		return this.functiontype;
	}

	public void setFunctiontype(Functiontype functiontype) {
		this.functiontype = functiontype;
	}

	public List<Functiontype> getFunctiontypes() {
		return this.functiontypes;
	}

	public void setFunctiontypes(List<Functiontype> functiontypes) {
		this.functiontypes = functiontypes;
	}

	public Functiontype addFunctiontype(Functiontype functiontype) {
		getFunctiontypes().add(functiontype);
		functiontype.setFunctiontype(this);

		return functiontype;
	}

	public Functiontype removeFunctiontype(Functiontype functiontype) {
		getFunctiontypes().remove(functiontype);
		functiontype.setFunctiontype(null);

		return functiontype;
	}

}