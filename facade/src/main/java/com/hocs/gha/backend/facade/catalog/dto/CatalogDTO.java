/***********************************************************************
 * Module:  CatalogsDTO.java
 * Author:  Oskar
 * Purpose: Defines the Class CatalogsDTO
 ***********************************************************************/

package com.hocs.gha.backend.facade.catalog.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.hocs.gha.backend.facade.dto.GHAFacadeDTO;

public class CatalogDTO extends GHAFacadeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 61087091743937938L;

	private int idCatalog;

	public Map<String,CatalogParameterDTO> parameters = new HashMap<>();

	public int getIdCatalog() {
		return idCatalog;
	}

	public void setIdCatalog(int idCatalog) {
		this.idCatalog = idCatalog;
	}

	public Map<String, CatalogParameterDTO> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, CatalogParameterDTO> parameters) {
		this.parameters = parameters;
	}
	
	public void addParameter(CatalogParameterDTO parameter) {
		if (parameter != null) {
			parameters.put(parameter.getName(),parameter);
		}
	}

	public void removeParameter(String name) {
		parameters.remove(name);
	}

	public CatalogParameterDTO getParameter(String name) {
		return parameters.get(name);
	}
	
	public boolean hasParameter(String name) {
		return parameters.containsKey(name);
	}
						
	

}