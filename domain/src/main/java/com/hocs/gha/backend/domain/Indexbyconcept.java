package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the indexbyconcept database table.
 * 
 */
@Entity
@NamedQuery(name="Indexbyconcept.findAll", query="SELECT i FROM Indexbyconcept i")
public class Indexbyconcept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer indexbyconceptid;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="conceptcode")
	private Concept concept;

	//bi-directional many-to-one association to Conceptnameindex
	@ManyToOne
	@JoinColumn(name="indextextid")
	private Conceptnameindex conceptnameindex;

	public Indexbyconcept() {
	}

	public Integer getIndexbyconceptid() {
		return this.indexbyconceptid;
	}

	public void setIndexbyconceptid(Integer indexbyconceptid) {
		this.indexbyconceptid = indexbyconceptid;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public Conceptnameindex getConceptnameindex() {
		return this.conceptnameindex;
	}

	public void setConceptnameindex(Conceptnameindex conceptnameindex) {
		this.conceptnameindex = conceptnameindex;
	}

}