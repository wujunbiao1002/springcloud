package com.wjb.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * <b><code>PaymentService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/3 1:48.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@Service
public class PaymentService {
    public String paymentInfoOK(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfoOK,id:  " + id + "\t" + "O(∩_∩)O哈哈~";
    }
    /**
     * 配置服务降级
     * 出现原因：服务端处理时间过长超时，程序运行异常，服务熔断触发服务降级，线程池/信号量打满也会导致服务降级
     * 服务处理超时，最多服务处理时间3s
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000")
    })
    public String paymentInfoTimeOut(Integer id) {
        long l = System.currentTimeMillis();
        try {
            TimeUnit.MILLISECONDS.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池:  " + Thread.currentThread().getName() + " id:  " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时(秒): " + (System.currentTimeMillis() - l) / 1000;
    }

    private String paymentInfoTimeOutHandle(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  8001系统繁忙或者运行报错，请稍后再试,id:  " + id + "\t" + "o(╥﹏╥)o";
    }
    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback"
//            ,commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器，默认开启
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数，默认20次
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期，默认5秒
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸，默认50%
//    }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }


}
