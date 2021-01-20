package com.cloud.dao;

import com.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author G
 * @version 1.0
 * @date 2021/1/20 11:08
 */
@Mapper
public interface PaymentDao {
    //插入返回值一般为int
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
