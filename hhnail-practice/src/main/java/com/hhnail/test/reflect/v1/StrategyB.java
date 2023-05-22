package com.hhnail.test.reflect.v1;

public class StrategyB implements Strategy {
    @Override
    public void execute(Object arg) {
        System.out.println("StrategyB executed with arg: " + arg);
    }
}