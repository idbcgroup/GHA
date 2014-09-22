package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the pmemessage database table.
 * 
 */
@Entity
@NamedQuery(name="Pmemessage.findAll", query="SELECT p FROM Pmemessage p")
public class Pmemessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String pmemessagecode;

	private String messageaction;

	private String messagebuttonresponse01;

	private String messagebuttonresponse02;

	private String messagebuttonresponse03;

	private String messagedescription;

	private BigDecimal messageid;

	private String messageindication;

	private String messageseverity;

	private String messageshowview;

	private String messagetype;

	private BigDecimal timeshowing;

	//bi-directional many-to-one association to Function
	@ManyToOne
	@JoinColumn(name="functioncode")
	private Function function;

	//bi-directional many-to-one association to Itsystem
	@ManyToOne
	@JoinColumn(name="itsystemcode")
	private Itsystem itsystem;

	//bi-directional many-to-one association to Systemmodule
	@ManyToOne
	@JoinColumn(name="modulecode")
	private Systemmodule systemmodule;

	//bi-directional many-to-one association to Pmemessageparameter
	@OneToMany(mappedBy="pmemessage")
	private List<Pmemessageparameter> pmemessageparameters;

	//bi-directional many-to-one association to Systemerrlog
	@OneToMany(mappedBy="pmemessage")
	private List<Systemerrlog> systemerrlogs;

	public Pmemessage() {
	}

	public String getPmemessagecode() {
		return this.pmemessagecode;
	}

	public void setPmemessagecode(String pmemessagecode) {
		this.pmemessagecode = pmemessagecode;
	}

	public String getMessageaction() {
		return this.messageaction;
	}

	public void setMessageaction(String messageaction) {
		this.messageaction = messageaction;
	}

	public String getMessagebuttonresponse01() {
		return this.messagebuttonresponse01;
	}

	public void setMessagebuttonresponse01(String messagebuttonresponse01) {
		this.messagebuttonresponse01 = messagebuttonresponse01;
	}

	public String getMessagebuttonresponse02() {
		return this.messagebuttonresponse02;
	}

	public void setMessagebuttonresponse02(String messagebuttonresponse02) {
		this.messagebuttonresponse02 = messagebuttonresponse02;
	}

	public String getMessagebuttonresponse03() {
		return this.messagebuttonresponse03;
	}

	public void setMessagebuttonresponse03(String messagebuttonresponse03) {
		this.messagebuttonresponse03 = messagebuttonresponse03;
	}

	public String getMessagedescription() {
		return this.messagedescription;
	}

	public void setMessagedescription(String messagedescription) {
		this.messagedescription = messagedescription;
	}

	public BigDecimal getMessageid() {
		return this.messageid;
	}

	public void setMessageid(BigDecimal messageid) {
		this.messageid = messageid;
	}

	public String getMessageindication() {
		return this.messageindication;
	}

	public void setMessageindication(String messageindication) {
		this.messageindication = messageindication;
	}

	public String getMessageseverity() {
		return this.messageseverity;
	}

	public void setMessageseverity(String messageseverity) {
		this.messageseverity = messageseverity;
	}

	public String getMessageshowview() {
		return this.messageshowview;
	}

	public void setMessageshowview(String messageshowview) {
		this.messageshowview = messageshowview;
	}

	public String getMessagetype() {
		return this.messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

	public BigDecimal getTimeshowing() {
		return this.timeshowing;
	}

	public void setTimeshowing(BigDecimal timeshowing) {
		this.timeshowing = timeshowing;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Itsystem getItsystem() {
		return this.itsystem;
	}

	public void setItsystem(Itsystem itsystem) {
		this.itsystem = itsystem;
	}

	public Systemmodule getSystemmodule() {
		return this.systemmodule;
	}

	public void setSystemmodule(Systemmodule systemmodule) {
		this.systemmodule = systemmodule;
	}

	public List<Pmemessageparameter> getPmemessageparameters() {
		return this.pmemessageparameters;
	}

	public void setPmemessageparameters(List<Pmemessageparameter> pmemessageparameters) {
		this.pmemessageparameters = pmemessageparameters;
	}

	public Pmemessageparameter addPmemessageparameter(Pmemessageparameter pmemessageparameter) {
		getPmemessageparameters().add(pmemessageparameter);
		pmemessageparameter.setPmemessage(this);

		return pmemessageparameter;
	}

	public Pmemessageparameter removePmemessageparameter(Pmemessageparameter pmemessageparameter) {
		getPmemessageparameters().remove(pmemessageparameter);
		pmemessageparameter.setPmemessage(null);

		return pmemessageparameter;
	}

	public List<Systemerrlog> getSystemerrlogs() {
		return this.systemerrlogs;
	}

	public void setSystemerrlogs(List<Systemerrlog> systemerrlogs) {
		this.systemerrlogs = systemerrlogs;
	}

	public Systemerrlog addSystemerrlog(Systemerrlog systemerrlog) {
		getSystemerrlogs().add(systemerrlog);
		systemerrlog.setPmemessage(this);

		return systemerrlog;
	}

	public Systemerrlog removeSystemerrlog(Systemerrlog systemerrlog) {
		getSystemerrlogs().remove(systemerrlog);
		systemerrlog.setPmemessage(null);

		return systemerrlog;
	}

}