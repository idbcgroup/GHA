package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the citizeneducation database table.
 * 
 */
@Entity
@NamedQuery(name="Citizeneducation.findAll", query="SELECT c FROM Citizeneducation c")
public class Citizeneducation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer citizeneducationid;

	private String actuallystudying;

	private String actualstudy;

	private String actualstudytype;

	private Timestamp datemodified;

	private String educationdegree;

	//bi-directional many-to-one association to Citizen
	@ManyToOne
	@JoinColumn(name="citizenid")
	private Citizen citizen;

	public Citizeneducation() {
	}

	public Integer getCitizeneducationid() {
		return this.citizeneducationid;
	}

	public void setCitizeneducationid(Integer citizeneducationid) {
		this.citizeneducationid = citizeneducationid;
	}

	public String getActuallystudying() {
		return this.actuallystudying;
	}

	public void setActuallystudying(String actuallystudying) {
		this.actuallystudying = actuallystudying;
	}

	public String getActualstudy() {
		return this.actualstudy;
	}

	public void setActualstudy(String actualstudy) {
		this.actualstudy = actualstudy;
	}

	public String getActualstudytype() {
		return this.actualstudytype;
	}

	public void setActualstudytype(String actualstudytype) {
		this.actualstudytype = actualstudytype;
	}

	public Timestamp getDatemodified() {
		return this.datemodified;
	}

	public void setDatemodified(Timestamp datemodified) {
		this.datemodified = datemodified;
	}

	public String getEducationdegree() {
		return this.educationdegree;
	}

	public void setEducationdegree(String educationdegree) {
		this.educationdegree = educationdegree;
	}

	public Citizen getCitizen() {
		return this.citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

}