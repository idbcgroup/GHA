package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bpuinstitution database table.
 * 
 */
@Entity
@NamedQuery(name="Bpuinstitution.findAll", query="SELECT b FROM Bpuinstitution b")
public class Bpuinstitution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer bpuinbpiid;

	//bi-directional many-to-one association to Bpu
	@ManyToOne
	@JoinColumn(name="bpucode")
	private Bpu bpu;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	public Bpuinstitution() {
	}

	public Integer getBpuinbpiid() {
		return this.bpuinbpiid;
	}

	public void setBpuinbpiid(Integer bpuinbpiid) {
		this.bpuinbpiid = bpuinbpiid;
	}

	public Bpu getBpu() {
		return this.bpu;
	}

	public void setBpu(Bpu bpu) {
		this.bpu = bpu;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}