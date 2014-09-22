package com.hocs.gha.backend.gom;

import javax.ejb.Local;

@Local
public interface HelloWorldServiceLocal {
	public String sayHello();
}
