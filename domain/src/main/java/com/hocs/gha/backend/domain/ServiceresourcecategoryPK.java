package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the serviceresourcecategory database table.
 * 
 */
@Embeddable
public class ServiceresourcecategoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String serviceresourcearea;

	private String serviceresourcetype;

	private String serviceresourcesubtype;

	public ServiceresourcecategoryPK() {
	}
	public String getServiceresourcearea() {
		return this.serviceresourcearea;
	}
	public void setServiceresourcearea(String serviceresourcearea) {
		this.serviceresourcearea = serviceresourcearea;
	}
	public String getServiceresourcetype() {
		return this.serviceresourcetype;
	}
	public void setServiceresourcetype(String serviceresourcetype) {
		this.serviceresourcetype = serviceresourcetype;
	}
	public String getServiceresourcesubtype() {
		return this.serviceresourcesubtype;
	}
	public void setServiceresourcesubtype(String serviceresourcesubtype) {
		this.serviceresourcesubtype = serviceresourcesubtype;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ServiceresourcecategoryPK)) {
			return false;
		}
		ServiceresourcecategoryPK castOther = (ServiceresourcecategoryPK)other;
		return 
			this.serviceresourcearea.equals(castOther.serviceresourcearea)
			&& this.serviceresourcetype.equals(castOther.serviceresourcetype)
			&& this.serviceresourcesubtype.equals(castOther.serviceresourcesubtype);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.serviceresourcearea.hashCode();
		hash = hash * prime + this.serviceresourcetype.hashCode();
		hash = hash * prime + this.serviceresourcesubtype.hashCode();
		
		return hash;
	}
}