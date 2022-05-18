package com.dsa.interview.questions.integer_reversion;

public class Runner {
    public static void main(String[] args) {
        IntegerReversion integerReversion = new IntegerReversion();
        System.out.println(integerReversion.integerReversion(1234));
        System.out.println(integerReversion.integerReversion(12345));
        System.out.println(integerReversion.integerReversion(1000));
        System.out.println(integerReversion.integerReversionOptimized(1234));
        System.out.println(integerReversion.integerReversionOptimized(12345));
        System.out.println(integerReversion.integerReversionOptimized(1000));
    }
}
