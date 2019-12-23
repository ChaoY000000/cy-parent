package com.chao.note.designPattern.strategy;

/**
 * Created by 15313 on 2019/12/23.
 */
public class CashRebate implements CashSuper {

    private double moneyRabate = 1d;
    public CashRebate(double moneyRabate) {
        this.moneyRabate = moneyRabate;
    }

    @Override
    public double acceptCash(double money) {
        //打八折
        return money * moneyRabate;
    }
}
