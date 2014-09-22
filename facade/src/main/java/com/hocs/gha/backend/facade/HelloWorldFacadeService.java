package com.hocs.gha.backend.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.hocs.gha.backend.gom.HelloWorldServiceLocal;

/**
 * Session Bean implementation class HelloWorldFacadeService
 */
@Stateless
public class HelloWorldFacadeService implements HelloWorldFacadeServiceRemote {

	@EJB()
	HelloWorldServiceLocal service;

	@Override
	public String sayHello() {
		return "HELLO WORLD SERVICE FACADE "
				+ (service != null ? service.sayHello() : "service is null");
	}
}
