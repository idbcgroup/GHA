package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the descriptordetail database table.
 * 
 */
@Entity
@NamedQuery(name="Descriptordetail.findAll", query="SELECT d FROM Descriptordetail d")
public class Descriptordetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer descriptordetailid;

	private String descriptordetail;

	//bi-directional many-to-one association to Descriptor
	@ManyToOne
	@JoinColumn(name="descriptorid")
	private Descriptor descriptor;

	public Descriptordetail() {
	}

	public Integer getDescriptordetailid() {
		return this.descriptordetailid;
	}

	public void setDescriptordetailid(Integer descriptordetailid) {
		this.descriptordetailid = descriptordetailid;
	}

	public String getDescriptordetail() {
		return this.descriptordetail;
	}

	public void setDescriptordetail(String descriptordetail) {
		this.descriptordetail = descriptordetail;
	}

	public Descriptor getDescriptor() {
		return this.descriptor;
	}

	public void setDescriptor(Descriptor descriptor) {
		this.descriptor = descriptor;
	}

}