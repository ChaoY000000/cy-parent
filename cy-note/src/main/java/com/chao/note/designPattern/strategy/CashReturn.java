package com.chao.note.designPattern.strategy;

/**
 * Created by 15313 on 2019/12/23.
 */
public class CashReturn implements CashSuper {

    private double moneyCondition = 0.0d;
    private double moneyRturn = 0.0d;
    public CashReturn(double moneyCondition , double moneyRturn) {
        this.moneyCondition = moneyCondition;
        this.moneyRturn = moneyRturn;
    }

    @Override
    public double acceptCash(double money) {
        //满300返100
        return money - Math.floor(money / moneyCondition) * moneyRturn;
    }
}
