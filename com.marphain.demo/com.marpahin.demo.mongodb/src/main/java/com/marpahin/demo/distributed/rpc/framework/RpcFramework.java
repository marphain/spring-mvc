package com.marpahin.demo.distributed.rpc.framework;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * RPC框架
 *
 * @author m13430
 * @date 2015年9月9日
 * @since com.hytera.lte.ems.south.rpc
 */
public class RpcFramework
{
	private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
    /**
     * 导出（发布）服务
     * 
     * @param service 服务实现
     * @param port 服务端口
     * @throws Exception
     */
    public static void export(final Object service, int port) throws Exception
    {
        if (service == null)
        {
            throw new IllegalArgumentException("service instance == null");
        }

        if (port <= 0 || port > 65535)
        {
            throw new IllegalArgumentException("Invalid port " + port);
        }

        System.out.println("Export service " + service.getClass().getName()
                + " on port " + port);

        ServerSocket server = new ServerSocket(port);
        for (;;)
        {
            try
            {
            	// 等待客户端连接
                final Socket socket = server.accept();
                executor.execute(new Task(socket, service));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 引用服务
     * 
     * @param <T> 接口泛型
     * @param interfaceClass 接口类型
     * @param host 服务器主机名
     * @param port 服务器端口
     * @return 远程服务
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T refer(final Class<T> interfaceClass, final String host,
            final int port) throws Exception
    {
        if (interfaceClass == null)
        {
            throw new IllegalArgumentException("Interface class == null");
        }

        if (!interfaceClass.isInterface())
        {
            throw new IllegalArgumentException("The "
                    + interfaceClass.getName() + " must be interface class!");
        }

        ReferHandler h = new ReferHandler(host, port);
        
        System.out.println("Get remote service " + interfaceClass.getName()
                + " from server " + host + ":" + port);
        
        Object obj = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, h);

        return (T) obj;
    }

}

/**
 * 请求处理任务
 *
 * @author m13430
 * @date   2015年9月9日
 * @since  com.hytera.lte.ems.south.rpc.framework
 */
class Task implements Runnable
{
    private Socket socket;
    
    private Object service;
    
    public Task(final Socket socket, Object service)
    {
        this.socket = socket;
        this.service = service;
    }

    public void run()
    {
        try
        {
            try
            {
                ObjectInputStream input = new ObjectInputStream(
                        socket.getInputStream());
                try
                {
                    String methodName = input.readUTF();
                    Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                    Object[] arguments = (Object[]) input.readObject();
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    try
                    {
                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                        Object result = method.invoke(service, arguments);
                        output.writeObject(result);
                    }
                    catch (Throwable t)
                    {
                        output.writeObject(t);
                    }
                    finally
                    {
                        output.close();
                    }
                }
                finally
                {
                    input.close();
                }
            }
            finally
            {
                socket.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}

/**
 * 发送请求类
 *
 * @author m13430
 * @date   2015年9月9日
 * @since  com.hytera.lte.ems.south.rpc.framework
 */
class ReferHandler implements InvocationHandler
{
    private String host;

    private int port;

    public ReferHandler(String host, int port)
    {
        if (host == null || host.length() == 0)
        {
            throw new IllegalArgumentException("Host == null!");
        }

        if (port <= 0 || port > 65535)
        {
            throw new IllegalArgumentException("Invalid port " + port);
        }

        this.host = host;
        this.port = port;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable
    {
        Socket socket = new Socket(host, port);
        try
        {
            ObjectOutputStream output = new ObjectOutputStream(
                    socket.getOutputStream());
            try
            {
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(args);
                ObjectInputStream input = new ObjectInputStream(
                        socket.getInputStream());
                try
                {
                    Object result = input.readObject();
                    if (result instanceof Throwable)
                    {
                        throw (Throwable) result;
                    }
                    return result;
                }
                finally
                {
                    input.close();
                }
            }
            finally
            {
                output.close();
            }
        }
        finally
        {
            socket.close();
        }
    }

}