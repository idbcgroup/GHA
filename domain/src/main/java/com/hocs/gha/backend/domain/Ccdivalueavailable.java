package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ccdivalueavailable database table.
 * 
 */
@Entity
@NamedQuery(name="Ccdivalueavailable.findAll", query="SELECT c FROM Ccdivalueavailable c")
public class Ccdivalueavailable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer cdivalueavailableid;

	private String cdivalueavailablecode;

	//bi-directional many-to-one association to Ccdidefinition
	@ManyToOne
	@JoinColumn(name="cdicode")
	private Ccdidefinition ccdidefinition;

	//bi-directional many-to-one association to Ccdilevelvalue
	@ManyToOne
	@JoinColumn(name="cdivalueavailableparentcode")
	private Ccdilevelvalue ccdilevelvalue;

	public Ccdivalueavailable() {
	}

	public Integer getCdivalueavailableid() {
		return this.cdivalueavailableid;
	}

	public void setCdivalueavailableid(Integer cdivalueavailableid) {
		this.cdivalueavailableid = cdivalueavailableid;
	}

	public String getCdivalueavailablecode() {
		return this.cdivalueavailablecode;
	}

	public void setCdivalueavailablecode(String cdivalueavailablecode) {
		this.cdivalueavailablecode = cdivalueavailablecode;
	}

	public Ccdidefinition getCcdidefinition() {
		return this.ccdidefinition;
	}

	public void setCcdidefinition(Ccdidefinition ccdidefinition) {
		this.ccdidefinition = ccdidefinition;
	}

	public Ccdilevelvalue getCcdilevelvalue() {
		return this.ccdilevelvalue;
	}

	public void setCcdilevelvalue(Ccdilevelvalue ccdilevelvalue) {
		this.ccdilevelvalue = ccdilevelvalue;
	}

}