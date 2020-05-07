package com.zelex.handrpc;

public class HelloServiceImpl implements IHelloService{
    @Override
    public String sayHello(String content) {
        System.out.println("Request in sayHello:"+content);
        return "Say Hello:"+content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("Request in saveUser:"+user);
        return "Success";
    }
}
