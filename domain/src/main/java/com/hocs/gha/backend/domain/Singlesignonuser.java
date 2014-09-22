package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the singlesignonuser database table.
 * 
 */
@Entity
@NamedQuery(name="Singlesignonuser.findAll", query="SELECT s FROM Singlesignonuser s")
public class Singlesignonuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer singlesignonuserid;

	private String blocked;

	private String bpidefault;

	private Timestamp lastlogondate;

	private String lastlogonterminalname;

	private BigDecimal loginattempt;

	private Timestamp loginattempttimestamp;

	private String logonterminalname;

	private String password;

	private Timestamp sessiontimestamp;

	private BigDecimal ssouseraccesslevel;

	private String ssouserlevel;

	private String ssouseroperationlevel;

	private String userlogonstatus;

	private String username;

	private Boolean usernameissso;

	//bi-directional many-to-one association to Instancelogon
	@OneToMany(mappedBy="singlesignonuser")
	private List<Instancelogon> instancelogons;

	//bi-directional many-to-one association to Logonlog
	@OneToMany(mappedBy="singlesignonuser")
	private List<Logonlog> logonlogs;

	//bi-directional many-to-one association to Bpa
	@ManyToOne
	@JoinColumn(name="bpacode")
	private Bpa bpa;

	public Singlesignonuser() {
	}

	public Integer getSinglesignonuserid() {
		return this.singlesignonuserid;
	}

	public void setSinglesignonuserid(Integer singlesignonuserid) {
		this.singlesignonuserid = singlesignonuserid;
	}

	public String getBlocked() {
		return this.blocked;
	}

	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}

	public String getBpidefault() {
		return this.bpidefault;
	}

	public void setBpidefault(String bpidefault) {
		this.bpidefault = bpidefault;
	}

	public Timestamp getLastlogondate() {
		return this.lastlogondate;
	}

	public void setLastlogondate(Timestamp lastlogondate) {
		this.lastlogondate = lastlogondate;
	}

	public String getLastlogonterminalname() {
		return this.lastlogonterminalname;
	}

	public void setLastlogonterminalname(String lastlogonterminalname) {
		this.lastlogonterminalname = lastlogonterminalname;
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

	public BigDecimal getSsouseraccesslevel() {
		return this.ssouseraccesslevel;
	}

	public void setSsouseraccesslevel(BigDecimal ssouseraccesslevel) {
		this.ssouseraccesslevel = ssouseraccesslevel;
	}

	public String getSsouserlevel() {
		return this.ssouserlevel;
	}

	public void setSsouserlevel(String ssouserlevel) {
		this.ssouserlevel = ssouserlevel;
	}

	public String getSsouseroperationlevel() {
		return this.ssouseroperationlevel;
	}

	public void setSsouseroperationlevel(String ssouseroperationlevel) {
		this.ssouseroperationlevel = ssouseroperationlevel;
	}

	public String getUserlogonstatus() {
		return this.userlogonstatus;
	}

	public void setUserlogonstatus(String userlogonstatus) {
		this.userlogonstatus = userlogonstatus;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getUsernameissso() {
		return this.usernameissso;
	}

	public void setUsernameissso(Boolean usernameissso) {
		this.usernameissso = usernameissso;
	}

	public List<Instancelogon> getInstancelogons() {
		return this.instancelogons;
	}

	public void setInstancelogons(List<Instancelogon> instancelogons) {
		this.instancelogons = instancelogons;
	}

	public Instancelogon addInstancelogon(Instancelogon instancelogon) {
		getInstancelogons().add(instancelogon);
		instancelogon.setSinglesignonuser(this);

		return instancelogon;
	}

	public Instancelogon removeInstancelogon(Instancelogon instancelogon) {
		getInstancelogons().remove(instancelogon);
		instancelogon.setSinglesignonuser(null);

		return instancelogon;
	}

	public List<Logonlog> getLogonlogs() {
		return this.logonlogs;
	}

	public void setLogonlogs(List<Logonlog> logonlogs) {
		this.logonlogs = logonlogs;
	}

	public Logonlog addLogonlog(Logonlog logonlog) {
		getLogonlogs().add(logonlog);
		logonlog.setSinglesignonuser(this);

		return logonlog;
	}

	public Logonlog removeLogonlog(Logonlog logonlog) {
		getLogonlogs().remove(logonlog);
		logonlog.setSinglesignonuser(null);

		return logonlog;
	}

	public Bpa getBpa() {
		return this.bpa;
	}

	public void setBpa(Bpa bpa) {
		this.bpa = bpa;
	}

}