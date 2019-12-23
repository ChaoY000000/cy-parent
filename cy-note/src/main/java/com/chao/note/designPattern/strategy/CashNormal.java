package com.chao.note.designPattern.strategy;

/**
 * Created by 15313 on 2019/12/23.
 */
public class CashNormal implements CashSuper {
    @Override
    public double acceptCash(double money) {
        //原价
        return money;
    }
}
