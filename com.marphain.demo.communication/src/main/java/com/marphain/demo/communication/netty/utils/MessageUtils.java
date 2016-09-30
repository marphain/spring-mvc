package com.marphain.demo.communication.netty.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class MessageUtils
{
    private static long initialTime = 0;

    private static AtomicInteger counter = new AtomicInteger();

    private static byte[] messages = null;

    /**
     * �����˷��͵���Ϣ
     * @param size ��Ϣ��С
     * @return
     */
    public static byte[] getMessage()
    {
        if (messages == null)
        {
            messages = new byte[IConstants.MSG_SIZE];
            
            // ������Ϣ�ĳ��ȣ�ƫ����Ϊ2��ռ2�ֽڣ�
            messages[2] = 4;
            messages[IConstants.MSG_SIZE - 1] = ',';
        }
        
        return messages;
    }

    /**
     * ��msΪ��λ
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
     * ��ȡ�������ô���
     * @return
     */
    public static int getCounter()
    {
        return counter.incrementAndGet();
    }

}
