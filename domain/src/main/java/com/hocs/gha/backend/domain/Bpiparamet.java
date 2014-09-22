package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the bpiparamet database table.
 * 
 */
@Entity
@NamedQuery(name="Bpiparamet.findAll", query="SELECT b FROM Bpiparamet b")
public class Bpiparamet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer bpiparametid;

	private String bpiparametstatus;

	private BigDecimal orderparametcode;

	@Temporal(TemporalType.DATE)
	private Date parametcodebegindate;

	@Temporal(TemporalType.DATE)
	private Date parametcodeenddate;

	//bi-directional many-to-one association to Bpi
	@ManyToOne
	@JoinColumn(name="bpicode")
	private Bpi bpi;

	//bi-directional many-to-one association to Parametvaluescode
	@ManyToOne
	@JoinColumn(name="parametcodeid")
	private Parametvaluescode parametvaluescode;

	public Bpiparamet() {
	}

	public Integer getBpiparametid() {
		return this.bpiparametid;
	}

	public void setBpiparametid(Integer bpiparametid) {
		this.bpiparametid = bpiparametid;
	}

	public String getBpiparametstatus() {
		return this.bpiparametstatus;
	}

	public void setBpiparametstatus(String bpiparametstatus) {
		this.bpiparametstatus = bpiparametstatus;
	}

	public BigDecimal getOrderparametcode() {
		return this.orderparametcode;
	}

	public void setOrderparametcode(BigDecimal orderparametcode) {
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

	public Bpi getBpi() {
		return this.bpi;
	}

	public void setBpi(Bpi bpi) {
		this.bpi = bpi;
	}

	public Parametvaluescode getParametvaluescode() {
		return this.parametvaluescode;
	}

	public void setParametvaluescode(Parametvaluescode parametvaluescode) {
		this.parametvaluescode = parametvaluescode;
	}

}