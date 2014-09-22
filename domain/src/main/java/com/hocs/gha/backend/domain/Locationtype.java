package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the locationtype database table.
 * 
 */
@Entity
@NamedQuery(name="Locationtype.findAll", query="SELECT l FROM Locationtype l")
public class Locationtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String locationtypecode;

	private String locationservicecode;

	private String locationtypedescription;

	private String locationtypefunction;

	//bi-directional many-to-one association to Buildinglocation
	@OneToMany(mappedBy="locationtype")
	private List<Buildinglocation> buildinglocations;

	//bi-directional many-to-one association to Locationtype
	@ManyToOne
	@JoinColumn(name="locationtypecodeparent")
	private Locationtype locationtype;

	//bi-directional many-to-one association to Locationtype
	@OneToMany(mappedBy="locationtype")
	private List<Locationtype> locationtypes;

	//bi-directional many-to-one association to Serviceresourcecategory
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="serviceresourcearea", referencedColumnName="serviceresourcearea"),
		@JoinColumn(name="serviceresourcesubtype", referencedColumnName="serviceresourcesubtype"),
		@JoinColumn(name="serviceresourcetype", referencedColumnName="serviceresourcetype")
		})
	private Serviceresourcecategory serviceresourcecategory;

	//bi-directional many-to-one association to Workingarea
	@OneToMany(mappedBy="locationtype")
	private List<Workingarea> workingareas;

	public Locationtype() {
	}

	public String getLocationtypecode() {
		return this.locationtypecode;
	}

	public void setLocationtypecode(String locationtypecode) {
		this.locationtypecode = locationtypecode;
	}

	public String getLocationservicecode() {
		return this.locationservicecode;
	}

	public void setLocationservicecode(String locationservicecode) {
		this.locationservicecode = locationservicecode;
	}

	public String getLocationtypedescription() {
		return this.locationtypedescription;
	}

	public void setLocationtypedescription(String locationtypedescription) {
		this.locationtypedescription = locationtypedescription;
	}

	public String getLocationtypefunction() {
		return this.locationtypefunction;
	}

	public void setLocationtypefunction(String locationtypefunction) {
		this.locationtypefunction = locationtypefunction;
	}

	public List<Buildinglocation> getBuildinglocations() {
		return this.buildinglocations;
	}

	public void setBuildinglocations(List<Buildinglocation> buildinglocations) {
		this.buildinglocations = buildinglocations;
	}

	public Buildinglocation addBuildinglocation(Buildinglocation buildinglocation) {
		getBuildinglocations().add(buildinglocation);
		buildinglocation.setLocationtype(this);

		return buildinglocation;
	}

	public Buildinglocation removeBuildinglocation(Buildinglocation buildinglocation) {
		getBuildinglocations().remove(buildinglocation);
		buildinglocation.setLocationtype(null);

		return buildinglocation;
	}

	public Locationtype getLocationtype() {
		return this.locationtype;
	}

	public void setLocationtype(Locationtype locationtype) {
		this.locationtype = locationtype;
	}

	public List<Locationtype> getLocationtypes() {
		return this.locationtypes;
	}

	public void setLocationtypes(List<Locationtype> locationtypes) {
		this.locationtypes = locationtypes;
	}

	public Locationtype addLocationtype(Locationtype locationtype) {
		getLocationtypes().add(locationtype);
		locationtype.setLocationtype(this);

		return locationtype;
	}

	public Locationtype removeLocationtype(Locationtype locationtype) {
		getLocationtypes().remove(locationtype);
		locationtype.setLocationtype(null);

		return locationtype;
	}

	public Serviceresourcecategory getServiceresourcecategory() {
		return this.serviceresourcecategory;
	}

	public void setServiceresourcecategory(Serviceresourcecategory serviceresourcecategory) {
		this.serviceresourcecategory = serviceresourcecategory;
	}

	public List<Workingarea> getWorkingareas() {
		return this.workingareas;
	}

	public void setWorkingareas(List<Workingarea> workingareas) {
		this.workingareas = workingareas;
	}

	public Workingarea addWorkingarea(Workingarea workingarea) {
		getWorkingareas().add(workingarea);
		workingarea.setLocationtype(this);

		return workingarea;
	}

	public Workingarea removeWorkingarea(Workingarea workingarea) {
		getWorkingareas().remove(workingarea);
		workingarea.setLocationtype(null);

		return workingarea;
	}

}