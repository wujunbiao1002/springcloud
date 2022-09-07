package com.wjb.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wjb.springcloud.entities.CommonResult;
import com.wjb.springcloud.entities.Payment;
import com.wjb.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b><code>RateLimitController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/5 21:51.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource/{id}")
    @SentinelResource(value = "byResource", blockHandler = "handleException", fallback = "fallbackMethod")
    public CommonResult byResource(@PathVariable String id) {
        if ("1".equals(id)) {

            int i = 10 / 0;
        }
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(String id, BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用" + id);
    }

    public CommonResult fallbackMethod(String id, Throwable throwable) {
        return new CommonResult(444, throwable.getClass().getCanonicalName() + "\t 服务异常" + id);
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "customerBlockHandler")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}