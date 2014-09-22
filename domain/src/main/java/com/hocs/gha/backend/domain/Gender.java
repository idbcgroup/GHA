package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gender database table.
 * 
 */
@Entity
@NamedQuery(name="Gender.findAll", query="SELECT g FROM Gender g")
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gendercode;

	private String conceptcode;

	private String gendername;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="gender")
	private List<Concept> concepts;

	public Gender() {
	}

	public String getGendercode() {
		return this.gendercode;
	}

	public void setGendercode(String gendercode) {
		this.gendercode = gendercode;
	}

	public String getConceptcode() {
		return this.conceptcode;
	}

	public void setConceptcode(String conceptcode) {
		this.conceptcode = conceptcode;
	}

	public String getGendername() {
		return this.gendername;
	}

	public void setGendername(String gendername) {
		this.gendername = gendername;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

	public Concept addConcept(Concept concept) {
		getConcepts().add(concept);
		concept.setGender(this);

		return concept;
	}

	public Concept removeConcept(Concept concept) {
		getConcepts().remove(concept);
		concept.setGender(null);

		return concept;
	}

}