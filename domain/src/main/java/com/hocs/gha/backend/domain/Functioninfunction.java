package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the functioninfunction database table.
 * 
 */
@Entity
@NamedQuery(name="Functioninfunction.findAll", query="SELECT f FROM Functioninfunction f")
public class Functioninfunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer functioninfunctionid;

	//bi-directional many-to-one association to Accessbyfunction
	@OneToMany(mappedBy="functioninfunction1")
	private List<Accessbyfunction> accessbyfunctions1;

	//bi-directional many-to-one association to Accessbyfunction
	@OneToMany(mappedBy="functioninfunction2")
	private List<Accessbyfunction> accessbyfunctions2;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function1;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioninfunctioncode")
	private Function function2;

	public Functioninfunction() {
	}

	public Integer getFunctioninfunctionid() {
		return this.functioninfunctionid;
	}

	public void setFunctioninfunctionid(Integer functioninfunctionid) {
		this.functioninfunctionid = functioninfunctionid;
	}

	public List<Accessbyfunction> getAccessbyfunctions1() {
		return this.accessbyfunctions1;
	}

	public void setAccessbyfunctions1(List<Accessbyfunction> accessbyfunctions1) {
		this.accessbyfunctions1 = accessbyfunctions1;
	}

	public Accessbyfunction addAccessbyfunctions1(Accessbyfunction accessbyfunctions1) {
		getAccessbyfunctions1().add(accessbyfunctions1);
		accessbyfunctions1.setFunctioninfunction1(this);

		return accessbyfunctions1;
	}

	public Accessbyfunction removeAccessbyfunctions1(Accessbyfunction accessbyfunctions1) {
		getAccessbyfunctions1().remove(accessbyfunctions1);
		accessbyfunctions1.setFunctioninfunction1(null);

		return accessbyfunctions1;
	}

	public List<Accessbyfunction> getAccessbyfunctions2() {
		return this.accessbyfunctions2;
	}

	public void setAccessbyfunctions2(List<Accessbyfunction> accessbyfunctions2) {
		this.accessbyfunctions2 = accessbyfunctions2;
	}

	public Accessbyfunction addAccessbyfunctions2(Accessbyfunction accessbyfunctions2) {
		getAccessbyfunctions2().add(accessbyfunctions2);
		accessbyfunctions2.setFunctioninfunction2(this);

		return accessbyfunctions2;
	}

	public Accessbyfunction removeAccessbyfunctions2(Accessbyfunction accessbyfunctions2) {
		getAccessbyfunctions2().remove(accessbyfunctions2);
		accessbyfunctions2.setFunctioninfunction2(null);

		return accessbyfunctions2;
	}

	public Function getFunction1() {
		return this.function1;
	}

	public void setFunction1(Function function1) {
		this.function1 = function1;
	}

	public Function getFunction2() {
		return this.function2;
	}

	public void setFunction2(Function function2) {
		this.function2 = function2;
	}

}