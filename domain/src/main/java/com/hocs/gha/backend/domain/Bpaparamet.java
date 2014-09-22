package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bpaparamet database table.
 * 
 */
@Entity
@NamedQuery(name="Bpaparamet.findAll", query="SELECT b FROM Bpaparamet b")
public class Bpaparamet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer bpaparametid;

	private String bpaparametstatus;

	private String orderparametcode;

	@Temporal(TemporalType.DATE)
	private Date parametcodebegindate;

	@Temporal(TemporalType.DATE)
	private Date parametcodeenddate;

	//bi-directional many-to-one association to Bpa
	@ManyToOne
	@JoinColumn(name="bpacode")
	private Bpa bpa;

	//bi-directional many-to-one association to Parametvaluescode
	@ManyToOne
	@JoinColumn(name="parametcodeid")
	private Parametvaluescode parametvaluescode;

	public Bpaparamet() {
	}

	public Integer getBpaparametid() {
		return this.bpaparametid;
	}

	public void setBpaparametid(Integer bpaparametid) {
		this.bpaparametid = bpaparametid;
	}

	public String getBpaparametstatus() {
		return this.bpaparametstatus;
	}

	public void setBpaparametstatus(String bpaparametstatus) {
		this.bpaparametstatus = bpaparametstatus;
	}

	public String getOrderparametcode() {
		return this.orderparametcode;
	}

	public void setOrderparametcode(String orderparametcode) {
		this.orderparametcode = orderparametcode;
	}

	public Date getParametcodebegindate() {
		return this.parametcodebegindate;
	}

	public void setParametcodebegindate(Date parametcodebegindate) {
		this.parametcodebegindate = parametcodebegindate;
	}

	public Date getParametcodeenddate() {
		return this.parametcodeenddate;
	}

	public void setParametcodeenddate(Date parametcodeenddate) {
		this.parametcodeenddate = parametcodeenddate;
	}

	public Bpa getBpa() {
		return this.bpa;
	}

	public void setBpa(Bpa bpa) {
		this.bpa = bpa;
	}

	public Parametvaluescode getParametvaluescode() {
		return this.parametvaluescode;
	}

	public void setParametvaluescode(Parametvaluescode parametvaluescode) {
		this.parametvaluescode = parametvaluescode;
	}

}