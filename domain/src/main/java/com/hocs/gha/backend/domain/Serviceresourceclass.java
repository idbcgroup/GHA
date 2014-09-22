package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the serviceresourceclass database table.
 * 
 */
@Entity
@NamedQuery(name="Serviceresourceclass.findAll", query="SELECT s FROM Serviceresourceclass s")
public class Serviceresourceclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String serviceresourceclasscode;

	private String serviceresourceclassinfotype;

	private String serviceresourceclassname;

	//bi-directional many-to-one association to Serviceresourcecategory
	@OneToMany(mappedBy="serviceresourceclass")
	private List<Serviceresourcecategory> serviceresourcecategories;

	public Serviceresourceclass() {
	}

	public String getServiceresourceclasscode() {
		return this.serviceresourceclasscode;
	}

	public void setServiceresourceclasscode(String serviceresourceclasscode) {
		this.serviceresourceclasscode = serviceresourceclasscode;
	}

	public String getServiceresourceclassinfotype() {
		return this.serviceresourceclassinfotype;
	}

	public void setServiceresourceclassinfotype(String serviceresourceclassinfotype) {
		this.serviceresourceclassinfotype = serviceresourceclassinfotype;
	}

	public String getServiceresourceclassname() {
		return this.serviceresourceclassname;
	}

	public void setServiceresourceclassname(String serviceresourceclassname) {
		this.serviceresourceclassname = serviceresourceclassname;
	}

	public List<Serviceresourcecategory> getServiceresourcecategories() {
		return this.serviceresourcecategories;
	}

	public void setServiceresourcecategories(List<Serviceresourcecategory> serviceresourcecategories) {
		this.serviceresourcecategories = serviceresourcecategories;
	}

	public Serviceresourcecategory addServiceresourcecategory(Serviceresourcecategory serviceresourcecategory) {
		getServiceresourcecategories().add(serviceresourcecategory);
		serviceresourcecategory.setServiceresourceclass(this);

		return serviceresourcecategory;
	}

	public Serviceresourcecategory removeServiceresourcecategory(Serviceresourcecategory serviceresourcecategory) {
		getServiceresourcecategories().remove(serviceresourcecategory);
		serviceresourcecategory.setServiceresourceclass(null);

		return serviceresourcecategory;
	}

}