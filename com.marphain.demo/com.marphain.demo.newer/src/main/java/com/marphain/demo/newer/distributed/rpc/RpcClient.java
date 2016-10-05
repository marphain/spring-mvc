package com.marphain.demo.newer.distributed.rpc;

import com.marphain.demo.newer.distributed.rpc.framework.RpcFramework;
import com.marphain.demo.newer.distributed.rpc.service.IHelloService;

/**
 * RPC客户端
 * @author m13430
 * @date   2015年9月9日
 * @since  com.hytera.lte.ems.south.rpc
 *
 */
public class RpcClient
{
    public static void main(String[] args) throws Exception
    {
        IHelloService service = RpcFramework.refer(IHelloService.class, "localhost", 8888);
        System.out.println(service.hello("World!"));
    }

}
