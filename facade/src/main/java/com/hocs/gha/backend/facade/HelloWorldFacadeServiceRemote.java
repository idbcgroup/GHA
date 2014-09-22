package com.hocs.gha.backend.facade;

import javax.ejb.Remote;

@Remote
public interface HelloWorldFacadeServiceRemote {
	public String sayHello();
}
