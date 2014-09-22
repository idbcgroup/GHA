package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tad database table.
 * 
 */
@Entity
@NamedQuery(name="Tad.findAll", query="SELECT t FROM Tad t")
public class Tad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tadcode;

	private String taddescription;

	private String tadkeys;

	private String tadname;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function;

	public Tad() {
	}

	public String getTadcode() {
		return this.tadcode;
	}

	public void setTadcode(String tadcode) {
		this.tadcode = tadcode;
	}

	public String getTaddescription() {
		return this.taddescription;
	}

	public void setTaddescription(String taddescription) {
		this.taddescription = taddescription;
	}

	public String getTadkeys() {
		return this.tadkeys;
	}

	public void setTadkeys(String tadkeys) {
		this.tadkeys = tadkeys;
	}

	public String getTadname() {
		return this.tadname;
	}

	public void setTadname(String tadname) {
		this.tadname = tadname;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}