package com.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/17 11:34
 */
@Mapper
public interface StorageDao {
    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
