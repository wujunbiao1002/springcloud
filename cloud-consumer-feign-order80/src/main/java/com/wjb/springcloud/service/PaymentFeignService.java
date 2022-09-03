package com.wjb.springcloud.service;

import com.wjb.springcloud.entities.CommonResult;
import com.wjb.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <b><code>PaymentFeignService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/3 1:22.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@Service
@FeignClient(value = "cloud-provider-payment")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
