package com.wjb.springcloud.service;

import com.wjb.springcloud.domain.Order;

/**
 * <b><code>OrderService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/7 21:28.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
public interface OrderService {
    void create(Order order);
}
