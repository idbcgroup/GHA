package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the infopack database table.
 * 
 */
@Entity
@NamedQuery(name="Infopack.findAll", query="SELECT i FROM Infopack i")
public class Infopack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String infopackcode;

	private String infopackdescription;

	private String infopackname;

	private String infopackstructure;

	public Infopack() {
	}

	public String getInfopackcode() {
		return this.infopackcode;
	}

	public void setInfopackcode(String infopackcode) {
		this.infopackcode = infopackcode;
	}

	public String getInfopackdescription() {
		return this.infopackdescription;
	}

	public void setInfopackdescription(String infopackdescription) {
		this.infopackdescription = infopackdescription;
	}

	public String getInfopackname() {
		return this.infopackname;
	}

	public void setInfopackname(String infopackname) {
		this.infopackname = infopackname;
	}

	public String getInfopackstructure() {
		return this.infopackstructure;
	}

	public void setInfopackstructure(String infopackstructure) {
		this.infopackstructure = infopackstructure;
	}

}