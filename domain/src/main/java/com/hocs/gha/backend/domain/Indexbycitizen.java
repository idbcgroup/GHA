package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the indexbycitizen database table.
 * 
 */
@Entity
@NamedQuery(name="Indexbycitizen.findAll", query="SELECT i FROM Indexbycitizen i")
public class Indexbycitizen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer indexbycitizenid;

	//bi-directional many-to-one association to Citizen
	@ManyToOne
	@JoinColumn(name="citizenid")
	private Citizen citizen;

	//bi-directional many-to-one association to Citizennameindex
	@ManyToOne
	@JoinColumn(name="citizennameindexid")
	private Citizennameindex citizennameindex;

	public Indexbycitizen() {
	}

	public Integer getIndexbycitizenid() {
		return this.indexbycitizenid;
	}

	public void setIndexbycitizenid(Integer indexbycitizenid) {
		this.indexbycitizenid = indexbycitizenid;
	}

	public Citizen getCitizen() {
		return this.citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Citizennameindex getCitizennameindex() {
		return this.citizennameindex;
	}

	public void setCitizennameindex(Citizennameindex citizennameindex) {
		this.citizennameindex = citizennameindex;
	}

}