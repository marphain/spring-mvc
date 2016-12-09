package com.marphain.demo.springmvc.ext.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.marphain.demo.service.facade.IHelloFacade;
import com.marphain.demo.springmvc.ext.service.IExtHelloService;

/**
 * 
 * @author majiafei
 *
 */
@Service
public class ExtHelloServiceImlp implements IExtHelloService
{
	@Resource
	private IHelloFacade helloFacade;

	@Override
	public String sayHello(String name)
	{
		return helloFacade.sayHello(name);
	}

}
