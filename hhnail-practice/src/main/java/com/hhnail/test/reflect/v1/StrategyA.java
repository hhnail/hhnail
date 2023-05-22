package com.hhnail.test.reflect.v1;

public class StrategyA implements Strategy {
    @Override
    public void execute(Object arg) {

        System.out.println("StrategyA executed with arg: " + arg);
    }

    // public void execute() {
    //
    //     System.out.println("StrategyA executed with arg: ");
    // }
}