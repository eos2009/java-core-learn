package com.chenfei.io.nio;

import com.chenfei.io.nio.client.NioClient;

import java.util.Scanner;

/**
 * @author chenfei
 * @description
 * @since 2019/5/10
 */
public class TestClient {

    public static void main(String[] args) throws Exception{
        //运行客户端
        NioClient.start();
        while(NioClient.sendMsg(new Scanner(System.in).nextLine())){

        }
    }
}
