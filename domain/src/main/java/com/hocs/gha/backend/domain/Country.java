package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String countrycode;

	private String countrylevel;

	private String countryname;

	private String nationality;

	//bi-directional many-to-one association to Concept
	@ManyToOne
	@JoinColumn(name="conceptcode")
	private Concept concept;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="countrycodeparent")
	private Country country;

	//bi-directional many-to-one association to Country
	@OneToMany(mappedBy="country")
	private List<Country> countries;

	public Country() {
	}

	public String getCountrycode() {
		return this.countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getCountrylevel() {
		return this.countrylevel;
	}

	public void setCountrylevel(String countrylevel) {
		this.countrylevel = countrylevel;
	}

	public String getCountryname() {
		return this.countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Concept getConcept() {
		return this.concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Country> getCountries() {
		return this.countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public Country addCountry(Country country) {
		getCountries().add(country);
		country.setCountry(this);

		return country;
	}

	public Country removeCountry(Country country) {
		getCountries().remove(country);
		country.setCountry(null);

		return country;
	}

}