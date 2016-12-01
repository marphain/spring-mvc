package com.marphain.demo.service.provider.register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;

public class ZKFramework implements Watcher
{
	private CountDownLatch connectedLatch = new CountDownLatch(1);
	
	private ZooKeeper zKeeper;
	
	private final static String BASE_NODE = "/Services";
	
	public void connect(String host) throws Exception
	{
		zKeeper = new ZooKeeper(host, 3000, this);
		if (States.CONNECTING == zKeeper.getState()) 
		{
			connectedLatch.await();
		}
	}
	
	@Override
	public void process(WatchedEvent event)
	{
		if (KeeperState.SyncConnected == event.getState())
		{
			connectedLatch.countDown();
			try
			{
				Stat stat = zKeeper.exists(BASE_NODE, false);
				if (stat == null)
				{
					zKeeper.create(BASE_NODE, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				}
			} 
			catch (KeeperException e)
			{
				e.printStackTrace();
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}		
	}
	
	public boolean registService(Class interfaceClass, String host) throws Exception
	{
		try 
		{
			String name = interfaceClass.getName();
			String nameNode = BASE_NODE + "/" + name;
			Stat nameStat = zKeeper.exists(nameNode, false);
			if (nameStat == null)
			{
				zKeeper.create(nameNode, name.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			
			String hostNode = nameNode + "/" + host;
			Stat hostStat = zKeeper.exists(hostNode, false);
			if (hostStat == null)
			{
				zKeeper.create(hostNode, host.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			
			return true;
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Map<String, List<String>> getService() throws Exception
	{
		Map<String, List<String>> serviceMap = new HashMap<String, List<String>>();
		List<String> nameNodes = zKeeper.getChildren(BASE_NODE, true);
		for(String nameNode : nameNodes)
		{
			nameNode = BASE_NODE + "/" + nameNode; 
			String serviceName = new String(zKeeper.getData(nameNode, false, null));
			List<String> hostsNode = zKeeper.getChildren(nameNode, true);
			List<String> hosts = new ArrayList<String>();
			for(String hostNode : hostsNode)
			{
				hostNode = nameNode + "/" + hostNode;
				String hostName = new String(zKeeper.getData(hostNode, false, null));
				hosts.add(hostName);
			}
			
			serviceMap.put(serviceName, hosts);
		}
		
		return serviceMap;
	}
	
	public static void main(String[] args)
	{
		System.out.println(ZKFramework.class.getName());
	}

}
