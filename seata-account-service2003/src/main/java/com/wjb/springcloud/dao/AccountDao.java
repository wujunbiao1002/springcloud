package com.wjb.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <b><code>AccountDao</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/6 14:30.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@Mapper
public interface AccountDao {

    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
