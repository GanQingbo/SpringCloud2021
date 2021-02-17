package com.cloud.service.Impl;

import com.cloud.dao.AccountDao;
import com.cloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/17 12:46
 */
@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER= LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("+++accoun扣减账户余额开始+++");
        accountDao.decrease(userId, money);
    }
}
