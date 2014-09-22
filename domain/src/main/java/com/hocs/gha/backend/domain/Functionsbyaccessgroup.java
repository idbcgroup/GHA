package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the functionsbyaccessgroup database table.
 * 
 */
@Entity
@NamedQuery(name="Functionsbyaccessgroup.findAll", query="SELECT f FROM Functionsbyaccessgroup f")
public class Functionsbyaccessgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer functionsbyaccessgroupid;

	private BigDecimal functionaccesslevel;

	private String functionoperationlevel;

	private String functionsbyaccessgroupstatus;

	//bi-directional many-to-one association to Accessgroup
	@ManyToOne
	@JoinColumn(name="accessgroupcode")
	private Accessgroup accessgroup;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function;

	public Functionsbyaccessgroup() {
	}

	public Integer getFunctionsbyaccessgroupid() {
		return this.functionsbyaccessgroupid;
	}

	public void setFunctionsbyaccessgroupid(Integer functionsbyaccessgroupid) {
		this.functionsbyaccessgroupid = functionsbyaccessgroupid;
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

	public String getFunctionsbyaccessgroupstatus() {
		return this.functionsbyaccessgroupstatus;
	}

	public void setFunctionsbyaccessgroupstatus(String functionsbyaccessgroupstatus) {
		this.functionsbyaccessgroupstatus = functionsbyaccessgroupstatus;
	}

	public Accessgroup getAccessgroup() {
		return this.accessgroup;
	}

	public void setAccessgroup(Accessgroup accessgroup) {
		this.accessgroup = accessgroup;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}