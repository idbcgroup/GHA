/**
 * 
 */
package com.hocs.gha.backend.facade.dto;

import java.io.Serializable;

/**
 * @author emiliot
 * 
 */
public abstract class GHAFacadeDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4250464335503841821L;

	private int idModule;

	private int idSubModule;

	private FacadeErrorDTO facadeErrorDTO;

	private FacadeResultDTO facadeResultDTO;

	public int getIdModule() {
		return idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	public int getIdSubModule() {
		return idSubModule;
	}

	public void setIdSubModule(int idSubModule) {
		this.idSubModule = idSubModule;
	}

	public FacadeErrorDTO getFacadeErrorDTO() {
		return facadeErrorDTO;
	}

	public void setFacadeErrorDTO(FacadeErrorDTO facadeErrorDTO) {
		this.facadeErrorDTO = facadeErrorDTO;
	}

	public FacadeResultDTO getFacadeResultDTO() {
		return facadeResultDTO;
	}

	public void setFacadeResultDTO(FacadeResultDTO facadeResultDTO) {
		this.facadeResultDTO = facadeResultDTO;
	}
}
