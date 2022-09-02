package com.wjb.springcloud.controller;

import com.wjb.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsulController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public CommonResult paymentInfo() {
        return new CommonResult(200, "成功", restTemplate.getForObject(INVOKE_URL + "/payment/consul", CommonResult.class));
    }
}
