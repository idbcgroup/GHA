package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the infotype database table.
 * 
 */
@Entity
@NamedQuery(name="Infotype.findAll", query="SELECT i FROM Infotype i")
public class Infotype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String infotypecode;

	private String infotypedescription;

	private String infotypename;

	private String infotypestatus;

	//bi-directional many-to-one association to Ccdidefinition
	@OneToMany(mappedBy="infotype")
	private List<Ccdidefinition> ccdidefinitions;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="conceptcode")
	private Concept concept1;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="concepttype")
	private Concept concept2;

	public Infotype() {
	}

	public String getInfotypecode() {
		return this.infotypecode;
	}

	public void setInfotypecode(String infotypecode) {
		this.infotypecode = infotypecode;
	}

	public String getInfotypedescription() {
		return this.infotypedescription;
	}

	public void setInfotypedescription(String infotypedescription) {
		this.infotypedescription = infotypedescription;
	}

	public String getInfotypename() {
		return this.infotypename;
	}

	public void setInfotypename(String infotypename) {
		this.infotypename = infotypename;
	}

	public String getInfotypestatus() {
		return this.infotypestatus;
	}

	public void setInfotypestatus(String infotypestatus) {
		this.infotypestatus = infotypestatus;
	}

	public List<Ccdidefinition> getCcdidefinitions() {
		return this.ccdidefinitions;
	}

	public void setCcdidefinitions(List<Ccdidefinition> ccdidefinitions) {
		this.ccdidefinitions = ccdidefinitions;
	}

	public Ccdidefinition addCcdidefinition(Ccdidefinition ccdidefinition) {
		getCcdidefinitions().add(ccdidefinition);
		ccdidefinition.setInfotype(this);

		return ccdidefinition;
	}

	public Ccdidefinition removeCcdidefinition(Ccdidefinition ccdidefinition) {
		getCcdidefinitions().remove(ccdidefinition);
		ccdidefinition.setInfotype(null);

		return ccdidefinition;
	}

	public Concept getConcept1() {
		return this.concept1;
	}

	public void setConcept1(Concept concept1) {
		this.concept1 = concept1;
	}

	public Concept getConcept2() {
		return this.concept2;
	}

	public void setConcept2(Concept concept2) {
		this.concept2 = concept2;
	}

}