package com.wjb.springcloud.dao;

import com.wjb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <b><code>PaymentDao</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/2 12:49.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
