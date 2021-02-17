package com.cloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/17 12:33
 */
public interface AccountService {
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
