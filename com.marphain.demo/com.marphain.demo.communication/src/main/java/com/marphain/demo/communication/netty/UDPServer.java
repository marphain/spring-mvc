/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.marphain.demo.communication.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import com.marphain.demo.communication.netty.handler.UDPServerHandler;

/**
 * A UDP server that recieve messages from
 * {@link UDPClient}.
 *
 */
public class UDPServer {

	public static final int REMSIZE = 1024 * 1024;
	
    private final int port;

    public UDPServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
    	//number of threads is 8.
        EventLoopGroup group = new NioEventLoopGroup(8);
        
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioDatagramChannel.class)
             .option(ChannelOption.SO_BROADCAST, false)
             .option(ChannelOption.SO_RCVBUF, REMSIZE * 200)
             .handler(new UDPServerHandler());

            b.bind(port).sync().channel().closeFuture().await();
        } finally {
            group.shutdownGracefully();
        }
    }

    //input the port to be listened.default is 8888.
    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8888;
        }
        
        new UDPServer(port).run();
    }
}
