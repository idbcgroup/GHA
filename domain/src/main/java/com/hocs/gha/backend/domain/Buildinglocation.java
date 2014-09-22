package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the buildinglocation database table.
 * 
 */
@Entity
@NamedQuery(name="Buildinglocation.findAll", query="SELECT b FROM Buildinglocation b")
public class Buildinglocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String buildinglocationcode;

	private String buildinglocationdescription;

	private String buildinglocationlevel;

	private String buildinglocationname;

	private BigDecimal buildinglocationunits;

	private String buildinglocationuse;

	//bi-directional many-to-one association to Bpi
	@ManyToOne
	@JoinColumn(name="bpicode")
	private Bpi bpi;

	//bi-directional many-to-one association to Buildinglocation
	@ManyToOne
	@JoinColumn(name="buildinglocationcodeparent")
	private Buildinglocation buildinglocation;

	//bi-directional many-to-one association to Buildinglocation
	@OneToMany(mappedBy="buildinglocation")
	private List<Buildinglocation> buildinglocations;

	//bi-directional many-to-one association to Locationtype
	@ManyToOne
	@JoinColumn(name="locationtypecode")
	private Locationtype locationtype;

	//bi-directional many-to-one association to Workingarea
	@OneToMany(mappedBy="buildinglocation")
	private List<Workingarea> workingareas;

	public Buildinglocation() {
	}

	public String getBuildinglocationcode() {
		return this.buildinglocationcode;
	}

	public void setBuildinglocationcode(String buildinglocationcode) {
		this.buildinglocationcode = buildinglocationcode;
	}

	public String getBuildinglocationdescription() {
		return this.buildinglocationdescription;
	}

	public void setBuildinglocationdescription(String buildinglocationdescription) {
		this.buildinglocationdescription = buildinglocationdescription;
	}

	public String getBuildinglocationlevel() {
		return this.buildinglocationlevel;
	}

	public void setBuildinglocationlevel(String buildinglocationlevel) {
		this.buildinglocationlevel = buildinglocationlevel;
	}

	public String getBuildinglocationname() {
		return this.buildinglocationname;
	}

	public void setBuildinglocationname(String buildinglocationname) {
		this.buildinglocationname = buildinglocationname;
	}

	public BigDecimal getBuildinglocationunits() {
		return this.buildinglocationunits;
	}

	public void setBuildinglocationunits(BigDecimal buildinglocationunits) {
		this.buildinglocationunits = buildinglocationunits;
	}

	public String getBuildinglocationuse() {
		return this.buildinglocationuse;
	}

	public void setBuildinglocationuse(String buildinglocationuse) {
		this.buildinglocationuse = buildinglocationuse;
	}

	public Bpi getBpi() {
		return this.bpi;
	}

	public void setBpi(Bpi bpi) {
		this.bpi = bpi;
	}

	public Buildinglocation getBuildinglocation() {
		return this.buildinglocation;
	}

	public void setBuildinglocation(Buildinglocation buildinglocation) {
		this.buildinglocation = buildinglocation;
	}

	public List<Buildinglocation> getBuildinglocations() {
		return this.buildinglocations;
	}

	public void setBuildinglocations(List<Buildinglocation> buildinglocations) {
		this.buildinglocations = buildinglocations;
	}

	public Buildinglocation addBuildinglocation(Buildinglocation buildinglocation) {
		getBuildinglocations().add(buildinglocation);
		buildinglocation.setBuildinglocation(this);

		return buildinglocation;
	}

	public Buildinglocation removeBuildinglocation(Buildinglocation buildinglocation) {
		getBuildinglocations().remove(buildinglocation);
		buildinglocation.setBuildinglocation(null);

		return buildinglocation;
	}

	public Locationtype getLocationtype() {
		return this.locationtype;
	}

	public void setLocationtype(Locationtype locationtype) {
		this.locationtype = locationtype;
	}

	public List<Workingarea> getWorkingareas() {
		return this.workingareas;
	}

	public void setWorkingareas(List<Workingarea> workingareas) {
		this.workingareas = workingareas;
	}

	public Workingarea addWorkingarea(Workingarea workingarea) {
		getWorkingareas().add(workingarea);
		workingarea.setBuildinglocation(this);

		return workingarea;
	}

	public Workingarea removeWorkingarea(Workingarea workingarea) {
		getWorkingareas().remove(workingarea);
		workingarea.setBuildinglocation(null);

		return workingarea;
	}

}