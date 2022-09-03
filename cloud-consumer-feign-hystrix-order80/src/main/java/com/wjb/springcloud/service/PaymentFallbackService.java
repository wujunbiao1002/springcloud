package com.wjb.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * <b><code>PaymentFallbackService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/3 14:17.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfoOK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfoTimeOut ,o(╥﹏╥)o";
    }
}
