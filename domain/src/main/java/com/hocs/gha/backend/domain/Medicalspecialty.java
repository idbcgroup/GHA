package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicalspecialty database table.
 * 
 */
@Entity
@NamedQuery(name="Medicalspecialty.findAll", query="SELECT m FROM Medicalspecialty m")
public class Medicalspecialty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String medicalspecialtycode;

	private String availableininstitution;

	private String medicalspecialtydescription;

	private String medicalspecialtyname;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="conceptcode")
	private Concept concept;

	//bi-directional many-to-one association to Medicalspecialty
	@ManyToOne
	@JoinColumn(name="medicalspecialtyparent")
	private Medicalspecialty medicalspecialty;

	//bi-directional many-to-one association to Medicalspecialty
	@OneToMany(mappedBy="medicalspecialty")
	private List<Medicalspecialty> medicalspecialties;

	public Medicalspecialty() {
	}

	public String getMedicalspecialtycode() {
		return this.medicalspecialtycode;
	}

	public void setMedicalspecialtycode(String medicalspecialtycode) {
		this.medicalspecialtycode = medicalspecialtycode;
	}

	public String getAvailableininstitution() {
		return this.availableininstitution;
	}

	public void setAvailableininstitution(String availableininstitution) {
		this.availableininstitution = availableininstitution;
	}

	public String getMedicalspecialtydescription() {
		return this.medicalspecialtydescription;
	}

	public void setMedicalspecialtydescription(String medicalspecialtydescription) {
		this.medicalspecialtydescription = medicalspecialtydescription;
	}

	public String getMedicalspecialtyname() {
		return this.medicalspecialtyname;
	}

	public void setMedicalspecialtyname(String medicalspecialtyname) {
		this.medicalspecialtyname = medicalspecialtyname;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public Medicalspecialty getMedicalspecialty() {
		return this.medicalspecialty;
	}

	public void setMedicalspecialty(Medicalspecialty medicalspecialty) {
		this.medicalspecialty = medicalspecialty;
	}

	public List<Medicalspecialty> getMedicalspecialties() {
		return this.medicalspecialties;
	}

	public void setMedicalspecialties(List<Medicalspecialty> medicalspecialties) {
		this.medicalspecialties = medicalspecialties;
	}

	public Medicalspecialty addMedicalspecialty(Medicalspecialty medicalspecialty) {
		getMedicalspecialties().add(medicalspecialty);
		medicalspecialty.setMedicalspecialty(this);

		return medicalspecialty;
	}

	public Medicalspecialty removeMedicalspecialty(Medicalspecialty medicalspecialty) {
		getMedicalspecialties().remove(medicalspecialty);
		medicalspecialty.setMedicalspecialty(null);

		return medicalspecialty;
	}

}