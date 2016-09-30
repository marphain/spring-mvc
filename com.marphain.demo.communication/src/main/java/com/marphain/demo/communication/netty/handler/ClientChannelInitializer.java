package com.marphain.demo.communication.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslHandler;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLEngine;

import com.marphain.demo.communication.netty.context.SslContextFactory;
import com.marphain.demo.communication.netty.utils.IConstants;

/**
 *
 * @author m13430
 * @date   2015年7月31日
 * @since  com.hytera.lte.nm.socket.netty.handler
 *
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel>
{

    @Override
    protected void initChannel(SocketChannel ch) throws Exception
    {
        ChannelPipeline pipeline = ch.pipeline();

        addSslHandler(pipeline);

        pipeline.addLast("handler", new NeMsgSendHandler());
    }
    
    private void addSslHandler(ChannelPipeline pipeline)
    {
        if (IConstants.USE_SSL)
        {
            SSLEngine engine = SslContextFactory.getSslContext(IConstants.CLIENT_KEYSTORE_PATH).createSSLEngine();
            engine.setUseClientMode(true);

            SslHandler ssl = new SslHandler(engine);
            ssl.setHandshakeTimeout(10, TimeUnit.MINUTES);

            pipeline.addLast("ssl", ssl);
        }
    }

}
