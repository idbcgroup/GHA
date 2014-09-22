package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the descriptor database table.
 * 
 */
@Entity
@NamedQuery(name="Descriptor.findAll", query="SELECT d FROM Descriptor d")
public class Descriptor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer descriptorid;

	private String applicationequivalencetype;

	private String descriptor;

	private String descriptorcode;

	private String descriptortype;

	private String equivalencelevel;

	private String equivalencerole;

	private String equivalencetype;

	private String language;

	private String realm;

	private String statusdescription;

	private String term;

	private String translationcode;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="conceptcode")
	private Concept concept;

	//bi-directional many-to-one association to Descriptordetail
	@OneToMany(mappedBy="descriptor")
	private List<Descriptordetail> descriptordetails;

	public Descriptor() {
	}

	public Integer getDescriptorid() {
		return this.descriptorid;
	}

	public void setDescriptorid(Integer descriptorid) {
		this.descriptorid = descriptorid;
	}

	public String getApplicationequivalencetype() {
		return this.applicationequivalencetype;
	}

	public void setApplicationequivalencetype(String applicationequivalencetype) {
		this.applicationequivalencetype = applicationequivalencetype;
	}

	public String getDescriptor() {
		return this.descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getDescriptorcode() {
		return this.descriptorcode;
	}

	public void setDescriptorcode(String descriptorcode) {
		this.descriptorcode = descriptorcode;
	}

	public String getDescriptortype() {
		return this.descriptortype;
	}

	public void setDescriptortype(String descriptortype) {
		this.descriptortype = descriptortype;
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

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRealm() {
		return this.realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public String getStatusdescription() {
		return this.statusdescription;
	}

	public void setStatusdescription(String statusdescription) {
		this.statusdescription = statusdescription;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTranslationcode() {
		return this.translationcode;
	}

	public void setTranslationcode(String translationcode) {
		this.translationcode = translationcode;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public List<Descriptordetail> getDescriptordetails() {
		return this.descriptordetails;
	}

	public void setDescriptordetails(List<Descriptordetail> descriptordetails) {
		this.descriptordetails = descriptordetails;
	}

	public Descriptordetail addDescriptordetail(Descriptordetail descriptordetail) {
		getDescriptordetails().add(descriptordetail);
		descriptordetail.setDescriptor(this);

		return descriptordetail;
	}

	public Descriptordetail removeDescriptordetail(Descriptordetail descriptordetail) {
		getDescriptordetails().remove(descriptordetail);
		descriptordetail.setDescriptor(null);

		return descriptordetail;
	}

}