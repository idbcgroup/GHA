package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the concept database table.
 * 
 */
@Entity
@NamedQuery(name="Concept.findAll", query="SELECT c FROM Concept c")
public class Concept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String conceptcode;

	private String ciacode;

	private String conceptname;

	private String conceptstatus;

	private String medicalspecialtycode;

	private String medicalspecialtyname;

	private String primitiveconcept;

	private String snomedcode;

	//bi-directional many-to-one association to Additionalvalue
	@OneToMany(mappedBy="concept")
	private List<Additionalvalue> additionalvalues;

	//bi-directional many-to-one association to Catalog
	@OneToMany(mappedBy="concept")
	private List<Catalog> catalogs;

	//bi-directional many-to-one association to Catalogvalue
	@OneToMany(mappedBy="concept")
	private List<Catalogvalue> catalogvalues;

	//bi-directional many-to-one association to Agegroup
	@ManyToOne
	@JoinColumn(name="agegroupcode")
	private Agegroup agegroup;

	//bi-directional many-to-one association to Bdi
	@ManyToOne
	@JoinColumn(name="bdicode")
	private Bdi bdi;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="concepttype")
	private Concept concept;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="concept")
	private List<Concept> concepts;

	//bi-directional many-to-one association to Domain
	@ManyToOne
	@JoinColumn(name="domainid")
	private Domain domain;

	//bi-directional many-to-one association to Gender
	@ManyToOne
	@JoinColumn(name="gendercode")
	private Gender gender;

	//bi-directional many-to-one association to Weightgroup
	@ManyToOne
	@JoinColumn(name="weightgroupcode")
	private Weightgroup weightgroup;

	//bi-directional many-to-one association to Conceptrelation
	@OneToMany(mappedBy="concept1")
	private List<Conceptrelation> conceptrelations1;

	//bi-directional many-to-one association to Conceptrelation
	@OneToMany(mappedBy="concept2")
	private List<Conceptrelation> conceptrelations2;

	//bi-directional many-to-one association to Country
	@OneToMany(mappedBy="concept")
	private List<Country> countries;

	//bi-directional many-to-one association to Descriptor
	@OneToMany(mappedBy="concept")
	private List<Descriptor> descriptors;

	//bi-directional many-to-one association to Indexbyconcept
	@OneToMany(mappedBy="concept")
	private List<Indexbyconcept> indexbyconcepts;

	//bi-directional many-to-one association to Infotype
	@OneToMany(mappedBy="concept1")
	private List<Infotype> infotypes1;

	//bi-directional many-to-one association to Infotype
	@OneToMany(mappedBy="concept2")
	private List<Infotype> infotypes2;

	//bi-directional many-to-one association to Medicalspecialty
	@OneToMany(mappedBy="concept")
	private List<Medicalspecialty> medicalspecialties;

	public Concept() {
	}

	public String getConceptcode() {
		return this.conceptcode;
	}

	public void setConceptcode(String conceptcode) {
		this.conceptcode = conceptcode;
	}

	public String getCiacode() {
		return this.ciacode;
	}

	public void setCiacode(String ciacode) {
		this.ciacode = ciacode;
	}

	public String getConceptname() {
		return this.conceptname;
	}

	public void setConceptname(String conceptname) {
		this.conceptname = conceptname;
	}

	public String getConceptstatus() {
		return this.conceptstatus;
	}

	public void setConceptstatus(String conceptstatus) {
		this.conceptstatus = conceptstatus;
	}

	public String getMedicalspecialtycode() {
		return this.medicalspecialtycode;
	}

	public void setMedicalspecialtycode(String medicalspecialtycode) {
		this.medicalspecialtycode = medicalspecialtycode;
	}

	public String getMedicalspecialtyname() {
		return this.medicalspecialtyname;
	}

	public void setMedicalspecialtyname(String medicalspecialtyname) {
		this.medicalspecialtyname = medicalspecialtyname;
	}

	public String getPrimitiveconcept() {
		return this.primitiveconcept;
	}

	public void setPrimitiveconcept(String primitiveconcept) {
		this.primitiveconcept = primitiveconcept;
	}

	public String getSnomedcode() {
		return this.snomedcode;
	}

	public void setSnomedcode(String snomedcode) {
		this.snomedcode = snomedcode;
	}

	public List<Additionalvalue> getAdditionalvalues() {
		return this.additionalvalues;
	}

	public void setAdditionalvalues(List<Additionalvalue> additionalvalues) {
		this.additionalvalues = additionalvalues;
	}

	public Additionalvalue addAdditionalvalue(Additionalvalue additionalvalue) {
		getAdditionalvalues().add(additionalvalue);
		additionalvalue.setConcept(this);

		return additionalvalue;
	}

	public Additionalvalue removeAdditionalvalue(Additionalvalue additionalvalue) {
		getAdditionalvalues().remove(additionalvalue);
		additionalvalue.setConcept(null);

		return additionalvalue;
	}

	public List<Catalog> getCatalogs() {
		return this.catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	public Catalog addCatalog(Catalog catalog) {
		getCatalogs().add(catalog);
		catalog.setConcept(this);

		return catalog;
	}

	public Catalog removeCatalog(Catalog catalog) {
		getCatalogs().remove(catalog);
		catalog.setConcept(null);

		return catalog;
	}

	public List<Catalogvalue> getCatalogvalues() {
		return this.catalogvalues;
	}

	public void setCatalogvalues(List<Catalogvalue> catalogvalues) {
		this.catalogvalues = catalogvalues;
	}

	public Catalogvalue addCatalogvalue(Catalogvalue catalogvalue) {
		getCatalogvalues().add(catalogvalue);
		catalogvalue.setConcept(this);

		return catalogvalue;
	}

	public Catalogvalue removeCatalogvalue(Catalogvalue catalogvalue) {
		getCatalogvalues().remove(catalogvalue);
		catalogvalue.setConcept(null);

		return catalogvalue;
	}

	public Agegroup getAgegroup() {
		return this.agegroup;
	}

	public void setAgegroup(Agegroup agegroup) {
		this.agegroup = agegroup;
	}

	public Bdi getBdi() {
		return this.bdi;
	}

	public void setBdi(Bdi bdi) {
		this.bdi = bdi;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

	public Concept addConcept(Concept concept) {
		getConcepts().add(concept);
		concept.setConcept(this);

		return concept;
	}

	public Concept removeConcept(Concept concept) {
		getConcepts().remove(concept);
		concept.setConcept(null);

		return concept;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Weightgroup getWeightgroup() {
		return this.weightgroup;
	}

	public void setWeightgroup(Weightgroup weightgroup) {
		this.weightgroup = weightgroup;
	}

	public List<Conceptrelation> getConceptrelations1() {
		return this.conceptrelations1;
	}

	public void setConceptrelations1(List<Conceptrelation> conceptrelations1) {
		this.conceptrelations1 = conceptrelations1;
	}

	public Conceptrelation addConceptrelations1(Conceptrelation conceptrelations1) {
		getConceptrelations1().add(conceptrelations1);
		conceptrelations1.setConcept1(this);

		return conceptrelations1;
	}

	public Conceptrelation removeConceptrelations1(Conceptrelation conceptrelations1) {
		getConceptrelations1().remove(conceptrelations1);
		conceptrelations1.setConcept1(null);

		return conceptrelations1;
	}

	public List<Conceptrelation> getConceptrelations2() {
		return this.conceptrelations2;
	}

	public void setConceptrelations2(List<Conceptrelation> conceptrelations2) {
		this.conceptrelations2 = conceptrelations2;
	}

	public Conceptrelation addConceptrelations2(Conceptrelation conceptrelations2) {
		getConceptrelations2().add(conceptrelations2);
		conceptrelations2.setConcept2(this);

		return conceptrelations2;
	}

	public Conceptrelation removeConceptrelations2(Conceptrelation conceptrelations2) {
		getConceptrelations2().remove(conceptrelations2);
		conceptrelations2.setConcept2(null);

		return conceptrelations2;
	}

	public List<Country> getCountries() {
		return this.countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public Country addCountry(Country country) {
		getCountries().add(country);
		country.setConcept(this);

		return country;
	}

	public Country removeCountry(Country country) {
		getCountries().remove(country);
		country.setConcept(null);

		return country;
	}

	public List<Descriptor> getDescriptors() {
		return this.descriptors;
	}

	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}

	public Descriptor addDescriptor(Descriptor descriptor) {
		getDescriptors().add(descriptor);
		descriptor.setConcept(this);

		return descriptor;
	}

	public Descriptor removeDescriptor(Descriptor descriptor) {
		getDescriptors().remove(descriptor);
		descriptor.setConcept(null);

		return descriptor;
	}

	public List<Indexbyconcept> getIndexbyconcepts() {
		return this.indexbyconcepts;
	}

	public void setIndexbyconcepts(List<Indexbyconcept> indexbyconcepts) {
		this.indexbyconcepts = indexbyconcepts;
	}

	public Indexbyconcept addIndexbyconcept(Indexbyconcept indexbyconcept) {
		getIndexbyconcepts().add(indexbyconcept);
		indexbyconcept.setConcept(this);

		return indexbyconcept;
	}

	public Indexbyconcept removeIndexbyconcept(Indexbyconcept indexbyconcept) {
		getIndexbyconcepts().remove(indexbyconcept);
		indexbyconcept.setConcept(null);

		return indexbyconcept;
	}

	public List<Infotype> getInfotypes1() {
		return this.infotypes1;
	}

	public void setInfotypes1(List<Infotype> infotypes1) {
		this.infotypes1 = infotypes1;
	}

	public Infotype addInfotypes1(Infotype infotypes1) {
		getInfotypes1().add(infotypes1);
		infotypes1.setConcept1(this);

		return infotypes1;
	}

	public Infotype removeInfotypes1(Infotype infotypes1) {
		getInfotypes1().remove(infotypes1);
		infotypes1.setConcept1(null);

		return infotypes1;
	}

	public List<Infotype> getInfotypes2() {
		return this.infotypes2;
	}

	public void setInfotypes2(List<Infotype> infotypes2) {
		this.infotypes2 = infotypes2;
	}

	public Infotype addInfotypes2(Infotype infotypes2) {
		getInfotypes2().add(infotypes2);
		infotypes2.setConcept2(this);

		return infotypes2;
	}

	public Infotype removeInfotypes2(Infotype infotypes2) {
		getInfotypes2().remove(infotypes2);
		infotypes2.setConcept2(null);

		return infotypes2;
	}

	public List<Medicalspecialty> getMedicalspecialties() {
		return this.medicalspecialties;
	}

	public void setMedicalspecialties(List<Medicalspecialty> medicalspecialties) {
		this.medicalspecialties = medicalspecialties;
	}

	public Medicalspecialty addMedicalspecialty(Medicalspecialty medicalspecialty) {
		getMedicalspecialties().add(medicalspecialty);
		medicalspecialty.setConcept(this);

		return medicalspecialty;
	}

	public Medicalspecialty removeMedicalspecialty(Medicalspecialty medicalspecialty) {
		getMedicalspecialties().remove(medicalspecialty);
		medicalspecialty.setConcept(null);

		return medicalspecialty;
	}

}