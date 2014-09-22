package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itsysteminterface database table.
 * 
 */
@Entity
@NamedQuery(name="Itsysteminterface.findAll", query="SELECT i FROM Itsysteminterface i")
public class Itsysteminterface implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer itsysteminterfacesid;

	private String interfacename;

	private String interfacestatus;

	//bi-directional many-to-one association to Itsystem
	@ManyToOne
	@JoinColumn(name="itsystemcode")
	private Itsystem itsystem1;

	//bi-directional many-to-one association to Itsystem
	@ManyToOne
	@JoinColumn(name="externalitsystemcode")
	private Itsystem itsystem2;

	public Itsysteminterface() {
	}

	public Integer getItsysteminterfacesid() {
		return this.itsysteminterfacesid;
	}

	public void setItsysteminterfacesid(Integer itsysteminterfacesid) {
		this.itsysteminterfacesid = itsysteminterfacesid;
	}

	public String getInterfacename() {
		return this.interfacename;
	}

	public void setInterfacename(String interfacename) {
		this.interfacename = interfacename;
	}

	public String getInterfacestatus() {
		return this.interfacestatus;
	}

	public void setInterfacestatus(String interfacestatus) {
		this.interfacestatus = interfacestatus;
	}

	public Itsystem getItsystem1() {
		return this.itsystem1;
	}

	public void setItsystem1(Itsystem itsystem1) {
		this.itsystem1 = itsystem1;
	}

	public Itsystem getItsystem2() {
		return this.itsystem2;
	}

	public void setItsystem2(Itsystem itsystem2) {
		this.itsystem2 = itsystem2;
	}

}