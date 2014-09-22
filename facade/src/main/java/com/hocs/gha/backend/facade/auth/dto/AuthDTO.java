/**
 * 
 */
package com.hocs.gha.backend.facade.auth.dto;

import java.io.Serializable;

import com.hocs.gha.backend.facade.dto.GHAFacadeDTO;

/**
 * @author emiliot
 * 
 */
public class AuthDTO extends GHAFacadeDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3040093484612797920L;

	private int idOperation;
	private String login;

	public int getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(int newIdOperation) {
		idOperation = newIdOperation;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
