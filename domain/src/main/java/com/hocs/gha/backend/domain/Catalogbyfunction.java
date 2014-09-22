package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the catalogbyfunction database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogbyfunction.findAll", query="SELECT c FROM Catalogbyfunction c")
public class Catalogbyfunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long catalogbyfunctionid;

	private Boolean catalogbyfunctionenable;

	//bi-directional many-to-one association to Catalog
	@ManyToOne
	@JoinColumn(name="catalogid")
	private Catalog catalog;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function;

	//bi-directional many-to-one association to Systemmodule
	@ManyToOne
	@JoinColumn(name="modulecode")
	private Systemmodule systemmodule;

	public Catalogbyfunction() {
	}

	public long getCatalogbyfunctionid() {
		return this.catalogbyfunctionid;
	}

	public void setCatalogbyfunctionid(long catalogbyfunctionid) {
		this.catalogbyfunctionid = catalogbyfunctionid;
	}

	public Boolean getCatalogbyfunctionenable() {
		return this.catalogbyfunctionenable;
	}

	public void setCatalogbyfunctionenable(Boolean catalogbyfunctionenable) {
		this.catalogbyfunctionenable = catalogbyfunctionenable;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Systemmodule getSystemmodule() {
		return this.systemmodule;
	}

	public void setSystemmodule(Systemmodule systemmodule) {
		this.systemmodule = systemmodule;
	}

}