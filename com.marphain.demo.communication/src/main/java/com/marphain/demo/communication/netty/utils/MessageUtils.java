package com.marphain.demo.communication.netty.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class MessageUtils
{
    private static long initialTime = 0;

    private static AtomicInteger counter = new AtomicInteger();

    private static byte[] messages = null;

    /**
     * 向服务端发送的消息
     * @param size 消息大小
     * @return
     */
    public static byte[] getMessage()
    {
        if (messages == null)
        {
            messages = new byte[IConstants.MSG_SIZE];
            
            // 定义消息的长度（偏移量为2，占2字节）
            messages[2] = 4;
            messages[IConstants.MSG_SIZE - 1] = ',';
        }
        
        return messages;
    }

    /**
     * 以ms为单位
     * @return
     */
    public static long getTime()
    {
        long time = 0;

        if (initialTime == 0)
        {
            initialTime = System.currentTimeMillis();
        }
        else
        {
            time = System.currentTimeMillis() - initialTime;
        }

        return time;
    }

    /**
     * 获取函数调用次数
     * @return
     */
    public static int getCounter()
    {
        return counter.incrementAndGet();
    }

}
