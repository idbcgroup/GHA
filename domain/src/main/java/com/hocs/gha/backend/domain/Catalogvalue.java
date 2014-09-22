package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the catalogvalue database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogvalue.findAll", query="SELECT c FROM Catalogvalue c")
public class Catalogvalue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer catalogvalueid;

	private String cataloglabel;

	private Boolean hasadditionalvalues;

	private BigDecimal language;

	//bi-directional many-to-one association to Catalog
	@ManyToOne
	@JoinColumn(name="catalogid")
	private Catalog catalog;

	//bi-directional many-to-one association to Catalogvalue
	@ManyToOne
	@JoinColumn(name="catalogvalueparentid")
	private Catalogvalue catalogvalue;

	//bi-directional many-to-one association to Catalogvalue
	@OneToMany(mappedBy="catalogvalue")
	private List<Catalogvalue> catalogvalues;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="conceptcode")
	private Concept concept;

	public Catalogvalue() {
	}

	public Integer getCatalogvalueid() {
		return this.catalogvalueid;
	}

	public void setCatalogvalueid(Integer catalogvalueid) {
		this.catalogvalueid = catalogvalueid;
	}

	public String getCataloglabel() {
		return this.cataloglabel;
	}

	public void setCataloglabel(String cataloglabel) {
		this.cataloglabel = cataloglabel;
	}

	public Boolean getHasadditionalvalues() {
		return this.hasadditionalvalues;
	}

	public void setHasadditionalvalues(Boolean hasadditionalvalues) {
		this.hasadditionalvalues = hasadditionalvalues;
	}

	public BigDecimal getLanguage() {
		return this.language;
	}

	public void setLanguage(BigDecimal language) {
		this.language = language;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Catalogvalue getCatalogvalue() {
		return this.catalogvalue;
	}

	public void setCatalogvalue(Catalogvalue catalogvalue) {
		this.catalogvalue = catalogvalue;
	}

	public List<Catalogvalue> getCatalogvalues() {
		return this.catalogvalues;
	}

	public void setCatalogvalues(List<Catalogvalue> catalogvalues) {
		this.catalogvalues = catalogvalues;
	}

	public Catalogvalue addCatalogvalue(Catalogvalue catalogvalue) {
		getCatalogvalues().add(catalogvalue);
		catalogvalue.setCatalogvalue(this);

		return catalogvalue;
	}

	public Catalogvalue removeCatalogvalue(Catalogvalue catalogvalue) {
		getCatalogvalues().remove(catalogvalue);
		catalogvalue.setCatalogvalue(null);

		return catalogvalue;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

}