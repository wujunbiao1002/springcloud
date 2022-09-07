package com.wjb.springcloud.service;

import java.math.BigDecimal;

/**
 * <b><code>AccountService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/6 14:39.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}
