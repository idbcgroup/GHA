package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the agegroup database table.
 * 
 */
@Entity
@NamedQuery(name="Agegroup.findAll", query="SELECT a FROM Agegroup a")
public class Agegroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String agegroupcode;

	private BigDecimal agegroupend;

	private BigDecimal agegroupinitial;

	private String agegroupname;

	private String conceptcode;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="agegroup")
	private List<Concept> concepts;

	//bi-directional many-to-one association to Weightgroup
	@OneToMany(mappedBy="agegroup")
	private List<Weightgroup> weightgroups;

	public Agegroup() {
	}

	public String getAgegroupcode() {
		return this.agegroupcode;
	}

	public void setAgegroupcode(String agegroupcode) {
		this.agegroupcode = agegroupcode;
	}

	public BigDecimal getAgegroupend() {
		return this.agegroupend;
	}

	public void setAgegroupend(BigDecimal agegroupend) {
		this.agegroupend = agegroupend;
	}

	public BigDecimal getAgegroupinitial() {
		return this.agegroupinitial;
	}

	public void setAgegroupinitial(BigDecimal agegroupinitial) {
		this.agegroupinitial = agegroupinitial;
	}

	public String getAgegroupname() {
		return this.agegroupname;
	}

	public void setAgegroupname(String agegroupname) {
		this.agegroupname = agegroupname;
	}

	public String getConceptcode() {
		return this.conceptcode;
	}

	public void setConceptcode(String conceptcode) {
		this.conceptcode = conceptcode;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

	public Concept addConcept(Concept concept) {
		getConcepts().add(concept);
		concept.setAgegroup(this);

		return concept;
	}

	public Concept removeConcept(Concept concept) {
		getConcepts().remove(concept);
		concept.setAgegroup(null);

		return concept;
	}

	public List<Weightgroup> getWeightgroups() {
		return this.weightgroups;
	}

	public void setWeightgroups(List<Weightgroup> weightgroups) {
		this.weightgroups = weightgroups;
	}

	public Weightgroup addWeightgroup(Weightgroup weightgroup) {
		getWeightgroups().add(weightgroup);
		weightgroup.setAgegroup(this);

		return weightgroup;
	}

	public Weightgroup removeWeightgroup(Weightgroup weightgroup) {
		getWeightgroups().remove(weightgroup);
		weightgroup.setAgegroup(null);

		return weightgroup;
	}

}