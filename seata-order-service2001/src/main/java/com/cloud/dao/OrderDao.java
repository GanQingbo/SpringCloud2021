package com.cloud.dao;

import com.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/16 19:20
 */
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);
    //修改订单状态
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}
