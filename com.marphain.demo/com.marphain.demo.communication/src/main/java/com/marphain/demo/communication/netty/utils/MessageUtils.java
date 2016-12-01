package com.marphain.demo.communication.netty.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class MessageUtils
{
    private static long initialTime = 0;

    private static AtomicInteger counter = new AtomicInteger();

    private static byte[] messages = null;

    public static byte[] getMessage()
    {
        if (messages == null)
        {
            messages = new byte[IConstants.MSG_SIZE];
            
            messages[2] = 4;
            messages[IConstants.MSG_SIZE - 1] = ',';
        }
        
        return messages;
    }

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

    public static int getCounter()
    {
        return counter.incrementAndGet();
    }

}
