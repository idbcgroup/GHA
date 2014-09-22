package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalog database table.
 * 
 */
@Entity
@NamedQuery(name="Catalog.findAll", query="SELECT c FROM Catalog c")
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer catalogid;

	private String catalogname;

	private String catalogtype;

	//bi-directional many-to-one association to Catalog
	@ManyToOne
	@JoinColumn(name="catalogparentid")
	private Catalog catalog;

	//bi-directional many-to-one association to Catalog
	@OneToMany(mappedBy="catalog")
	private List<Catalog> catalogs;

	//bi-directional many-to-one association to Catalogclasification
	@ManyToOne
	@JoinColumn(name="catalogclasificationid")
	private Catalogclasification catalogclasification;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="conceptcode")
	private Concept concept;

	//bi-directional many-to-one association to Catalogbyfunction
	@OneToMany(mappedBy="catalog")
	private List<Catalogbyfunction> catalogbyfunctions;

	//bi-directional many-to-one association to Catalogvalue
	@OneToMany(mappedBy="catalog")
	private List<Catalogvalue> catalogvalues;

	public Catalog() {
	}

	public Integer getCatalogid() {
		return this.catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public String getCatalogname() {
		return this.catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public String getCatalogtype() {
		return this.catalogtype;
	}

	public void setCatalogtype(String catalogtype) {
		this.catalogtype = catalogtype;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public List<Catalog> getCatalogs() {
		return this.catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	public Catalog addCatalog(Catalog catalog) {
		getCatalogs().add(catalog);
		catalog.setCatalog(this);

		return catalog;
	}

	public Catalog removeCatalog(Catalog catalog) {
		getCatalogs().remove(catalog);
		catalog.setCatalog(null);

		return catalog;
	}

	public Catalogclasification getCatalogclasification() {
		return this.catalogclasification;
	}

	public void setCatalogclasification(Catalogclasification catalogclasification) {
		this.catalogclasification = catalogclasification;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public List<Catalogbyfunction> getCatalogbyfunctions() {
		return this.catalogbyfunctions;
	}

	public void setCatalogbyfunctions(List<Catalogbyfunction> catalogbyfunctions) {
		this.catalogbyfunctions = catalogbyfunctions;
	}

	public Catalogbyfunction addCatalogbyfunction(Catalogbyfunction catalogbyfunction) {
		getCatalogbyfunctions().add(catalogbyfunction);
		catalogbyfunction.setCatalog(this);

		return catalogbyfunction;
	}

	public Catalogbyfunction removeCatalogbyfunction(Catalogbyfunction catalogbyfunction) {
		getCatalogbyfunctions().remove(catalogbyfunction);
		catalogbyfunction.setCatalog(null);

		return catalogbyfunction;
	}

	public List<Catalogvalue> getCatalogvalues() {
		return this.catalogvalues;
	}

	public void setCatalogvalues(List<Catalogvalue> catalogvalues) {
		this.catalogvalues = catalogvalues;
	}

	public Catalogvalue addCatalogvalue(Catalogvalue catalogvalue) {
		getCatalogvalues().add(catalogvalue);
		catalogvalue.setCatalog(this);

		return catalogvalue;
	}

	public Catalogvalue removeCatalogvalue(Catalogvalue catalogvalue) {
		getCatalogvalues().remove(catalogvalue);
		catalogvalue.setCatalog(null);

		return catalogvalue;
	}

}