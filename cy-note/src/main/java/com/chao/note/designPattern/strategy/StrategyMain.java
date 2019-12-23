package com.chao.note.designPattern.strategy;

/**
 * Created by 15313 on 2019/12/23.
 */
public class StrategyMain {

    public static void main(String[] args) {
        CashContext cashContext = new CashContext("cashReturn");
        double result = cashContext.getResult(1200);
        System.out.println(result);
    }
}
