package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the accessbyfunction database table.
 * 
 */
@Entity
@NamedQuery(name="Accessbyfunction.findAll", query="SELECT a FROM Accessbyfunction a")
public class Accessbyfunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer accessbyfunctionid;

	private BigDecimal functionaccesslevel;

	private String functionoperationlevel;

	//bi-directional many-to-one association to Accessgroup
	@ManyToOne
	@JoinColumn(name="accessgroupcode")
	private Accessgroup accessgroup;

	//bi-directional many-to-one association to Functioninfunction
	@ManyToOne
	@JoinColumn(name="functioninfunctionid")
	private Functioninfunction functioninfunction1;

	//bi-directional many-to-one association to Functioninfunction
	@ManyToOne
	@JoinColumn(name="accessbyfunctioninfunctionid")
	private Functioninfunction functioninfunction2;

	public Accessbyfunction() {
	}

	public Integer getAccessbyfunctionid() {
		return this.accessbyfunctionid;
	}

	public void setAccessbyfunctionid(Integer accessbyfunctionid) {
		this.accessbyfunctionid = accessbyfunctionid;
	}

	public BigDecimal getFunctionaccesslevel() {
		return this.functionaccesslevel;
	}

	public void setFunctionaccesslevel(BigDecimal functionaccesslevel) {
		this.functionaccesslevel = functionaccesslevel;
	}

	public String getFunctionoperationlevel() {
		return this.functionoperationlevel;
	}

	public void setFunctionoperationlevel(String functionoperationlevel) {
		this.functionoperationlevel = functionoperationlevel;
	}

	public Accessgroup getAccessgroup() {
		return this.accessgroup;
	}

	public void setAccessgroup(Accessgroup accessgroup) {
		this.accessgroup = accessgroup;
	}

	public Functioninfunction getFunctioninfunction1() {
		return this.functioninfunction1;
	}

	public void setFunctioninfunction1(Functioninfunction functioninfunction1) {
		this.functioninfunction1 = functioninfunction1;
	}

	public Functioninfunction getFunctioninfunction2() {
		return this.functioninfunction2;
	}

	public void setFunctioninfunction2(Functioninfunction functioninfunction2) {
		this.functioninfunction2 = functioninfunction2;
	}

}