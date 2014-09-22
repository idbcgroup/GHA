/**
 * 
 */
package com.hocs.gha.backend.facade.dto;

import java.io.Serializable;

/**
 * @author emiliot
 * 
 */
public class FacadeResultDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7344888836582307305L;

	private int idResult;

	private String description;

	private String message;

	public int getIdResult() {
		return idResult;
	}

	public void setIdResult(int idResult) {
		this.idResult = idResult;
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
