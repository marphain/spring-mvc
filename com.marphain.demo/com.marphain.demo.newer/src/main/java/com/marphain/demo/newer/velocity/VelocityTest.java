package com.marphain.demo.newer.velocity;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityTest
{
	public static void main(String[] args)
	{
		//获取模板引擎
		VelocityEngine vEngine = new VelocityEngine();
		vEngine.init();
		
		//获取模板
		Template template = vEngine.getTemplate("velocityTest.vm");
		
		//构造上下文
		VelocityContext vContext = new VelocityContext();
		vContext.put("name", "marphain");
		vContext.put("dsc", "programmer");
		
		//输出网页字符串
		StringWriter writer = new StringWriter();
		template.merge(vContext, writer);
		
		System.out.println(writer.toString());		
	}

}
