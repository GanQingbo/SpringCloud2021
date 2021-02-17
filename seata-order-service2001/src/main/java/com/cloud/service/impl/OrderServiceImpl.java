package com.cloud.service.impl;

import com.cloud.dao.OrderDao;
import com.cloud.domain.Order;
import com.cloud.service.AccountService;
import com.cloud.service.OrderService;
import com.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/17 10:18
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name="my-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("===新建订单===");
        orderDao.create(order);
        log.info("===开始扣减库存===");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("===账户余额扣减===");
        accountService.decrease(order.getUserId(),order.getMoney());

        //修改订单状态，从0到1
        log.info("===修改订单状态===");
        orderDao.update(order.getUserId(),0);
        log.info("===下订单结束===");
    }
}
