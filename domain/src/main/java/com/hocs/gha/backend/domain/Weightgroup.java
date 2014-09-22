package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the weightgroup database table.
 * 
 */
@Entity
@NamedQuery(name="Weightgroup.findAll", query="SELECT w FROM Weightgroup w")
public class Weightgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String weightgroupcode;

	private String conceptcode;

	private BigDecimal weightgroupend;

	private BigDecimal weightgroupinitial;

	private String weightgroupname;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="weightgroup")
	private List<Concept> concepts;

	//bi-directional many-to-one association to Agegroup
	@ManyToOne
	@JoinColumn(name="agegroupcode")
	private Agegroup agegroup;

	public Weightgroup() {
	}

	public String getWeightgroupcode() {
		return this.weightgroupcode;
	}

	public void setWeightgroupcode(String weightgroupcode) {
		this.weightgroupcode = weightgroupcode;
	}

	public String getConceptcode() {
		return this.conceptcode;
	}

	public void setConceptcode(String conceptcode) {
		this.conceptcode = conceptcode;
	}

	public BigDecimal getWeightgroupend() {
		return this.weightgroupend;
	}

	public void setWeightgroupend(BigDecimal weightgroupend) {
		this.weightgroupend = weightgroupend;
	}

	public BigDecimal getWeightgroupinitial() {
		return this.weightgroupinitial;
	}

	public void setWeightgroupinitial(BigDecimal weightgroupinitial) {
		this.weightgroupinitial = weightgroupinitial;
	}

	public String getWeightgroupname() {
		return this.weightgroupname;
	}

	public void setWeightgroupname(String weightgroupname) {
		this.weightgroupname = weightgroupname;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

	public Concept addConcept(Concept concept) {
		getConcepts().add(concept);
		concept.setWeightgroup(this);

		return concept;
	}

	public Concept removeConcept(Concept concept) {
		getConcepts().remove(concept);
		concept.setWeightgroup(null);

		return concept;
	}

	public Agegroup getAgegroup() {
		return this.agegroup;
	}

	public void setAgegroup(Agegroup agegroup) {
		this.agegroup = agegroup;
	}

}