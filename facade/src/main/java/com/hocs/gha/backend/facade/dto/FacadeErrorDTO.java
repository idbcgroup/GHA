/**
 * 
 */
package com.hocs.gha.backend.facade.dto;

import java.io.Serializable;

/**
 * @author emiliot
 * 
 */
public class FacadeErrorDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4938684659089411426L;

	private int idError;

	private String description;

	private String message;

	public int getIdError() {
		return idError;
	}

	public void setIdError(int idError) {
		this.idError = idError;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
