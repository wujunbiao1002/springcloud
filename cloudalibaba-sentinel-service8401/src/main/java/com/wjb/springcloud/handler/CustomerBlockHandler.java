package com.wjb.springcloud.handler;

import com.sun.deploy.security.BlockedException;
import com.wjb.springcloud.entities.CommonResult;

/**
 * <b><code>CustomerBlockHandler</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/5 21:52.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
public class CustomerBlockHandler {
    public static CommonResult  customerBlockHandler(BlockedException blockedException){
        return new CommonResult(4444,"按客戶自定义,global customerBlockHandler----1");
    }
}
