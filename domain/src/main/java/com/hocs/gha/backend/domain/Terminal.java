package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the terminal database table.
 * 
 */
@Entity
@NamedQuery(name="Terminal.findAll", query="SELECT t FROM Terminal t")
public class Terminal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String terminalname;

	private String codbarprinterbrand;

	private Boolean codbarprinterconnected;

	private Boolean codbarreaderconnected;

	private String codbarreaderconnection;

	private String codbarreaderprefix;

	private String codbarreadersuffix;

	private String eiacode;

	private String ipaddress;

	private String locationtypecode;

	private String macaddress;

	private Boolean peripheralconnected;

	private Boolean restrictapplication;

	private String restrictapplicationgroup;

	//bi-directional many-to-one association to Workingarea
	@ManyToOne
	@JoinColumn(name="workingareacode")
	private Workingarea workingarea;

	public Terminal() {
	}

	public String getTerminalname() {
		return this.terminalname;
	}

	public void setTerminalname(String terminalname) {
		this.terminalname = terminalname;
	}

	public String getCodbarprinterbrand() {
		return this.codbarprinterbrand;
	}

	public void setCodbarprinterbrand(String codbarprinterbrand) {
		this.codbarprinterbrand = codbarprinterbrand;
	}

	public Boolean getCodbarprinterconnected() {
		return this.codbarprinterconnected;
	}

	public void setCodbarprinterconnected(Boolean codbarprinterconnected) {
		this.codbarprinterconnected = codbarprinterconnected;
	}

	public Boolean getCodbarreaderconnected() {
		return this.codbarreaderconnected;
	}

	public void setCodbarreaderconnected(Boolean codbarreaderconnected) {
		this.codbarreaderconnected = codbarreaderconnected;
	}

	public String getCodbarreaderconnection() {
		return this.codbarreaderconnection;
	}

	public void setCodbarreaderconnection(String codbarreaderconnection) {
		this.codbarreaderconnection = codbarreaderconnection;
	}

	public String getCodbarreaderprefix() {
		return this.codbarreaderprefix;
	}

	public void setCodbarreaderprefix(String codbarreaderprefix) {
		this.codbarreaderprefix = codbarreaderprefix;
	}

	public String getCodbarreadersuffix() {
		return this.codbarreadersuffix;
	}

	public void setCodbarreadersuffix(String codbarreadersuffix) {
		this.codbarreadersuffix = codbarreadersuffix;
	}

	public String getEiacode() {
		return this.eiacode;
	}

	public void setEiacode(String eiacode) {
		this.eiacode = eiacode;
	}

	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getLocationtypecode() {
		return this.locationtypecode;
	}

	public void setLocationtypecode(String locationtypecode) {
		this.locationtypecode = locationtypecode;
	}

	public String getMacaddress() {
		return this.macaddress;
	}

	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}

	public Boolean getPeripheralconnected() {
		return this.peripheralconnected;
	}

	public void setPeripheralconnected(Boolean peripheralconnected) {
		this.peripheralconnected = peripheralconnected;
	}

	public Boolean getRestrictapplication() {
		return this.restrictapplication;
	}

	public void setRestrictapplication(Boolean restrictapplication) {
		this.restrictapplication = restrictapplication;
	}

	public String getRestrictapplicationgroup() {
		return this.restrictapplicationgroup;
	}

	public void setRestrictapplicationgroup(String restrictapplicationgroup) {
		this.restrictapplicationgroup = restrictapplicationgroup;
	}

	public Workingarea getWorkingarea() {
		return this.workingarea;
	}

	public void setWorkingarea(Workingarea workingarea) {
		this.workingarea = workingarea;
	}

}