package com.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/17 12:06
 */
@Mapper
public interface AccountDao {
    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
