package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conceptnameindex database table.
 * 
 */
@Entity
@NamedQuery(name="Conceptnameindex.findAll", query="SELECT c FROM Conceptnameindex c")
public class Conceptnameindex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer indextextid;

	private String agegroupcode;

	private String ciacode;

	private String concepttype;

	private String concepttype01;

	private String concepttype02;

	private String concepttype03;

	private String gendercode;

	private String indexcode;

	private String indextype;

	private String language;

	private String medicalspecialtycode;

	private String realm;

	//bi-directional many-to-one association to Indexbyconcept
	@OneToMany(mappedBy="conceptnameindex")
	private List<Indexbyconcept> indexbyconcepts;

	public Conceptnameindex() {
	}

	public Integer getIndextextid() {
		return this.indextextid;
	}

	public void setIndextextid(Integer indextextid) {
		this.indextextid = indextextid;
	}

	public String getAgegroupcode() {
		return this.agegroupcode;
	}

	public void setAgegroupcode(String agegroupcode) {
		this.agegroupcode = agegroupcode;
	}

	public String getCiacode() {
		return this.ciacode;
	}

	public void setCiacode(String ciacode) {
		this.ciacode = ciacode;
	}

	public String getConcepttype() {
		return this.concepttype;
	}

	public void setConcepttype(String concepttype) {
		this.concepttype = concepttype;
	}

	public String getConcepttype01() {
		return this.concepttype01;
	}

	public void setConcepttype01(String concepttype01) {
		this.concepttype01 = concepttype01;
	}

	public String getConcepttype02() {
		return this.concepttype02;
	}

	public void setConcepttype02(String concepttype02) {
		this.concepttype02 = concepttype02;
	}

	public String getConcepttype03() {
		return this.concepttype03;
	}

	public void setConcepttype03(String concepttype03) {
		this.concepttype03 = concepttype03;
	}

	public String getGendercode() {
		return this.gendercode;
	}

	public void setGendercode(String gendercode) {
		this.gendercode = gendercode;
	}

	public String getIndexcode() {
		return this.indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode;
	}

	public String getIndextype() {
		return this.indextype;
	}

	public void setIndextype(String indextype) {
		this.indextype = indextype;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMedicalspecialtycode() {
		return this.medicalspecialtycode;
	}

	public void setMedicalspecialtycode(String medicalspecialtycode) {
		this.medicalspecialtycode = medicalspecialtycode;
	}

	public String getRealm() {
		return this.realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public List<Indexbyconcept> getIndexbyconcepts() {
		return this.indexbyconcepts;
	}

	public void setIndexbyconcepts(List<Indexbyconcept> indexbyconcepts) {
		this.indexbyconcepts = indexbyconcepts;
	}

	public Indexbyconcept addIndexbyconcept(Indexbyconcept indexbyconcept) {
		getIndexbyconcepts().add(indexbyconcept);
		indexbyconcept.setConceptnameindex(this);

		return indexbyconcept;
	}

	public Indexbyconcept removeIndexbyconcept(Indexbyconcept indexbyconcept) {
		getIndexbyconcepts().remove(indexbyconcept);
		indexbyconcept.setConceptnameindex(null);

		return indexbyconcept;
	}

}