/***********************************************************************
 * Module:  CatalogParameterDTO.java
 * Author:  Oskar
 * Purpose: Defines the Class CatalogParameterDTO
 ***********************************************************************/

package com.hocs.gha.backend.facade.catalog.dto;

import java.io.Serializable;

public class CatalogParameterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2799936618946978233L;

	private String name;

	private String value;

	public String getName() {
		return name;
	}

	public void setName(java.lang.String newName) {
		name = newName;
	}

	public java.lang.String getValue() {
		return value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}

}