package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ccdilevelvalue database table.
 * 
 */
@Entity
@NamedQuery(name="Ccdilevelvalue.findAll", query="SELECT c FROM Ccdilevelvalue c")
public class Ccdilevelvalue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cdivaluecode;

	private String cdinamethislevel;

	private String cdithisvaluestatus;

	private String cdivaluenextlevel;

	private String thislevel;

	//bi-directional many-to-one association to Ccdidefinition
	@ManyToOne
	@JoinColumn(name="cdicode")
	private Ccdidefinition ccdidefinition;

	//bi-directional many-to-one association to Ccdilevelvalue
	@ManyToOne
	@JoinColumn(name="cdivalueparentcode")
	private Ccdilevelvalue ccdilevelvalue;

	//bi-directional many-to-one association to Ccdilevelvalue
	@OneToMany(mappedBy="ccdilevelvalue")
	private List<Ccdilevelvalue> ccdilevelvalues;

	//bi-directional many-to-one association to Ccdivalueavailable
	@OneToMany(mappedBy="ccdilevelvalue")
	private List<Ccdivalueavailable> ccdivalueavailables;

	public Ccdilevelvalue() {
	}

	public String getCdivaluecode() {
		return this.cdivaluecode;
	}

	public void setCdivaluecode(String cdivaluecode) {
		this.cdivaluecode = cdivaluecode;
	}

	public String getCdinamethislevel() {
		return this.cdinamethislevel;
	}

	public void setCdinamethislevel(String cdinamethislevel) {
		this.cdinamethislevel = cdinamethislevel;
	}

	public String getCdithisvaluestatus() {
		return this.cdithisvaluestatus;
	}

	public void setCdithisvaluestatus(String cdithisvaluestatus) {
		this.cdithisvaluestatus = cdithisvaluestatus;
	}

	public String getCdivaluenextlevel() {
		return this.cdivaluenextlevel;
	}

	public void setCdivaluenextlevel(String cdivaluenextlevel) {
		this.cdivaluenextlevel = cdivaluenextlevel;
	}

	public String getThislevel() {
		return this.thislevel;
	}

	public void setThislevel(String thislevel) {
		this.thislevel = thislevel;
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

	public List<Ccdilevelvalue> getCcdilevelvalues() {
		return this.ccdilevelvalues;
	}

	public void setCcdilevelvalues(List<Ccdilevelvalue> ccdilevelvalues) {
		this.ccdilevelvalues = ccdilevelvalues;
	}

	public Ccdilevelvalue addCcdilevelvalue(Ccdilevelvalue ccdilevelvalue) {
		getCcdilevelvalues().add(ccdilevelvalue);
		ccdilevelvalue.setCcdilevelvalue(this);

		return ccdilevelvalue;
	}

	public Ccdilevelvalue removeCcdilevelvalue(Ccdilevelvalue ccdilevelvalue) {
		getCcdilevelvalues().remove(ccdilevelvalue);
		ccdilevelvalue.setCcdilevelvalue(null);

		return ccdilevelvalue;
	}

	public List<Ccdivalueavailable> getCcdivalueavailables() {
		return this.ccdivalueavailables;
	}

	public void setCcdivalueavailables(List<Ccdivalueavailable> ccdivalueavailables) {
		this.ccdivalueavailables = ccdivalueavailables;
	}

	public Ccdivalueavailable addCcdivalueavailable(Ccdivalueavailable ccdivalueavailable) {
		getCcdivalueavailables().add(ccdivalueavailable);
		ccdivalueavailable.setCcdilevelvalue(this);

		return ccdivalueavailable;
	}

	public Ccdivalueavailable removeCcdivalueavailable(Ccdivalueavailable ccdivalueavailable) {
		getCcdivalueavailables().remove(ccdivalueavailable);
		ccdivalueavailable.setCcdilevelvalue(null);

		return ccdivalueavailable;
	}

}