package com.marphain.demo.service.impl;

import com.marphain.demo.service.IHelloService;

/**
*
* @author m13430
* @date   2015年9月9日
* @since  com.hytera.lte.ems.south.rpc
*
*/
public class HelloServiceImpl implements IHelloService
{
	@Override
	public String hello(String name)
    {
        return "Hello " + name;
    }
}
