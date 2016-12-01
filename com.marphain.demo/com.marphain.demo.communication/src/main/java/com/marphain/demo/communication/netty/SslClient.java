package com.marphain.demo.communication.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marphain.demo.communication.netty.handler.ClientChannelInitializer;
import com.marphain.demo.communication.netty.utils.IConstants;
import com.marphain.demo.communication.netty.utils.MessageUtils;

public class SslClient extends Thread
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SslClient.class);

    private String serverAddress;

    private int serverPort;

    // TODO:测试代码
    private static AtomicInteger snd_num = new AtomicInteger();

    /**
     * 
     * @param serverAddress 服务端IP地址
     * @param serverPort 服务端监听端口
     */
    public SslClient(String serverAddress, int serverPort)
    {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    /**
     * 启动客户端
     */
    @Override
    public void run()
    {
        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        ((NioEventLoopGroup)group).setIoRatio(95);
        try
        {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .handler(new ClientChannelInitializer());

            ChannelFuture f = b.connect(this.serverAddress, this.serverPort).sync();
//            ChannelFuture f2 = b.connect("localhost", this.serverPort).sync();
            if (f.isSuccess())
            {
                System.out.println("client1 is started");
            }
            
//            if (f2.isSuccess())
//            {
//                System.out.println("client2 is started");
//            }

            
            LOGGER.info("server connected!!!");
            
            // 模拟网元，向南向服务端发送消息
            if (f.isSuccess())
            {
                ByteBuf msgSend = Unpooled.buffer(IConstants.MSG_SIZE);
                msgSend.writeBytes(MessageUtils.getMessage());
                MessageUtils.getTime();
                Channel channel = f.channel();
                while (true)
                {
                    if (snd_num.addAndGet(1) > IConstants.SND_NUM)
                    {
                        System.out.println("total time: " + MessageUtils.getTime());
                        break;
                    }

                    channel.writeAndFlush(msgSend.copy());

                    // 控制发送频率
                    Thread.sleep(IConstants.SLEEP_TIME_MILLIS, IConstants.SLEEP_TIME_NANOS);
                }
            }

            // 同步等待关闭.
            f.channel().closeFuture().sync();

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args)
    {
        SslClient client = new SslClient(IConstants.SERVER_ADDR, IConstants.SYS_SERVER_PORT);
        client.setName(SslClient.class.getSimpleName());
        client.start();
//        for (int i = 0; i < IConstants.MAX_CONNECTIONS; i++)
//        {
//        }
    }

}
