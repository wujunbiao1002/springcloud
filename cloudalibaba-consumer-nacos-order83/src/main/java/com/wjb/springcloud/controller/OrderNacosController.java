package com.wjb.springcloud.controller;

import com.wjb.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <b><code>OrderNacosController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/4 16:15.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Value("${service-url.nacos-payment-provider}")
    private String URI;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public CommonResult getById(@PathVariable Integer id){
        return new CommonResult(200,"成功", restTemplate.getForObject(URI+"/payment/nacos/"+id, String.class));
    }
}
