package com.marphain.demo.communication.netty.utils;

import java.io.File;

/**
 * 
 * 　常量定义类
 * @author m13430
 * @date 2015年7月31日
 * @since com.hytera.lte.nm
 */
public interface IConstants
{
    String HOST_NAME = "M13430";

    String CLIET_ADDR = "192.168.29.88";

    String SERVER_ADDR = "192.168.47.33";

    boolean USE_SSL = true;

    String KEYSTORE_PASS = "changeit";

    String KEY_PASS = "changeit";

    String SERVER_KEYSTORE_PATH = "src" + File.separator + "serverstore";

    String CLIENT_KEYSTORE_PATH = "src" + File.separator + "clientstore";

    int CLIENT_PORT = 0; // 0 means system will select free port.

    int NODE_SERVER_PORT = 8888;

    int SYS_SERVER_PORT = 9999;

    int MAX_CONNECTIONS = 1;

    int SLEEP_TIME_MILLIS = 3;

    int SLEEP_TIME_NANOS = 0;

    int SND_NUM = 1;

    int MSG_SIZE = 1024;

    int QUEUE_SIZE = 50000;

    int RCVBUF_SIZE = 50 * 1024;

}
