package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the additionalvalue database table.
 * 
 */
@Entity
@NamedQuery(name="Additionalvalue.findAll", query="SELECT a FROM Additionalvalue a")
public class Additionalvalue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer additionalvalueid;

	private String additionalvalue01;

	private String additionalvalue02;

	private String additionalvalue03;

	private String additionalvaluetype01;

	private String additionalvaluetype02;

	private String additionalvaluetype03;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="conceptcode")
	private Concept concept;

	public Additionalvalue() {
	}

	public Integer getAdditionalvalueid() {
		return this.additionalvalueid;
	}

	public void setAdditionalvalueid(Integer additionalvalueid) {
		this.additionalvalueid = additionalvalueid;
	}

	public String getAdditionalvalue01() {
		return this.additionalvalue01;
	}

	public void setAdditionalvalue01(String additionalvalue01) {
		this.additionalvalue01 = additionalvalue01;
	}

	public String getAdditionalvalue02() {
		return this.additionalvalue02;
	}

	public void setAdditionalvalue02(String additionalvalue02) {
		this.additionalvalue02 = additionalvalue02;
	}

	public String getAdditionalvalue03() {
		return this.additionalvalue03;
	}

	public void setAdditionalvalue03(String additionalvalue03) {
		this.additionalvalue03 = additionalvalue03;
	}

	public String getAdditionalvaluetype01() {
		return this.additionalvaluetype01;
	}

	public void setAdditionalvaluetype01(String additionalvaluetype01) {
		this.additionalvaluetype01 = additionalvaluetype01;
	}

	public String getAdditionalvaluetype02() {
		return this.additionalvaluetype02;
	}

	public void setAdditionalvaluetype02(String additionalvaluetype02) {
		this.additionalvaluetype02 = additionalvaluetype02;
	}

	public String getAdditionalvaluetype03() {
		return this.additionalvaluetype03;
	}

	public void setAdditionalvaluetype03(String additionalvaluetype03) {
		this.additionalvaluetype03 = additionalvaluetype03;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

}