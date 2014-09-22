package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the parametdefinition database table.
 * 
 */
@Entity
@NamedQuery(name="Parametdefinition.findAll", query="SELECT p FROM Parametdefinition p")
public class Parametdefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer parametdefinitionid;

	private String parameterdefaultvalue;

	private String parameterdefinitionhelp;

	private String parameterdescription;

	private String parametername;

	private BigDecimal parametervaluelength;

	private String parametervaluetype;

	//bi-directional many-to-one association to Parametbyfunction
	@OneToMany(mappedBy="parametdefinition")
	private List<Parametbyfunction> parametbyfunctions;

	//bi-directional many-to-one association to Parametgroup
	@ManyToOne
	@JoinColumn(name="parametgroupcode")
	private Parametgroup parametgroup;

	//bi-directional many-to-one association to Parametvalue
	@OneToMany(mappedBy="parametdefinition")
	private List<Parametvalue> parametvalues;

	public Parametdefinition() {
	}

	public Integer getParametdefinitionid() {
		return this.parametdefinitionid;
	}

	public void setParametdefinitionid(Integer parametdefinitionid) {
		this.parametdefinitionid = parametdefinitionid;
	}

	public String getParameterdefaultvalue() {
		return this.parameterdefaultvalue;
	}

	public void setParameterdefaultvalue(String parameterdefaultvalue) {
		this.parameterdefaultvalue = parameterdefaultvalue;
	}

	public String getParameterdefinitionhelp() {
		return this.parameterdefinitionhelp;
	}

	public void setParameterdefinitionhelp(String parameterdefinitionhelp) {
		this.parameterdefinitionhelp = parameterdefinitionhelp;
	}

	public String getParameterdescription() {
		return this.parameterdescription;
	}

	public void setParameterdescription(String parameterdescription) {
		this.parameterdescription = parameterdescription;
	}

	public String getParametername() {
		return this.parametername;
	}

	public void setParametername(String parametername) {
		this.parametername = parametername;
	}

	public BigDecimal getParametervaluelength() {
		return this.parametervaluelength;
	}

	public void setParametervaluelength(BigDecimal parametervaluelength) {
		this.parametervaluelength = parametervaluelength;
	}

	public String getParametervaluetype() {
		return this.parametervaluetype;
	}

	public void setParametervaluetype(String parametervaluetype) {
		this.parametervaluetype = parametervaluetype;
	}

	public List<Parametbyfunction> getParametbyfunctions() {
		return this.parametbyfunctions;
	}

	public void setParametbyfunctions(List<Parametbyfunction> parametbyfunctions) {
		this.parametbyfunctions = parametbyfunctions;
	}

	public Parametbyfunction addParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().add(parametbyfunction);
		parametbyfunction.setParametdefinition(this);

		return parametbyfunction;
	}

	public Parametbyfunction removeParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().remove(parametbyfunction);
		parametbyfunction.setParametdefinition(null);

		return parametbyfunction;
	}

	public Parametgroup getParametgroup() {
		return this.parametgroup;
	}

	public void setParametgroup(Parametgroup parametgroup) {
		this.parametgroup = parametgroup;
	}

	public List<Parametvalue> getParametvalues() {
		return this.parametvalues;
	}

	public void setParametvalues(List<Parametvalue> parametvalues) {
		this.parametvalues = parametvalues;
	}

	public Parametvalue addParametvalue(Parametvalue parametvalue) {
		getParametvalues().add(parametvalue);
		parametvalue.setParametdefinition(this);

		return parametvalue;
	}

	public Parametvalue removeParametvalue(Parametvalue parametvalue) {
		getParametvalues().remove(parametvalue);
		parametvalue.setParametdefinition(null);

		return parametvalue;
	}

}