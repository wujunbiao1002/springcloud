package com.wjb.springcloud.controller;

import com.wjb.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public CommonResult getPayment(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk" , CommonResult.class);
    }
}
