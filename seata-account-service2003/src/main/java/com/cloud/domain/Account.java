package com.cloud.domain;

import java.math.BigDecimal;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/17 12:03
 */
public class Account {
    private Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    public BigDecimal getResidue() {
        return residue;
    }

    public void setResidue(BigDecimal residue) {
        this.residue = residue;
    }

    public Account() {
    }

    public Account(Long id, Long userId, BigDecimal total, BigDecimal used, BigDecimal residue) {
        this.id = id;
        this.userId = userId;
        this.total = total;
        this.used = used;
        this.residue = residue;
    }
}
