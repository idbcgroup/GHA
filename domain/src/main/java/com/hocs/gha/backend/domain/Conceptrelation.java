package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the conceptrelation database table.
 * 
 */
@Entity
@NamedQuery(name="Conceptrelation.findAll", query="SELECT c FROM Conceptrelation c")
public class Conceptrelation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer conceptrelationid;

	private String equivalencelevel;

	private String equivalencerole;

	private String equivalencetype;

	private String relationtype;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="conceptcode")
	private Concept concept1;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="associateconceptcode")
	private Concept concept2;

	public Conceptrelation() {
	}

	public Integer getConceptrelationid() {
		return this.conceptrelationid;
	}

	public void setConceptrelationid(Integer conceptrelationid) {
		this.conceptrelationid = conceptrelationid;
	}

	public String getEquivalencelevel() {
		return this.equivalencelevel;
	}

	public void setEquivalencelevel(String equivalencelevel) {
		this.equivalencelevel = equivalencelevel;
	}

	public String getEquivalencerole() {
		return this.equivalencerole;
	}

	public void setEquivalencerole(String equivalencerole) {
		this.equivalencerole = equivalencerole;
	}

	public String getEquivalencetype() {
		return this.equivalencetype;
	}

	public void setEquivalencetype(String equivalencetype) {
		this.equivalencetype = equivalencetype;
	}

	public String getRelationtype() {
		return this.relationtype;
	}

	public void setRelationtype(String relationtype) {
		this.relationtype = relationtype;
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