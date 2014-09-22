package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the functionalarea database table.
 * 
 */
@Entity
@NamedQuery(name="Functionalarea.findAll", query="SELECT f FROM Functionalarea f")
public class Functionalarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String functionalareacode;

	private String functionalareadescription;

	private String functionalareaname;

	//bi-directional many-to-one association to Function
	@OneToMany(mappedBy="functionalarea")
	private List<Function> functions;

	public Functionalarea() {
	}

	public String getFunctionalareacode() {
		return this.functionalareacode;
	}

	public void setFunctionalareacode(String functionalareacode) {
		this.functionalareacode = functionalareacode;
	}

	public String getFunctionalareadescription() {
		return this.functionalareadescription;
	}

	public void setFunctionalareadescription(String functionalareadescription) {
		this.functionalareadescription = functionalareadescription;
	}

	public String getFunctionalareaname() {
		return this.functionalareaname;
	}

	public void setFunctionalareaname(String functionalareaname) {
		this.functionalareaname = functionalareaname;
	}

	public List<Function> getFunctions() {
		return this.functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	public Function addFunction(Function function) {
		getFunctions().add(function);
		function.setFunctionalarea(this);

		return function;
	}

	public Function removeFunction(Function function) {
		getFunctions().remove(function);
		function.setFunctionalarea(null);

		return function;
	}

}