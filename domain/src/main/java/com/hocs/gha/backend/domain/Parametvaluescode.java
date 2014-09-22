package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parametvaluescode database table.
 * 
 */
@Entity
@NamedQuery(name="Parametvaluescode.findAll", query="SELECT p FROM Parametvaluescode p")
public class Parametvaluescode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer parametcodeid;

	private String environmenttype;

	private String parametcodedescription;

	private String parametcodeuse;

	//bi-directional many-to-one association to Bpaparamet
	@OneToMany(mappedBy="parametvaluescode")
	private List<Bpaparamet> bpaparamets;

	//bi-directional many-to-one association to Bpiparamet
	@OneToMany(mappedBy="parametvaluescode")
	private List<Bpiparamet> bpiparamets;

	//bi-directional many-to-one association to Parametbyfunction
	@OneToMany(mappedBy="parametvaluescode")
	private List<Parametbyfunction> parametbyfunctions;

	//bi-directional many-to-one association to Parametvalue
	@OneToMany(mappedBy="parametvaluescode")
	private List<Parametvalue> parametvalues;

	public Parametvaluescode() {
	}

	public Integer getParametcodeid() {
		return this.parametcodeid;
	}

	public void setParametcodeid(Integer parametcodeid) {
		this.parametcodeid = parametcodeid;
	}

	public String getEnvironmenttype() {
		return this.environmenttype;
	}

	public void setEnvironmenttype(String environmenttype) {
		this.environmenttype = environmenttype;
	}

	public String getParametcodedescription() {
		return this.parametcodedescription;
	}

	public void setParametcodedescription(String parametcodedescription) {
		this.parametcodedescription = parametcodedescription;
	}

	public String getParametcodeuse() {
		return this.parametcodeuse;
	}

	public void setParametcodeuse(String parametcodeuse) {
		this.parametcodeuse = parametcodeuse;
	}

	public List<Bpaparamet> getBpaparamets() {
		return this.bpaparamets;
	}

	public void setBpaparamets(List<Bpaparamet> bpaparamets) {
		this.bpaparamets = bpaparamets;
	}

	public Bpaparamet addBpaparamet(Bpaparamet bpaparamet) {
		getBpaparamets().add(bpaparamet);
		bpaparamet.setParametvaluescode(this);

		return bpaparamet;
	}

	public Bpaparamet removeBpaparamet(Bpaparamet bpaparamet) {
		getBpaparamets().remove(bpaparamet);
		bpaparamet.setParametvaluescode(null);

		return bpaparamet;
	}

	public List<Bpiparamet> getBpiparamets() {
		return this.bpiparamets;
	}

	public void setBpiparamets(List<Bpiparamet> bpiparamets) {
		this.bpiparamets = bpiparamets;
	}

	public Bpiparamet addBpiparamet(Bpiparamet bpiparamet) {
		getBpiparamets().add(bpiparamet);
		bpiparamet.setParametvaluescode(this);

		return bpiparamet;
	}

	public Bpiparamet removeBpiparamet(Bpiparamet bpiparamet) {
		getBpiparamets().remove(bpiparamet);
		bpiparamet.setParametvaluescode(null);

		return bpiparamet;
	}

	public List<Parametbyfunction> getParametbyfunctions() {
		return this.parametbyfunctions;
	}

	public void setParametbyfunctions(List<Parametbyfunction> parametbyfunctions) {
		this.parametbyfunctions = parametbyfunctions;
	}

	public Parametbyfunction addParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().add(parametbyfunction);
		parametbyfunction.setParametvaluescode(this);

		return parametbyfunction;
	}

	public Parametbyfunction removeParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().remove(parametbyfunction);
		parametbyfunction.setParametvaluescode(null);

		return parametbyfunction;
	}

	public List<Parametvalue> getParametvalues() {
		return this.parametvalues;
	}

	public void setParametvalues(List<Parametvalue> parametvalues) {
		this.parametvalues = parametvalues;
	}

	public Parametvalue addParametvalue(Parametvalue parametvalue) {
		getParametvalues().add(parametvalue);
		parametvalue.setParametvaluescode(this);

		return parametvalue;
	}

	public Parametvalue removeParametvalue(Parametvalue parametvalue) {
		getParametvalues().remove(parametvalue);
		parametvalue.setParametvaluescode(null);

		return parametvalue;
	}

}