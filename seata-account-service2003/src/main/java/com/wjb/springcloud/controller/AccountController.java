package com.wjb.springcloud.controller;

import com.wjb.springcloud.entities.CommonResult;
import com.wjb.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <b><code>AccountController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/6 14:41.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@Slf4j
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam Long userId, @RequestParam BigDecimal money){

        accountService.decrease(userId, money);
        return new CommonResult(200,"扣减账户余额成功");
    }
}
