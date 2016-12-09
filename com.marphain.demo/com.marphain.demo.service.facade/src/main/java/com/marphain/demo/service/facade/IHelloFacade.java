package com.marphain.demo.service.facade;

import javax.jws.WebService;

@WebService
public interface IHelloFacade
{
	String sayHello(String name);
}
