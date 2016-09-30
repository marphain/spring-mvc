package com.marphain.demo.communication.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

import com.marphain.demo.communication.netty.handler.UDPClientHandler;

/**
 * A UDP client that send messages to
 * {@link UDPServer}
 * to test performance.
 * 
 * 1.register channel to EventLoopGroup
 * 
 *
 */
public class UDPClient extends Thread{
	public static final int PORT = 8888;        //the port which is used to send messages.
	public static final int MSGSIZE = 500;      //the size(byte) of a datagram packet.
	public static final int THREADNUM = 200;    //the number of thread.
	public static final int PACKETNUM = 10000;  //the number of datagram packet.
	public static final int SLEEPTIME = 30;     //the periodic of sending messages.

    @Override
    public void run() {
    	// the NioEventLoopGroup is used to handle all the events for the to-be-creates Channel
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioDatagramChannel.class)// the NioDatagramChannel is used to create Channel instances from
             .option(ChannelOption.SO_BROADCAST, false)
             .handler(new UDPClientHandler());// use for serving the requests

            Channel ch = b.bind(0).sync().channel();// active the channel

            // send request to port.
            ByteBuf msg = this.getMessage(MSGSIZE);
            for(int i = 0; i < PACKETNUM; i++){
            	ch.writeAndFlush(new DatagramPacket(
            			Unpooled.copiedBuffer(msg),
            			new InetSocketAddress("127.0.0.1", PORT))).sync();
            	
            	Thread.sleep(SLEEPTIME);
            }

            // UDPClientHandler will close the DatagramChannel when a
            // response is received.  If the channel is not closed within 5 seconds,
            // print an error message and quit.
            if (!ch.closeFuture().await(5000)) {
                System.err.println("request timed out.");
            }
        } catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
            group.shutdownGracefully();
        }
    }
    
    private ByteBuf getMessage(int msgSize){
    	if (msgSize <= 0) {
            throw new IllegalArgumentException("msgSize: " + msgSize);
        }
    	
    	ByteBuf firstMessage = Unpooled.buffer(msgSize);
        for (int i = 0; i < firstMessage.capacity(); i ++) {
            firstMessage.writeByte((byte) i);
        }
        
        return firstMessage;
    }

    public static void main(String[] args) throws Exception {
    	for(int i = 0; i < THREADNUM; i++){
    		new UDPClient().start();
    	}
    }
}
