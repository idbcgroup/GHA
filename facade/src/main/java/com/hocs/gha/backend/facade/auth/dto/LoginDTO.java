package com.hocs.gha.backend.facade.auth.dto;

import java.io.Serializable;

/**
 * @author naramirez
 */
public class LoginDTO extends AuthDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean invalidPassword;
	private String password;
	private boolean sessionStarted;
	private boolean sessionTimedOut;
	private int loginAttemptsCount;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the invalidPassword
	 */
	public boolean isInvalidPassword() {
		return invalidPassword;
	}

	/**
	 * @param invalidPassword
	 */
	public void setInvalidPassword(boolean invalidPassword) {
		this.invalidPassword = invalidPassword;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the sessionStarted
	 */
	public boolean isSessionStarted() {
		return sessionStarted;
	}

	/**
	 * @param sessionStarted
	 *            the sessionStarted to set
	 */
	public void setSessionStarted(boolean sessionStarted) {
		this.sessionStarted = sessionStarted;
	}

	/**
	 * @return the sessionTimedOut
	 */
	public boolean isSessionTimedOut() {
		return sessionTimedOut;
	}

	/**
	 * @param sessionTimedOut
	 *            the sessionTimedOut to set
	 */
	public void setSessionTimedOut(boolean sessionTimedOut) {
		this.sessionTimedOut = sessionTimedOut;
	}

	/**
	 * @return the loginAttemptsCount
	 */
	public int getLoginAttemptsCount() {
		return loginAttemptsCount;
	}

	/**
	 * @param loginAttemptsCount
	 *            the loginAttemptsCount to set
	 */
	public void setLoginAttemptsCount(int loginAttemptsCount) {
		this.loginAttemptsCount = loginAttemptsCount;
	}
}
