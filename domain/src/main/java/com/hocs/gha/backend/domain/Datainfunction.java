package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the datainfunction database table.
 * 
 */
@Entity
@NamedQuery(name="Datainfunction.findAll", query="SELECT d FROM Datainfunction d")
public class Datainfunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer datainfunctionid;

	private String datausedin;

	//bi-directional many-to-one association to Datadictionary
	@ManyToOne
	@JoinColumn(name="datadictionarycode")
	private Datadictionary datadictionary;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function;

	public Datainfunction() {
	}

	public Integer getDatainfunctionid() {
		return this.datainfunctionid;
	}

	public void setDatainfunctionid(Integer datainfunctionid) {
		this.datainfunctionid = datainfunctionid;
	}

	public String getDatausedin() {
		return this.datausedin;
	}

	public void setDatausedin(String datausedin) {
		this.datausedin = datausedin;
	}

	public Datadictionary getDatadictionary() {
		return this.datadictionary;
	}

	public void setDatadictionary(Datadictionary datadictionary) {
		this.datadictionary = datadictionary;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}