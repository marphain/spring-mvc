package com.marphain.demo.communication.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marphain.demo.communication.netty.utils.MessageUtils;

/**
 * 
 * If a ChannelHandler is annotated with the @Sharable annotation, it means you
 * can create an instance of the handler just once and add it to one or more
 * ChannelPipelines multiple times without a race condition.
 */
@Sharable
public class MsgRecieveHandler extends ChannelInboundHandlerAdapter
{
    private final Logger logger = LoggerFactory
            .getLogger(MsgRecieveHandler.class);

    private static AtomicInteger msgSize = new AtomicInteger();
    
    private volatile boolean isInitial = true;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception
    {
        if (isInitial)
        {
            MessageUtils.getTime();
            isInitial = false;
        }
        ByteBuf msgBuf = (ByteBuf) msg;
        msgSize.addAndGet(msgBuf.readableBytes());
        
        byte[] dst = new byte[msgBuf.readableBytes()];
        msgBuf.readBytes(dst);
        System.out.println(new String(dst));
        
        //每收到1W条消息，打印一次结果
        if(msgSize.get() % (10000 * 1024) == 0){
            System.out.println("NODE: size of msg recieved is: " + msgSize.get() 
                    + ", the total time is: " + MessageUtils.getTime());

            logger.info("NODE: size of msg recieved is: {}, the total time is: {}.", msgSize.get(), MessageUtils.getTime());
        }

        //则将接收到的消 息入队，准备发送给系统通信层
//      ScanMsgQueueTask.addMsg(msgBuf);
        
//        TCPClient.addMsg(msgBuf);
        
        // if (msg instanceof String) {
        // ByteBuf msgSend =
        // Unpooled.copiedBuffer("hello client!#_".getBytes());
        // ctx.write(msgSend);
        // System.out.println((String)msg);
        // }
        // else {
        // nodeMsgSize += ((ByteBuf)msg).readableBytes();
        // // ((ByteBuf)msg).release();
        // // ReferenceCountUtil.release(msg);
        // long time = MessageUtils.getTime();
        // System.out.println("size of message is: " + nodeMsgSize +
        // ", the total time is: " + time);
        // }

        // 使用内存池分配器创建直接内存缓冲区性能优于使用非内存池分配器创建直接内存缓冲区
        // ByteBufAllocator allocator = ctx.alloc();
        // ByteBuf buf = ((UnpooledByteBufAllocator)allocator).buffer();
        // buf.capacity(1024);//设置缓存池大小
        // buf.writeBytes("hello".getBytes());//增加writeindex
        // ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception
    {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
    {
        // Close the connection when an exception is raised.
        logger.warn("Unexpected exception from downstream.", cause);
        ctx.disconnect();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        super.channelInactive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception
    {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception
    {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx)
            throws Exception
    {
        super.channelWritabilityChanged(ctx);
    }

    /**
     * 处理用户自定义事件
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
            throws Exception
    {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception
    {
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception
    {
        super.handlerRemoved(ctx);
    }

    @Override
    public boolean isSharable()
    {
        return super.isSharable();
    }

}
