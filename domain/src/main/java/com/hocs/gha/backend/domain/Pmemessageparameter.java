package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the pmemessageparameter database table.
 * 
 */
@Entity
@NamedQuery(name="Pmemessageparameter.findAll", query="SELECT p FROM Pmemessageparameter p")
public class Pmemessageparameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer pmemessageparameterid;

	private String messagingmail;

	private BigDecimal periodicity;

	private String periodicitypot;

	private BigDecimal retries;

	private String sendemail;

	private BigDecimal triesbyretry;

	//bi-directional many-to-one association to Pmemessage
	@ManyToOne
	@JoinColumn(name="pmemessagecode")
	private Pmemessage pmemessage;

	public Pmemessageparameter() {
	}

	public Integer getPmemessageparameterid() {
		return this.pmemessageparameterid;
	}

	public void setPmemessageparameterid(Integer pmemessageparameterid) {
		this.pmemessageparameterid = pmemessageparameterid;
	}

	public String getMessagingmail() {
		return this.messagingmail;
	}

	public void setMessagingmail(String messagingmail) {
		this.messagingmail = messagingmail;
	}

	public BigDecimal getPeriodicity() {
		return this.periodicity;
	}

	public void setPeriodicity(BigDecimal periodicity) {
		this.periodicity = periodicity;
	}

	public String getPeriodicitypot() {
		return this.periodicitypot;
	}

	public void setPeriodicitypot(String periodicitypot) {
		this.periodicitypot = periodicitypot;
	}

	public BigDecimal getRetries() {
		return this.retries;
	}

	public void setRetries(BigDecimal retries) {
		this.retries = retries;
	}

	public String getSendemail() {
		return this.sendemail;
	}

	public void setSendemail(String sendemail) {
		this.sendemail = sendemail;
	}

	public BigDecimal getTriesbyretry() {
		return this.triesbyretry;
	}

	public void setTriesbyretry(BigDecimal triesbyretry) {
		this.triesbyretry = triesbyretry;
	}

	public Pmemessage getPmemessage() {
		return this.pmemessage;
	}

	public void setPmemessage(Pmemessage pmemessage) {
		this.pmemessage = pmemessage;
	}

}