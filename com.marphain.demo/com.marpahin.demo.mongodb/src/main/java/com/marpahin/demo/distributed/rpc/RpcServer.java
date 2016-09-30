package com.marpahin.demo.distributed.rpc;

import com.marpahin.demo.distributed.rpc.framework.RpcFramework;
import com.marpahin.demo.distributed.rpc.service.HelloServiceImpl;
import com.marpahin.demo.distributed.rpc.service.IHelloService;

/**
 * RPC服务端
 * @author m13430
 * @date   2015年9月9日
 * @since  com.hytera.lte.ems.south.rpc
 *
 */
public class RpcServer
{
    public static void main(String[] args) throws Exception
    {
        IHelloService service = new HelloServiceImpl();
        
        //发布服务
        RpcFramework.export(service, 8888);
    }

}
