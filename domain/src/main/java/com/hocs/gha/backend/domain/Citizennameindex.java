package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the citizennameindex database table.
 * 
 */
@Entity
@NamedQuery(name="Citizennameindex.findAll", query="SELECT c FROM Citizennameindex c")
public class Citizennameindex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer citizennameindexid;

	private String agegroupcode;

	private String bpacredentialtype;

	private String gendercode;

	private String indexcode;

	private String indextype;

	//bi-directional many-to-one association to Indexbycitizen
	@OneToMany(mappedBy="citizennameindex")
	private List<Indexbycitizen> indexbycitizens;

	public Citizennameindex() {
	}

	public Integer getCitizennameindexid() {
		return this.citizennameindexid;
	}

	public void setCitizennameindexid(Integer citizennameindexid) {
		this.citizennameindexid = citizennameindexid;
	}

	public String getAgegroupcode() {
		return this.agegroupcode;
	}

	public void setAgegroupcode(String agegroupcode) {
		this.agegroupcode = agegroupcode;
	}

	public String getBpacredentialtype() {
		return this.bpacredentialtype;
	}

	public void setBpacredentialtype(String bpacredentialtype) {
		this.bpacredentialtype = bpacredentialtype;
	}

	public String getGendercode() {
		return this.gendercode;
	}

	public void setGendercode(String gendercode) {
		this.gendercode = gendercode;
	}

	public String getIndexcode() {
		return this.indexcode;
	}

	public void setIndexcode(String indexcode) {
		this.indexcode = indexcode;
	}

	public String getIndextype() {
		return this.indextype;
	}

	public void setIndextype(String indextype) {
		this.indextype = indextype;
	}

	public List<Indexbycitizen> getIndexbycitizens() {
		return this.indexbycitizens;
	}

	public void setIndexbycitizens(List<Indexbycitizen> indexbycitizens) {
		this.indexbycitizens = indexbycitizens;
	}

	public Indexbycitizen addIndexbycitizen(Indexbycitizen indexbycitizen) {
		getIndexbycitizens().add(indexbycitizen);
		indexbycitizen.setCitizennameindex(this);

		return indexbycitizen;
	}

	public Indexbycitizen removeIndexbycitizen(Indexbycitizen indexbycitizen) {
		getIndexbycitizens().remove(indexbycitizen);
		indexbycitizen.setCitizennameindex(null);

		return indexbycitizen;
	}

}