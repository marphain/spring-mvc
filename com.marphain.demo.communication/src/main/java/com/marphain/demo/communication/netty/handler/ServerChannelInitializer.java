package com.marphain.demo.communication.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.ssl.SslHandler;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marphain.demo.communication.netty.context.SslContextFactory;
import com.marphain.demo.communication.netty.utils.IConstants;

/**
 * 
 *
 * @author m13430
 * @date   2015年8月3日
 * @since  com.hytera.lte.nm.socket.netty.handler
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerChannelInitializer.class);
    
    @Override
    protected void initChannel(SocketChannel ch) throws Exception
    {
        LOGGER.debug("start to init socket channel");
        ChannelPipeline pipeline = ch.pipeline();

        // 添加日志打印处理器，支持slf4j、log4j、java.util.logging
        // pipeline.addLast("log", new LoggingHandler(LogLevel.INFO));

        // 添加SSL处理器，必须在解码之前执行
        addSslHandler(pipeline);

        // 添加心跳处理器
        pipeline.addLast("keepalive", new KeepAliveHandler());

        // 添加编解码处理器
        addCodecHandler(pipeline);

        // 消息转发处理器
        pipeline.addLast("handler", new MsgRecieveHandler());

    }

    private void addSslHandler(ChannelPipeline pipeline)
    {
        LOGGER.debug("add SSL handler.");
        if (IConstants.USE_SSL)
        {
            SSLEngine engine = SslContextFactory.getSslContext(IConstants.SERVER_KEYSTORE_PATH).createSSLEngine();
            engine.setUseClientMode(false);
            engine.setNeedClientAuth(true);// 双向认证

            SslHandler sslHandler = new SslHandler(engine);
            sslHandler.setHandshakeTimeout(10, TimeUnit.MINUTES);

            pipeline.addLast("ssl", sslHandler);
        }
    }

    // TODO:根据与网元通信的消息格式进行编解码（只需解析包头）
    private void addCodecHandler(ChannelPipeline pipeline)
    {
        LOGGER.debug("add codec handler.");
        // 该组合是按行切换的文本解码器，可解决TCP的粘包和拆包问题,超出最大长度则抛异常
        // pipeline.addLast(new LineBasedFrameDecoder(Constants.MSG_SIZE + 2));
        // pipeline.addLast(new StringDecoder());

        // 使用特殊的消息分隔符做为结束标志
        // ByteBuf delimiter = Unpooled.copiedBuffer(",".getBytes());
        // pipeline.addLast(new DelimiterBasedFrameDecoder(Constants.MSG_SIZE,
        // false, delimiter));
        // pipeline.addLast(new StringDecoder());

        // pipeline.addLast("handler", new NodeMsgRecieveHandler());

        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024, 2, 2, -4, 0));

        // pipeline.addLast(new LengthFieldBasedFrameDecoder(1024, 2, 2));

        // 固定长度，如果包大小小于MSG_SIZE则等待，如果包大小大于MSG_SIZE则截取
        // pipeline.addLast(new FixedLengthFrameDecoder(Constants.MSG_SIZE));
        // pipeline.addLast(new StringDecoder());
    }
}
