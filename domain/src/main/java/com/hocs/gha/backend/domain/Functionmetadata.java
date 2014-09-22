package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the functionmetadata database table.
 * 
 */
@Entity
@NamedQuery(name="Functionmetadata.findAll", query="SELECT f FROM Functionmetadata f")
public class Functionmetadata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer functionmetadataid;

	private String itfunctionname;

	private String itfunctionroute;

	private String itinitfunctionname;

	private String itinitfunctionroute;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function;

	public Functionmetadata() {
	}

	public Integer getFunctionmetadataid() {
		return this.functionmetadataid;
	}

	public void setFunctionmetadataid(Integer functionmetadataid) {
		this.functionmetadataid = functionmetadataid;
	}

	public String getItfunctionname() {
		return this.itfunctionname;
	}

	public void setItfunctionname(String itfunctionname) {
		this.itfunctionname = itfunctionname;
	}

	public String getItfunctionroute() {
		return this.itfunctionroute;
	}

	public void setItfunctionroute(String itfunctionroute) {
		this.itfunctionroute = itfunctionroute;
	}

	public String getItinitfunctionname() {
		return this.itinitfunctionname;
	}

	public void setItinitfunctionname(String itinitfunctionname) {
		this.itinitfunctionname = itinitfunctionname;
	}

	public String getItinitfunctionroute() {
		return this.itinitfunctionroute;
	}

	public void setItinitfunctionroute(String itinitfunctionroute) {
		this.itinitfunctionroute = itinitfunctionroute;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}