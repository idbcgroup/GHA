package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ccdidefinition database table.
 * 
 */
@Entity
@NamedQuery(name="Ccdidefinition.findAll", query="SELECT c FROM Ccdidefinition c")
public class Ccdidefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cdicode;

	private Boolean cdiaddverificationdigit;

	private String cdicodetype;

	private BigDecimal cdidigits;

	private BigDecimal cdilevels;

	private String cdiname;

	private String cdistatus;

	private String cdiverificationdigitmethod;

	//bi-directional many-to-one association to Infotype
	@ManyToOne
	@JoinColumn(name="infotypecode")
	private Infotype infotype;

	//bi-directional many-to-one association to Ccdileveldefinition
	@OneToMany(mappedBy="ccdidefinition")
	private List<Ccdileveldefinition> ccdileveldefinitions;

	//bi-directional many-to-one association to Ccdilevelvalue
	@OneToMany(mappedBy="ccdidefinition")
	private List<Ccdilevelvalue> ccdilevelvalues;

	//bi-directional many-to-one association to Ccdivalueavailable
	@OneToMany(mappedBy="ccdidefinition")
	private List<Ccdivalueavailable> ccdivalueavailables;

	public Ccdidefinition() {
	}

	public String getCdicode() {
		return this.cdicode;
	}

	public void setCdicode(String cdicode) {
		this.cdicode = cdicode;
	}

	public Boolean getCdiaddverificationdigit() {
		return this.cdiaddverificationdigit;
	}

	public void setCdiaddverificationdigit(Boolean cdiaddverificationdigit) {
		this.cdiaddverificationdigit = cdiaddverificationdigit;
	}

	public String getCdicodetype() {
		return this.cdicodetype;
	}

	public void setCdicodetype(String cdicodetype) {
		this.cdicodetype = cdicodetype;
	}

	public BigDecimal getCdidigits() {
		return this.cdidigits;
	}

	public void setCdidigits(BigDecimal cdidigits) {
		this.cdidigits = cdidigits;
	}

	public BigDecimal getCdilevels() {
		return this.cdilevels;
	}

	public void setCdilevels(BigDecimal cdilevels) {
		this.cdilevels = cdilevels;
	}

	public String getCdiname() {
		return this.cdiname;
	}

	public void setCdiname(String cdiname) {
		this.cdiname = cdiname;
	}

	public String getCdistatus() {
		return this.cdistatus;
	}

	public void setCdistatus(String cdistatus) {
		this.cdistatus = cdistatus;
	}

	public String getCdiverificationdigitmethod() {
		return this.cdiverificationdigitmethod;
	}

	public void setCdiverificationdigitmethod(String cdiverificationdigitmethod) {
		this.cdiverificationdigitmethod = cdiverificationdigitmethod;
	}

	public Infotype getInfotype() {
		return this.infotype;
	}

	public void setInfotype(Infotype infotype) {
		this.infotype = infotype;
	}

	public List<Ccdileveldefinition> getCcdileveldefinitions() {
		return this.ccdileveldefinitions;
	}

	public void setCcdileveldefinitions(List<Ccdileveldefinition> ccdileveldefinitions) {
		this.ccdileveldefinitions = ccdileveldefinitions;
	}

	public Ccdileveldefinition addCcdileveldefinition(Ccdileveldefinition ccdileveldefinition) {
		getCcdileveldefinitions().add(ccdileveldefinition);
		ccdileveldefinition.setCcdidefinition(this);

		return ccdileveldefinition;
	}

	public Ccdileveldefinition removeCcdileveldefinition(Ccdileveldefinition ccdileveldefinition) {
		getCcdileveldefinitions().remove(ccdileveldefinition);
		ccdileveldefinition.setCcdidefinition(null);

		return ccdileveldefinition;
	}

	public List<Ccdilevelvalue> getCcdilevelvalues() {
		return this.ccdilevelvalues;
	}

	public void setCcdilevelvalues(List<Ccdilevelvalue> ccdilevelvalues) {
		this.ccdilevelvalues = ccdilevelvalues;
	}

	public Ccdilevelvalue addCcdilevelvalue(Ccdilevelvalue ccdilevelvalue) {
		getCcdilevelvalues().add(ccdilevelvalue);
		ccdilevelvalue.setCcdidefinition(this);

		return ccdilevelvalue;
	}

	public Ccdilevelvalue removeCcdilevelvalue(Ccdilevelvalue ccdilevelvalue) {
		getCcdilevelvalues().remove(ccdilevelvalue);
		ccdilevelvalue.setCcdidefinition(null);

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
		ccdivalueavailable.setCcdidefinition(this);

		return ccdivalueavailable;
	}

	public Ccdivalueavailable removeCcdivalueavailable(Ccdivalueavailable ccdivalueavailable) {
		getCcdivalueavailables().remove(ccdivalueavailable);
		ccdivalueavailable.setCcdidefinition(null);

		return ccdivalueavailable;
	}

}