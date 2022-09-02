package com.wjb.springcloud.service.impl;

import com.wjb.springcloud.dao.PaymentDao;
import com.wjb.springcloud.entities.Payment;
import com.wjb.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <b><code>PaymentServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/2 13:04.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
