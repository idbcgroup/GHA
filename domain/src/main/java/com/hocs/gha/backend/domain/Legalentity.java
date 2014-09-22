package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the legalentity database table.
 * 
 */
@Entity
@NamedQuery(name="Legalentity.findAll", query="SELECT l FROM Legalentity l")
public class Legalentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String legalentitycode;

	private Timestamp datecreated;

	private String legalentitytype;

	//bi-directional many-to-one association to Bpa
	@OneToMany(mappedBy="legalentity")
	private List<Bpa> bpas;

	//bi-directional many-to-one association to Citizen
	@OneToMany(mappedBy="legalentity")
	private List<Citizen> citizens;

	//bi-directional many-to-one association to Institution
	@OneToMany(mappedBy="legalentity")
	private List<Institution> institutions;

	//bi-directional many-to-one association to Legalentityaddress
	@OneToMany(mappedBy="legalentity")
	private List<Legalentityaddress> legalentityaddresses;

	public Legalentity() {
	}

	public String getLegalentitycode() {
		return this.legalentitycode;
	}

	public void setLegalentitycode(String legalentitycode) {
		this.legalentitycode = legalentitycode;
	}

	public Timestamp getDatecreated() {
		return this.datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public String getLegalentitytype() {
		return this.legalentitytype;
	}

	public void setLegalentitytype(String legalentitytype) {
		this.legalentitytype = legalentitytype;
	}

	public List<Bpa> getBpas() {
		return this.bpas;
	}

	public void setBpas(List<Bpa> bpas) {
		this.bpas = bpas;
	}

	public Bpa addBpa(Bpa bpa) {
		getBpas().add(bpa);
		bpa.setLegalentity(this);

		return bpa;
	}

	public Bpa removeBpa(Bpa bpa) {
		getBpas().remove(bpa);
		bpa.setLegalentity(null);

		return bpa;
	}

	public List<Citizen> getCitizens() {
		return this.citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}

	public Citizen addCitizen(Citizen citizen) {
		getCitizens().add(citizen);
		citizen.setLegalentity(this);

		return citizen;
	}

	public Citizen removeCitizen(Citizen citizen) {
		getCitizens().remove(citizen);
		citizen.setLegalentity(null);

		return citizen;
	}

	public List<Institution> getInstitutions() {
		return this.institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}

	public Institution addInstitution(Institution institution) {
		getInstitutions().add(institution);
		institution.setLegalentity(this);

		return institution;
	}

	public Institution removeInstitution(Institution institution) {
		getInstitutions().remove(institution);
		institution.setLegalentity(null);

		return institution;
	}

	public List<Legalentityaddress> getLegalentityaddresses() {
		return this.legalentityaddresses;
	}

	public void setLegalentityaddresses(List<Legalentityaddress> legalentityaddresses) {
		this.legalentityaddresses = legalentityaddresses;
	}

	public Legalentityaddress addLegalentityaddress(Legalentityaddress legalentityaddress) {
		getLegalentityaddresses().add(legalentityaddress);
		legalentityaddress.setLegalentity(this);

		return legalentityaddress;
	}

	public Legalentityaddress removeLegalentityaddress(Legalentityaddress legalentityaddress) {
		getLegalentityaddresses().remove(legalentityaddress);
		legalentityaddress.setLegalentity(null);

		return legalentityaddress;
	}

}