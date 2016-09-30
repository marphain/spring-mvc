package com.marphain.demo.communication.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.marphain.demo.communication.netty.handler.ServerChannelInitializer;
import com.marphain.demo.communication.netty.utils.IConstants;

/**
 * 初始化南向服务端的SocketChannel
 * @author m13430
 * @date 2015年7月29日
 * @since com.hytera.lte.nm.socket.netty
 *
 */
public class SslServer implements Runnable
{
     //服务端监听端口
    private int port;
    
    private CountDownLatch latch;

    /**
     * 
     * @param port 服务端监听端口
     */
    public SslServer(int port, CountDownLatch latch)
    {
        this.port = port;
        this.latch = latch;
    }

    public void run()
    {
        // 处理连接管理的线程数默认为1.
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        
        // 处理IO的线程个数，默认的为cpu核数的2倍
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ((NioEventLoopGroup)workerGroup).setIoRatio(50);

        try
        {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.ALLOCATOR, new UnpooledByteBufAllocator(true))
                    .option(ChannelOption.SO_RCVBUF, IConstants.RCVBUF_SIZE)
                    .option(ChannelOption.SO_BACKLOG, 1010)// 允许的最大连接数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)// TODO:与网元保活，需要自定义
                    .childHandler(new ServerChannelInitializer());

            // 启动服务器
            ChannelFuture f = b.bind(this.port).sync();
            
            if (f.isSuccess())
            {
                latch.countDown();
            }
            

            // 同步等待关闭套接字
            f.channel().closeFuture().sync();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 优雅关闭线程池
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args)
    {
        ExecutorService executor = null;
        try
        {
            executor = Executors.newSingleThreadExecutor();
            executor.execute(new SslServer(IConstants.SYS_SERVER_PORT, new CountDownLatch(1)));
        }
        finally
        {
            if (executor != null)
            {
                executor.shutdown();
            }
        }
    }
}
