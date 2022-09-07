package com.wjb.springcloud.controller;


import com.wjb.springcloud.domain.Order;
import com.wjb.springcloud.entities.CommonResult;
import com.wjb.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @PostMapping("/order/create")
    public CommonResult create(@RequestBody Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
