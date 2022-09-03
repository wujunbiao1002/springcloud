package com.wjb.springcloud.controller;

import com.wjb.springcloud.entities.CommonResult;
import com.wjb.springcloud.entities.Payment;
import com.wjb.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/payment/feign/timeout")
    public CommonResult create(Payment payment) {
        return new CommonResult<>(220, "成功", paymentFeignService.paymentFeignTimeout());
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
