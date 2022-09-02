package com.wjb.springcloud.service;

import com.wjb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <b><code>PaymentService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/2 13:03.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
