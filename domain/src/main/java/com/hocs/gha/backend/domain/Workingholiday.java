package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the workingholiday database table.
 * 
 */
@Entity
@NamedQuery(name="Workingholiday.findAll", query="SELECT w FROM Workingholiday w")
public class Workingholiday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer workingholidayid;

	private String bpicode;

	@Temporal(TemporalType.DATE)
	private Date holidaydate;

	private BigDecimal holidayday;

	private String holidaydescription;

	private String holidaymonth;

	private String holidaytype;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	public Workingholiday() {
	}

	public Integer getWorkingholidayid() {
		return this.workingholidayid;
	}

	public void setWorkingholidayid(Integer workingholidayid) {
		this.workingholidayid = workingholidayid;
	}

	public String getBpicode() {
		return this.bpicode;
	}

	public void setBpicode(String bpicode) {
		this.bpicode = bpicode;
	}

	public Date getHolidaydate() {
		return this.holidaydate;
	}

	public void setHolidaydate(Date holidaydate) {
		this.holidaydate = holidaydate;
	}

	public BigDecimal getHolidayday() {
		return this.holidayday;
	}

	public void setHolidayday(BigDecimal holidayday) {
		this.holidayday = holidayday;
	}

	public String getHolidaydescription() {
		return this.holidaydescription;
	}

	public void setHolidaydescription(String holidaydescription) {
		this.holidaydescription = holidaydescription;
	}

	public String getHolidaymonth() {
		return this.holidaymonth;
	}

	public void setHolidaymonth(String holidaymonth) {
		this.holidaymonth = holidaymonth;
	}

	public String getHolidaytype() {
		return this.holidaytype;
	}

	public void setHolidaytype(String holidaytype) {
		this.holidaytype = holidaytype;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}