package com.zelex.handrpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {
    ExecutorService executorService=Executors.newCachedThreadPool();
    public void publisher(Object service,int port){
        System.out.println("开始执行publish方法");
        ServerSocket serverSocket=null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                System.out.println("进入while循环");
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
