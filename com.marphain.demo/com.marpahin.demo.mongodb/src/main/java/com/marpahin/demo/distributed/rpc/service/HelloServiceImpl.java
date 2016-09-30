package com.marpahin.demo.distributed.rpc.service;

/**
*
* @author m13430
* @date   2015年9月9日
* @since  com.hytera.lte.ems.south.rpc
*
*/
public class HelloServiceImpl implements IHelloService
{
	public String hello(String name)
    {
        return "Hello " + name;
    }
}
