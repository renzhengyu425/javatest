package com.cloud.feign.service.impl;

import com.cloud.feign.rpc.GetHello;

public class GetHelloImpl implements GetHello
{
    @Override
    public String sayHello()
    {
        return "feign";
    }
}
