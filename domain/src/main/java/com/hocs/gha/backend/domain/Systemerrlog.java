package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the systemerrlog database table.
 * 
 */
@Entity
@NamedQuery(name="Systemerrlog.findAll", query="SELECT s FROM Systemerrlog s")
public class Systemerrlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer systemerrorlogid;

	private String errordata;

	private String systemerrorlogeventtype;

	private Timestamp systemerrorlogtimestamp;

	private String terminalname;

	private String username;

	//bi-directional many-to-one association to Bpu
	@ManyToOne
	@JoinColumn(name="bpucode")
	private Bpu bpu;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function;

	//bi-directional many-to-one association to Pmemessage
	@ManyToOne
	@JoinColumn(name="pmemessagecode")
	private Pmemessage pmemessage;

	public Systemerrlog() {
	}

	public Integer getSystemerrorlogid() {
		return this.systemerrorlogid;
	}

	public void setSystemerrorlogid(Integer systemerrorlogid) {
		this.systemerrorlogid = systemerrorlogid;
	}

	public String getErrordata() {
		return this.errordata;
	}

	public void setErrordata(String errordata) {
		this.errordata = errordata;
	}

	public String getSystemerrorlogeventtype() {
		return this.systemerrorlogeventtype;
	}

	public void setSystemerrorlogeventtype(String systemerrorlogeventtype) {
		this.systemerrorlogeventtype = systemerrorlogeventtype;
	}

	public Timestamp getSystemerrorlogtimestamp() {
		return this.systemerrorlogtimestamp;
	}

	public void setSystemerrorlogtimestamp(Timestamp systemerrorlogtimestamp) {
		this.systemerrorlogtimestamp = systemerrorlogtimestamp;
	}

	public String getTerminalname() {
		return this.terminalname;
	}

	public void setTerminalname(String terminalname) {
		this.terminalname = terminalname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Bpu getBpu() {
		return this.bpu;
	}

	public void setBpu(Bpu bpu) {
		this.bpu = bpu;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Pmemessage getPmemessage() {
		return this.pmemessage;
	}

	public void setPmemessage(Pmemessage pmemessage) {
		this.pmemessage = pmemessage;
	}

}