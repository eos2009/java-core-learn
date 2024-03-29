package com.chenfei.io.nio.client;

/**
 * @author chenfei
 * @description
 * @since 2019/5/10
 */
public class NioClient {
    private static String DEFAULT_HOST = "127.0.0.1";
    private static int DEFAULT_PORT = 12345;
    private static NioClientHandler clientHandle;
    public static void start(){
        start(DEFAULT_HOST,DEFAULT_PORT);
    }
    public static synchronized void start(String ip,int port){
        if(clientHandle!=null){
            clientHandle.stop();
        }
        clientHandle = new NioClientHandler(ip,port);
        new Thread(clientHandle,"Server").start();
    }

    /**
     * 向服务器发送消息
     * @param msg
     * @return
     * @throws Exception
     */
    public static boolean sendMsg(String msg) throws Exception{
        if(msg.equals("q")) {
            return false;
        }
        clientHandle.sendMsg(msg);
        return true;
    }
    public static void main(String[] args){
        start();
    }

}
