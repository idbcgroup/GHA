package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametvalue database table.
 * 
 */
@Entity
@NamedQuery(name="Parametvalue.findAll", query="SELECT p FROM Parametvalue p")
public class Parametvalue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer parametvalueid;

	private String parametervalue;

	//bi-directional many-to-one association to Parametdefinition
	@ManyToOne
	@JoinColumn(name="parametdefinitionid")
	private Parametdefinition parametdefinition;

	//bi-directional many-to-one association to Parametvaluescode
	@ManyToOne
	@JoinColumn(name="parametcodeid")
	private Parametvaluescode parametvaluescode;

	public Parametvalue() {
	}

	public Integer getParametvalueid() {
		return this.parametvalueid;
	}

	public void setParametvalueid(Integer parametvalueid) {
		this.parametvalueid = parametvalueid;
	}

	public String getParametervalue() {
		return this.parametervalue;
	}

	public void setParametervalue(String parametervalue) {
		this.parametervalue = parametervalue;
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

}