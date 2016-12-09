package com.marphain.demo.webservice;

import javax.jws.WebService;

import com.marphain.demo.service.facade.IHelloFacade;

@WebService(endpointInterface = "com.marphain.demo.service.facade.IHelloFacade")
public class HelloFacadeImpl implements IHelloFacade
{
	@Override
	public String sayHello(String name)
	{
		return "Hello " + name;
	}
}
