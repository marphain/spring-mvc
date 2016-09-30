package com.marphain.demo.springmvc.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marphain.demo.springmvc.service.IHelloService;

@Controller
@RequestMapping(value = "/hello")
public class HelloController
{
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Resource
	private IHelloService helloService;
	
	@RequestMapping(value = "/sayHello")
	public String sayHello(Model model)
	{
		if (log.isInfoEnabled())
		{
			log.info("start to run sayHello().");
		}
		
		String words = helloService.hello();
		
		model.addAttribute("context", words);
		return "hello/sayHello";				
	}
}
