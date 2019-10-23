package com.chenfei.io.nio;

import com.chenfei.io.nio.client.NioClient;
import com.chenfei.io.nio.server.NioServer;

import java.util.Scanner;

/**
 * @author chenfei
 * @description
 * @since 2019/5/10
 */
public class Test {

    public static void main(String[] args) throws Exception{
        //运行服务器
        NioServer.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        NioClient.start();
        while(NioClient.sendMsg(new Scanner(System.in).nextLine())){

        }
    }
}
