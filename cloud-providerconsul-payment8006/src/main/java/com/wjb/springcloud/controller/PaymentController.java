package com.wjb.springcloud.controller;


import com.wjb.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <b><code>PaymentController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/2 13:06.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public CommonResult payment()
    {
        return new CommonResult(200,"成功","springcloud with consul: "+serverPort+" "+ UUID.randomUUID());
    }
}
