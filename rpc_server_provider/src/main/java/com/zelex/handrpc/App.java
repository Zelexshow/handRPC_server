package com.zelex.handrpc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IHelloService helloService = new HelloServiceImpl();
        RpcProxyServer proxyServer = new RpcProxyServer();
        proxyServer.publisher(helloService,8088);
    }
}
