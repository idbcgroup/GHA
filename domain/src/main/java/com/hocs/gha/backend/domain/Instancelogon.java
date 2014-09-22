package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the instancelogon database table.
 * 
 */
@Entity
@NamedQuery(name="Instancelogon.findAll", query="SELECT i FROM Instancelogon i")
public class Instancelogon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer instancelogonid;

	private Boolean bpidefault;

	private BigDecimal useraccesslevel;

	private String userlevel;

	private String useroperationlevel;

	//bi-directional many-to-one association to Singlesignonuser
	@ManyToOne
	@JoinColumn(name="singlesignonuserid")
	private Singlesignonuser singlesignonuser;

	//bi-directional many-to-one association to Systeminstance
	@ManyToOne
	@JoinColumn(name="systeminstanceid")
	private Systeminstance systeminstance;

	//bi-directional many-to-one association to Logonlog
	@OneToMany(mappedBy="instancelogon")
	private List<Logonlog> logonlogs;

	public Instancelogon() {
	}

	public Integer getInstancelogonid() {
		return this.instancelogonid;
	}

	public void setInstancelogonid(Integer instancelogonid) {
		this.instancelogonid = instancelogonid;
	}

	public Boolean getBpidefault() {
		return this.bpidefault;
	}

	public void setBpidefault(Boolean bpidefault) {
		this.bpidefault = bpidefault;
	}

	public BigDecimal getUseraccesslevel() {
		return this.useraccesslevel;
	}

	public void setUseraccesslevel(BigDecimal useraccesslevel) {
		this.useraccesslevel = useraccesslevel;
	}

	public String getUserlevel() {
		return this.userlevel;
	}

	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}

	public String getUseroperationlevel() {
		return this.useroperationlevel;
	}

	public void setUseroperationlevel(String useroperationlevel) {
		this.useroperationlevel = useroperationlevel;
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

	public List<Logonlog> getLogonlogs() {
		return this.logonlogs;
	}

	public void setLogonlogs(List<Logonlog> logonlogs) {
		this.logonlogs = logonlogs;
	}

	public Logonlog addLogonlog(Logonlog logonlog) {
		getLogonlogs().add(logonlog);
		logonlog.setInstancelogon(this);

		return logonlog;
	}

	public Logonlog removeLogonlog(Logonlog logonlog) {
		getLogonlogs().remove(logonlog);
		logonlog.setInstancelogon(null);

		return logonlog;
	}

}