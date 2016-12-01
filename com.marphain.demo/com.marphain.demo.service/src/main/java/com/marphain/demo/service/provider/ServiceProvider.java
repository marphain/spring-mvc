package com.marphain.demo.service.provider;

import java.util.List;
import java.util.Map;

import com.marphain.demo.service.IHelloService;
import com.marphain.demo.service.impl.HelloServiceImpl;
import com.marphain.demo.service.provider.publish.RpcFramework;
import com.marphain.demo.service.provider.register.ZKFramework;

public class ServiceProvider
{
	public static void main(String[] args)
	{
		try
		{
			final RpcFramework rpcFramework = new RpcFramework();
			
			//1.发布服务
			new Thread(new Runnable()
			{
				
				@Override
				public void run()
				{
					try 
					{
						rpcFramework.export(new HelloServiceImpl(), 8080);
					} 
					catch (Exception e)
					{
						e.printStackTrace();
					}
					
				}
			}).start();;
			
			ZKFramework zkFramework = new ZKFramework();
			
			//2.连接服务注册中心
			zkFramework.connect("192.168.56.101");
			
			//3.注册服务
			zkFramework.registService(IHelloService.class, "192.168.10.132:8080");
			
			//4.引用服务
			Map<String, List<String>> servicesMap = zkFramework.getService();
			
			//TODO:服务选择算法
			List<String> hosts = servicesMap.get(IHelloService.class.getName());
			String host = hosts.get(0);
			String[] hostInfo = host.split(":");
			
			IHelloService helloService = rpcFramework.refer(IHelloService.class, hostInfo[0], Integer.valueOf(hostInfo[1]));
			
			System.out.println(helloService.hello("World"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
