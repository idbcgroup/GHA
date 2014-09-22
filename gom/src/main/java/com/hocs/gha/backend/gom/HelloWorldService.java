package com.hocs.gha.backend.gom;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldService
 */
@Stateless
public class HelloWorldService implements HelloWorldServiceLocal {

	@Override
	public String sayHello() {
		return "HELLO WORLD EJB LOCAL BEAN";
	}

}
