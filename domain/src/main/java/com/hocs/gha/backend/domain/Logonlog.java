package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the logonlog database table.
 * 
 */
@Entity
@NamedQuery(name="Logonlog.findAll", query="SELECT l FROM Logonlog l")
public class Logonlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer logonlogid;

	private BigDecimal loginattempt;

	private Timestamp loginattempttimestamp;

	private String logonlogeventtype;

	private String logonterminalname;

	private String password;

	private Timestamp sessiontimestamp;

	private Timestamp timestamplastlogon;

	private BigDecimal useridchangingdata;

	private String username;

	private String usernamechangingdata;

	//bi-directional many-to-one association to Instancelogon
	@ManyToOne
	@JoinColumn(name="instancelogonid")
	private Instancelogon instancelogon;

	//bi-directional many-to-one association to Itsystem
	@ManyToOne
	@JoinColumn(name="itsystemcode")
	private Itsystem itsystem;

	//bi-directional many-to-one association to Singlesignonuser
	@ManyToOne
	@JoinColumn(name="singlesignonuserid")
	private Singlesignonuser singlesignonuser;

	//bi-directional many-to-one association to Systeminstance
	@ManyToOne
	@JoinColumn(name="systeminstanceid")
	private Systeminstance systeminstance;

	public Logonlog() {
	}

	public Integer getLogonlogid() {
		return this.logonlogid;
	}

	public void setLogonlogid(Integer logonlogid) {
		this.logonlogid = logonlogid;
	}

	public BigDecimal getLoginattempt() {
		return this.loginattempt;
	}

	public void setLoginattempt(BigDecimal loginattempt) {
		this.loginattempt = loginattempt;
	}

	public Timestamp getLoginattempttimestamp() {
		return this.loginattempttimestamp;
	}

	public void setLoginattempttimestamp(Timestamp loginattempttimestamp) {
		this.loginattempttimestamp = loginattempttimestamp;
	}

	public String getLogonlogeventtype() {
		return this.logonlogeventtype;
	}

	public void setLogonlogeventtype(String logonlogeventtype) {
		this.logonlogeventtype = logonlogeventtype;
	}

	public String getLogonterminalname() {
		return this.logonterminalname;
	}

	public void setLogonterminalname(String logonterminalname) {
		this.logonterminalname = logonterminalname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getSessiontimestamp() {
		return this.sessiontimestamp;
	}

	public void setSessiontimestamp(Timestamp sessiontimestamp) {
		this.sessiontimestamp = sessiontimestamp;
	}

	public Timestamp getTimestamplastlogon() {
		return this.timestamplastlogon;
	}

	public void setTimestamplastlogon(Timestamp timestamplastlogon) {
		this.timestamplastlogon = timestamplastlogon;
	}

	public BigDecimal getUseridchangingdata() {
		return this.useridchangingdata;
	}

	public void setUseridchangingdata(BigDecimal useridchangingdata) {
		this.useridchangingdata = useridchangingdata;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernamechangingdata() {
		return this.usernamechangingdata;
	}

	public void setUsernamechangingdata(String usernamechangingdata) {
		this.usernamechangingdata = usernamechangingdata;
	}

	public Instancelogon getInstancelogon() {
		return this.instancelogon;
	}

	public void setInstancelogon(Instancelogon instancelogon) {
		this.instancelogon = instancelogon;
	}

	public Itsystem getItsystem() {
		return this.itsystem;
	}

	public void setItsystem(Itsystem itsystem) {
		this.itsystem = itsystem;
	}

	public Singlesignonuser getSinglesignonuser() {
		return this.singlesignonuser;
	}

	public void setSinglesignonuser(Singlesignonuser singlesignonuser) {
		this.singlesignonuser = singlesignonuser;
	}

	public Systeminstance getSysteminstance() {
		return this.systeminstance;
	}

	public void setSysteminstance(Systeminstance systeminstance) {
		this.systeminstance = systeminstance;
	}

}