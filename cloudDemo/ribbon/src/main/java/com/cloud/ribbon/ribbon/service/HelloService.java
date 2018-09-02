package com.cloud.ribbon.ribbon.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService
{
    public String sayHello()
    {
        return "你的名字？";//这是第一个测试
    }
}
