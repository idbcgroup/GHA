package com.hocs.gha.backend.facade.auth;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.hocs.gha.backend.facade.auth.dto.LoginDTO;
import com.hocs.gha.backend.gom.HelloWorldServiceLocal;

/**
 * Session Bean implementation class HelloWorldFacadeService
 */
@Stateless
public class LoginService implements LoginServiceRemote {

	@EJB
	HelloWorldServiceLocal service;

	@Override
	public LoginDTO userLogin(LoginDTO credentials) {
		return new LoginDTO();
	}

	@Override
	public LoginDTO loginProcess(LoginDTO credentials) {
		// TODO: DUMMY POR AHORA
		System.out.println("credentials : " + credentials.getLogin() + " "
				+ credentials.getPassword());
		return new LoginDTO();
	}
}
