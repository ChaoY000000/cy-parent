package com.chao.note.designPattern.strategy;

import java.util.Map;

/**
 * Created by 15313 on 2019/12/23.
 */
public class CashContext {

    private CashSuper cashSuper;

    public CashContext(String className , Map map) {
        try {
            Class.forName(" "+className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CashContext(String type) {
        switch (type){
            case "cashNormal":
                this.cashSuper = new CashNormal();
                break;
            case "cashRebate":
                this.cashSuper = new CashRebate(0.8);
                break;
            case "cashReturn":
                this.cashSuper = new CashReturn(400,50);
                break;
        }
    }

    public double getResult(double money){
        return cashSuper.acceptCash(money);
    }
}
