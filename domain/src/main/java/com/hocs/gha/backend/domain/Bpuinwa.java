package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bpuinwa database table.
 * 
 */
@Entity
@NamedQuery(name="Bpuinwa.findAll", query="SELECT b FROM Bpuinwa b")
public class Bpuinwa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer bpuinwa;

	private Boolean bpuwahoraryrestricted;

	private Boolean inthiswahoraryrestricted;

	private Boolean thisisprimarywa;

	//bi-directional many-to-one association to Bpu
	@ManyToOne
	@JoinColumn(name="bpucode")
	private Bpu bpu;

	//bi-directional many-to-one association to Workingarea
	@ManyToOne
	@JoinColumn(name="workingareacode")
	private Workingarea workingarea;

	public Bpuinwa() {
	}

	public Integer getBpuinwa() {
		return this.bpuinwa;
	}

	public void setBpuinwa(Integer bpuinwa) {
		this.bpuinwa = bpuinwa;
	}

	public Boolean getBpuwahoraryrestricted() {
		return this.bpuwahoraryrestricted;
	}

	public void setBpuwahoraryrestricted(Boolean bpuwahoraryrestricted) {
		this.bpuwahoraryrestricted = bpuwahoraryrestricted;
	}

	public Boolean getInthiswahoraryrestricted() {
		return this.inthiswahoraryrestricted;
	}

	public void setInthiswahoraryrestricted(Boolean inthiswahoraryrestricted) {
		this.inthiswahoraryrestricted = inthiswahoraryrestricted;
	}

	public Boolean getThisisprimarywa() {
		return this.thisisprimarywa;
	}

	public void setThisisprimarywa(Boolean thisisprimarywa) {
		this.thisisprimarywa = thisisprimarywa;
	}

	public Bpu getBpu() {
		return this.bpu;
	}

	public void setBpu(Bpu bpu) {
		this.bpu = bpu;
	}

	public Workingarea getWorkingarea() {
		return this.workingarea;
	}

	public void setWorkingarea(Workingarea workingarea) {
		this.workingarea = workingarea;
	}

}