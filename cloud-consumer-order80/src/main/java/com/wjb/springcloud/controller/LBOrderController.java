package com.wjb.springcloud.controller;

import com.wjb.springcloud.entities.CommonResult;
import com.wjb.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * <b><code>LBOrderController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/3 0:51.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@RestController
@Slf4j
public class LBOrderController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/lb")
    public CommonResult getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");

        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return new CommonResult(200, "成功", restTemplate.getForObject(uri + "/payment/lb", String.class));

    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public CommonResult paymentZipkin() {
        return new CommonResult(200, "成功", restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class));
    }
}
