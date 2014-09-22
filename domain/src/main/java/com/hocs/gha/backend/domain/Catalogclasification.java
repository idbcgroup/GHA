package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogclasification database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogclasification.findAll", query="SELECT c FROM Catalogclasification c")
public class Catalogclasification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer catalogclasificationid;

	private String catalogclasificationdescription;

	private String catalogclasificationname;

	//bi-directional many-to-one association to Catalog
	@OneToMany(mappedBy="catalogclasification")
	private List<Catalog> catalogs;

	//bi-directional many-to-one association to Catalogclasification
	@ManyToOne
	@JoinColumn(name="catalogclasificationparentid")
	private Catalogclasification catalogclasification;

	//bi-directional many-to-one association to Catalogclasification
	@OneToMany(mappedBy="catalogclasification")
	private List<Catalogclasification> catalogclasifications;

	public Catalogclasification() {
	}

	public Integer getCatalogclasificationid() {
		return this.catalogclasificationid;
	}

	public void setCatalogclasificationid(Integer catalogclasificationid) {
		this.catalogclasificationid = catalogclasificationid;
	}

	public String getCatalogclasificationdescription() {
		return this.catalogclasificationdescription;
	}

	public void setCatalogclasificationdescription(String catalogclasificationdescription) {
		this.catalogclasificationdescription = catalogclasificationdescription;
	}

	public String getCatalogclasificationname() {
		return this.catalogclasificationname;
	}

	public void setCatalogclasificationname(String catalogclasificationname) {
		this.catalogclasificationname = catalogclasificationname;
	}

	public List<Catalog> getCatalogs() {
		return this.catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	public Catalog addCatalog(Catalog catalog) {
		getCatalogs().add(catalog);
		catalog.setCatalogclasification(this);

		return catalog;
	}

	public Catalog removeCatalog(Catalog catalog) {
		getCatalogs().remove(catalog);
		catalog.setCatalogclasification(null);

		return catalog;
	}

	public Catalogclasification getCatalogclasification() {
		return this.catalogclasification;
	}

	public void setCatalogclasification(Catalogclasification catalogclasification) {
		this.catalogclasification = catalogclasification;
	}

	public List<Catalogclasification> getCatalogclasifications() {
		return this.catalogclasifications;
	}

	public void setCatalogclasifications(List<Catalogclasification> catalogclasifications) {
		this.catalogclasifications = catalogclasifications;
	}

	public Catalogclasification addCatalogclasification(Catalogclasification catalogclasification) {
		getCatalogclasifications().add(catalogclasification);
		catalogclasification.setCatalogclasification(this);

		return catalogclasification;
	}

	public Catalogclasification removeCatalogclasification(Catalogclasification catalogclasification) {
		getCatalogclasifications().remove(catalogclasification);
		catalogclasification.setCatalogclasification(null);

		return catalogclasification;
	}

}