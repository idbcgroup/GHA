package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ccdileveldefinition database table.
 * 
 */
@Entity
@NamedQuery(name="Ccdileveldefinition.findAll", query="SELECT c FROM Ccdileveldefinition c")
public class Ccdileveldefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer cdilevelid;

	private BigDecimal cdileveldigits;

	private BigDecimal cdilevelincrementalvalue;

	private BigDecimal cdilevelinitialvalue;

	private String cdilevelname;

	private String cdilevelseparatortopreviousleve;

	private String cdilevelvalueatend;

	private String cdilevelvaluetype;

	private String cdilevelvariablename;

	//bi-directional many-to-one association to Ccdidefinition
	@ManyToOne
	@JoinColumn(name="cdicode")
	private Ccdidefinition ccdidefinition;

	public Ccdileveldefinition() {
	}

	public Integer getCdilevelid() {
		return this.cdilevelid;
	}

	public void setCdilevelid(Integer cdilevelid) {
		this.cdilevelid = cdilevelid;
	}

	public BigDecimal getCdileveldigits() {
		return this.cdileveldigits;
	}

	public void setCdileveldigits(BigDecimal cdileveldigits) {
		this.cdileveldigits = cdileveldigits;
	}

	public BigDecimal getCdilevelincrementalvalue() {
		return this.cdilevelincrementalvalue;
	}

	public void setCdilevelincrementalvalue(BigDecimal cdilevelincrementalvalue) {
		this.cdilevelincrementalvalue = cdilevelincrementalvalue;
	}

	public BigDecimal getCdilevelinitialvalue() {
		return this.cdilevelinitialvalue;
	}

	public void setCdilevelinitialvalue(BigDecimal cdilevelinitialvalue) {
		this.cdilevelinitialvalue = cdilevelinitialvalue;
	}

	public String getCdilevelname() {
		return this.cdilevelname;
	}

	public void setCdilevelname(String cdilevelname) {
		this.cdilevelname = cdilevelname;
	}

	public String getCdilevelseparatortopreviousleve() {
		return this.cdilevelseparatortopreviousleve;
	}

	public void setCdilevelseparatortopreviousleve(String cdilevelseparatortopreviousleve) {
		this.cdilevelseparatortopreviousleve = cdilevelseparatortopreviousleve;
	}

	public String getCdilevelvalueatend() {
		return this.cdilevelvalueatend;
	}

	public void setCdilevelvalueatend(String cdilevelvalueatend) {
		this.cdilevelvalueatend = cdilevelvalueatend;
	}

	public String getCdilevelvaluetype() {
		return this.cdilevelvaluetype;
	}

	public void setCdilevelvaluetype(String cdilevelvaluetype) {
		this.cdilevelvaluetype = cdilevelvaluetype;
	}

	public String getCdilevelvariablename() {
		return this.cdilevelvariablename;
	}

	public void setCdilevelvariablename(String cdilevelvariablename) {
		this.cdilevelvariablename = cdilevelvariablename;
	}

	public Ccdidefinition getCcdidefinition() {
		return this.ccdidefinition;
	}

	public void setCcdidefinition(Ccdidefinition ccdidefinition) {
		this.ccdidefinition = ccdidefinition;
	}

}