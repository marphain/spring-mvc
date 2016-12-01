package com.marphain.demo.communication.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 
 *
 * @author m13430
 * @date   2015��7��31��
 * @since  com.hytera.lte.nm.socket.netty.handler
 */
public class NeMsgSendHandler extends ChannelInboundHandlerAdapter
{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        super.channelRead(ctx, msg);
    }

}
