package com.hocs.gha.backend.facade.auth;

import javax.ejb.Remote;

import com.hocs.gha.backend.facade.auth.dto.LoginDTO;

/**
 * @author nelson
 * 
 */
@Remote
public interface LoginServiceRemote {
	/** */
	public static final String JNDI_NAME = "java:global/backend-1.0/facade-1.0/LoginService";

	/**
	 * @param credentials
	 * @return LoginDTO
	 */
	public LoginDTO userLogin(LoginDTO credentials);

	/**
	 * @param credentials
	 * @return the logindto with the result of the request
	 */
	public LoginDTO loginProcess(LoginDTO credentials);
}
