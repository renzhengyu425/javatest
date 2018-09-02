package com.cloud.feign.service;

import com.cloud.feign.rpc.GetHello;
import com.cloud.feign.service.impl.GetHelloImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService
{
    @Autowired
    private GetHello getHello;

    public String sayHello()
    {
        return getHello.sayHello();
    }
}
