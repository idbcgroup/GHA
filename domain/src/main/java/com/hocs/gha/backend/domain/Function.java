package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the function database table.
 * 
 */
@Entity
@NamedQuery(name="Function.findAll", query="SELECT f FROM Function f")
public class Function implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String functioncode;

	private String devlastversion;

	private BigDecimal functionaccesslevel;

	private String functioncontext;

	private String functiondescription;

	private String functionelectsignature;

	private Boolean functionhasvaloration;

	private BigDecimal functionmandatoryfields;

	private String functionname;

	private String functionstatus;

	private BigDecimal functionvaloration;

	private String prodlastversion;

	private String qalastversion;

	//bi-directional many-to-one association to Catalogbyfunction
	@OneToMany(mappedBy="function")
	private List<Catalogbyfunction> catalogbyfunctions;

	//bi-directional many-to-one association to Datainfunction
	@OneToMany(mappedBy="function")
	private List<Datainfunction> datainfunctions;

	//bi-directional many-to-one association to Functionalarea
	@ManyToOne
	@JoinColumn(name="functionalareacode")
	private Functionalarea functionalarea;

	//bi-directional many-to-one association to Functiontype
	@ManyToOne
	@JoinColumn(name="functiontypecode")
	private Functiontype functiontype;

	//bi-directional many-to-one association to Functionbymodule
	@OneToMany(mappedBy="function")
	private List<Functionbymodule> functionbymodules;

	//bi-directional many-to-one association to Functioninfunction
	@OneToMany(mappedBy="function1")
	private List<Functioninfunction> functioninfunctions1;

	//bi-directional many-to-one association to Functioninfunction
	@OneToMany(mappedBy="function2")
	private List<Functioninfunction> functioninfunctions2;

	//bi-directional many-to-one association to Functionmetadata
	@OneToMany(mappedBy="function")
	private List<Functionmetadata> functionmetadata;

	//bi-directional many-to-one association to Functionsbyaccessgroup
	@OneToMany(mappedBy="function")
	private List<Functionsbyaccessgroup> functionsbyaccessgroups;

	//bi-directional many-to-one association to Parametbyfunction
	@OneToMany(mappedBy="function")
	private List<Parametbyfunction> parametbyfunctions;

	//bi-directional many-to-one association to Pmemessage
	@OneToMany(mappedBy="function")
	private List<Pmemessage> pmemessages;

	//bi-directional many-to-one association to Systemerrlog
	@OneToMany(mappedBy="function")
	private List<Systemerrlog> systemerrlogs;

	//bi-directional many-to-one association to Tad
	@OneToMany(mappedBy="function")
	private List<Tad> tads;

	public Function() {
	}

	public String getFunctioncode() {
		return this.functioncode;
	}

	public void setFunctioncode(String functioncode) {
		this.functioncode = functioncode;
	}

	public String getDevlastversion() {
		return this.devlastversion;
	}

	public void setDevlastversion(String devlastversion) {
		this.devlastversion = devlastversion;
	}

	public BigDecimal getFunctionaccesslevel() {
		return this.functionaccesslevel;
	}

	public void setFunctionaccesslevel(BigDecimal functionaccesslevel) {
		this.functionaccesslevel = functionaccesslevel;
	}

	public String getFunctioncontext() {
		return this.functioncontext;
	}

	public void setFunctioncontext(String functioncontext) {
		this.functioncontext = functioncontext;
	}

	public String getFunctiondescription() {
		return this.functiondescription;
	}

	public void setFunctiondescription(String functiondescription) {
		this.functiondescription = functiondescription;
	}

	public String getFunctionelectsignature() {
		return this.functionelectsignature;
	}

	public void setFunctionelectsignature(String functionelectsignature) {
		this.functionelectsignature = functionelectsignature;
	}

	public Boolean getFunctionhasvaloration() {
		return this.functionhasvaloration;
	}

	public void setFunctionhasvaloration(Boolean functionhasvaloration) {
		this.functionhasvaloration = functionhasvaloration;
	}

	public BigDecimal getFunctionmandatoryfields() {
		return this.functionmandatoryfields;
	}

	public void setFunctionmandatoryfields(BigDecimal functionmandatoryfields) {
		this.functionmandatoryfields = functionmandatoryfields;
	}

	public String getFunctionname() {
		return this.functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public String getFunctionstatus() {
		return this.functionstatus;
	}

	public void setFunctionstatus(String functionstatus) {
		this.functionstatus = functionstatus;
	}

	public BigDecimal getFunctionvaloration() {
		return this.functionvaloration;
	}

	public void setFunctionvaloration(BigDecimal functionvaloration) {
		this.functionvaloration = functionvaloration;
	}

	public String getProdlastversion() {
		return this.prodlastversion;
	}

	public void setProdlastversion(String prodlastversion) {
		this.prodlastversion = prodlastversion;
	}

	public String getQalastversion() {
		return this.qalastversion;
	}

	public void setQalastversion(String qalastversion) {
		this.qalastversion = qalastversion;
	}

	public List<Catalogbyfunction> getCatalogbyfunctions() {
		return this.catalogbyfunctions;
	}

	public void setCatalogbyfunctions(List<Catalogbyfunction> catalogbyfunctions) {
		this.catalogbyfunctions = catalogbyfunctions;
	}

	public Catalogbyfunction addCatalogbyfunction(Catalogbyfunction catalogbyfunction) {
		getCatalogbyfunctions().add(catalogbyfunction);
		catalogbyfunction.setFunction(this);

		return catalogbyfunction;
	}

	public Catalogbyfunction removeCatalogbyfunction(Catalogbyfunction catalogbyfunction) {
		getCatalogbyfunctions().remove(catalogbyfunction);
		catalogbyfunction.setFunction(null);

		return catalogbyfunction;
	}

	public List<Datainfunction> getDatainfunctions() {
		return this.datainfunctions;
	}

	public void setDatainfunctions(List<Datainfunction> datainfunctions) {
		this.datainfunctions = datainfunctions;
	}

	public Datainfunction addDatainfunction(Datainfunction datainfunction) {
		getDatainfunctions().add(datainfunction);
		datainfunction.setFunction(this);

		return datainfunction;
	}

	public Datainfunction removeDatainfunction(Datainfunction datainfunction) {
		getDatainfunctions().remove(datainfunction);
		datainfunction.setFunction(null);

		return datainfunction;
	}

	public Functionalarea getFunctionalarea() {
		return this.functionalarea;
	}

	public void setFunctionalarea(Functionalarea functionalarea) {
		this.functionalarea = functionalarea;
	}

	public Functiontype getFunctiontype() {
		return this.functiontype;
	}

	public void setFunctiontype(Functiontype functiontype) {
		this.functiontype = functiontype;
	}

	public List<Functionbymodule> getFunctionbymodules() {
		return this.functionbymodules;
	}

	public void setFunctionbymodules(List<Functionbymodule> functionbymodules) {
		this.functionbymodules = functionbymodules;
	}

	public Functionbymodule addFunctionbymodule(Functionbymodule functionbymodule) {
		getFunctionbymodules().add(functionbymodule);
		functionbymodule.setFunction(this);

		return functionbymodule;
	}

	public Functionbymodule removeFunctionbymodule(Functionbymodule functionbymodule) {
		getFunctionbymodules().remove(functionbymodule);
		functionbymodule.setFunction(null);

		return functionbymodule;
	}

	public List<Functioninfunction> getFunctioninfunctions1() {
		return this.functioninfunctions1;
	}

	public void setFunctioninfunctions1(List<Functioninfunction> functioninfunctions1) {
		this.functioninfunctions1 = functioninfunctions1;
	}

	public Functioninfunction addFunctioninfunctions1(Functioninfunction functioninfunctions1) {
		getFunctioninfunctions1().add(functioninfunctions1);
		functioninfunctions1.setFunction1(this);

		return functioninfunctions1;
	}

	public Functioninfunction removeFunctioninfunctions1(Functioninfunction functioninfunctions1) {
		getFunctioninfunctions1().remove(functioninfunctions1);
		functioninfunctions1.setFunction1(null);

		return functioninfunctions1;
	}

	public List<Functioninfunction> getFunctioninfunctions2() {
		return this.functioninfunctions2;
	}

	public void setFunctioninfunctions2(List<Functioninfunction> functioninfunctions2) {
		this.functioninfunctions2 = functioninfunctions2;
	}

	public Functioninfunction addFunctioninfunctions2(Functioninfunction functioninfunctions2) {
		getFunctioninfunctions2().add(functioninfunctions2);
		functioninfunctions2.setFunction2(this);

		return functioninfunctions2;
	}

	public Functioninfunction removeFunctioninfunctions2(Functioninfunction functioninfunctions2) {
		getFunctioninfunctions2().remove(functioninfunctions2);
		functioninfunctions2.setFunction2(null);

		return functioninfunctions2;
	}

	public List<Functionmetadata> getFunctionmetadata() {
		return this.functionmetadata;
	}

	public void setFunctionmetadata(List<Functionmetadata> functionmetadata) {
		this.functionmetadata = functionmetadata;
	}

	public Functionmetadata addFunctionmetadata(Functionmetadata functionmetadata) {
		getFunctionmetadata().add(functionmetadata);
		functionmetadata.setFunction(this);

		return functionmetadata;
	}

	public Functionmetadata removeFunctionmetadata(Functionmetadata functionmetadata) {
		getFunctionmetadata().remove(functionmetadata);
		functionmetadata.setFunction(null);

		return functionmetadata;
	}

	public List<Functionsbyaccessgroup> getFunctionsbyaccessgroups() {
		return this.functionsbyaccessgroups;
	}

	public void setFunctionsbyaccessgroups(List<Functionsbyaccessgroup> functionsbyaccessgroups) {
		this.functionsbyaccessgroups = functionsbyaccessgroups;
	}

	public Functionsbyaccessgroup addFunctionsbyaccessgroup(Functionsbyaccessgroup functionsbyaccessgroup) {
		getFunctionsbyaccessgroups().add(functionsbyaccessgroup);
		functionsbyaccessgroup.setFunction(this);

		return functionsbyaccessgroup;
	}

	public Functionsbyaccessgroup removeFunctionsbyaccessgroup(Functionsbyaccessgroup functionsbyaccessgroup) {
		getFunctionsbyaccessgroups().remove(functionsbyaccessgroup);
		functionsbyaccessgroup.setFunction(null);

		return functionsbyaccessgroup;
	}

	public List<Parametbyfunction> getParametbyfunctions() {
		return this.parametbyfunctions;
	}

	public void setParametbyfunctions(List<Parametbyfunction> parametbyfunctions) {
		this.parametbyfunctions = parametbyfunctions;
	}

	public Parametbyfunction addParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().add(parametbyfunction);
		parametbyfunction.setFunction(this);

		return parametbyfunction;
	}

	public Parametbyfunction removeParametbyfunction(Parametbyfunction parametbyfunction) {
		getParametbyfunctions().remove(parametbyfunction);
		parametbyfunction.setFunction(null);

		return parametbyfunction;
	}

	public List<Pmemessage> getPmemessages() {
		return this.pmemessages;
	}

	public void setPmemessages(List<Pmemessage> pmemessages) {
		this.pmemessages = pmemessages;
	}

	public Pmemessage addPmemessage(Pmemessage pmemessage) {
		getPmemessages().add(pmemessage);
		pmemessage.setFunction(this);

		return pmemessage;
	}

	public Pmemessage removePmemessage(Pmemessage pmemessage) {
		getPmemessages().remove(pmemessage);
		pmemessage.setFunction(null);

		return pmemessage;
	}

	public List<Systemerrlog> getSystemerrlogs() {
		return this.systemerrlogs;
	}

	public void setSystemerrlogs(List<Systemerrlog> systemerrlogs) {
		this.systemerrlogs = systemerrlogs;
	}

	public Systemerrlog addSystemerrlog(Systemerrlog systemerrlog) {
		getSystemerrlogs().add(systemerrlog);
		systemerrlog.setFunction(this);

		return systemerrlog;
	}

	public Systemerrlog removeSystemerrlog(Systemerrlog systemerrlog) {
		getSystemerrlogs().remove(systemerrlog);
		systemerrlog.setFunction(null);

		return systemerrlog;
	}

	public List<Tad> getTads() {
		return this.tads;
	}

	public void setTads(List<Tad> tads) {
		this.tads = tads;
	}

	public Tad addTad(Tad tad) {
		getTads().add(tad);
		tad.setFunction(this);

		return tad;
	}

	public Tad removeTad(Tad tad) {
		getTads().remove(tad);
		tad.setFunction(null);

		return tad;
	}

}