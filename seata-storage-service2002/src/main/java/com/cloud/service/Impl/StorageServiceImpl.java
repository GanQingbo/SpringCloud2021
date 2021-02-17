package com.cloud.service.Impl;

import com.cloud.dao.StorageDao;
import com.cloud.service.StorageService;
import org.apache.ibatis.annotations.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author G
 * @version 1.0
 * @date 2021/2/17 11:45
 */
@Service
public class StorageServiceImpl implements StorageService {
    private static final Logger LOGGER= LoggerFactory.getLogger(StorageServiceImpl.class);
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("***storage扣减库存***");
        storageDao.decrease(productId, count);
    }
}
