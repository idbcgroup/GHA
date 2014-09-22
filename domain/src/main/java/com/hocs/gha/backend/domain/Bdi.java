package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bdi database table.
 * 
 */
@Entity
@NamedQuery(name="Bdi.findAll", query="SELECT b FROM Bdi b")
public class Bdi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String bdicode;

	private String applicationequivalence;

	private String bdiname;

	private String bditype;

	//bi-directional many-to-one association to Standardagency
	@ManyToOne
	@JoinColumn(name="stdagencycode")
	private Standardagency standardagency;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="bdi")
	private List<Concept> concepts;

	public Bdi() {
	}

	public String getBdicode() {
		return this.bdicode;
	}

	public void setBdicode(String bdicode) {
		this.bdicode = bdicode;
	}

	public String getApplicationequivalence() {
		return this.applicationequivalence;
	}

	public void setApplicationequivalence(String applicationequivalence) {
		this.applicationequivalence = applicationequivalence;
	}

	public String getBdiname() {
		return this.bdiname;
	}

	public void setBdiname(String bdiname) {
		this.bdiname = bdiname;
	}

	public String getBditype() {
		return this.bditype;
	}

	public void setBditype(String bditype) {
		this.bditype = bditype;
	}

	public Standardagency getStandardagency() {
		return this.standardagency;
	}

	public void setStandardagency(Standardagency standardagency) {
		this.standardagency = standardagency;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

	public Concept addConcept(Concept concept) {
		getConcepts().add(concept);
		concept.setBdi(this);

		return concept;
	}

	public Concept removeConcept(Concept concept) {
		getConcepts().remove(concept);
		concept.setBdi(null);

		return concept;
	}

}