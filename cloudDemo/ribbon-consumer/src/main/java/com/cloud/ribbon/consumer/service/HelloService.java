package com.cloud.ribbon.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService
{
    @Autowired
    private RestTemplate restTemplate;//注入restTemplate

    public String sayHello()
    {
//        return "你的名字？？？!!!!";//这是第一个测试
        //通过rest调用 调用provider服务
        return restTemplate.getForObject("http://ribbon-provider/hello?name=renlei&age=28", String.class);
    }
}
