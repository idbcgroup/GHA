package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the domain database table.
 * 
 */
@Entity
@NamedQuery(name="Domain.findAll", query="SELECT d FROM Domain d")
public class Domain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer domainid;

	private String domainname;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="domain")
	private List<Concept> concepts;

	public Domain() {
	}

	public Integer getDomainid() {
		return this.domainid;
	}

	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	public String getDomainname() {
		return this.domainname;
	}

	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

	public Concept addConcept(Concept concept) {
		getConcepts().add(concept);
		concept.setDomain(this);

		return concept;
	}

	public Concept removeConcept(Concept concept) {
		getConcepts().remove(concept);
		concept.setDomain(null);

		return concept;
	}

}