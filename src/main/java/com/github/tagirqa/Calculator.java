package com.github.tagirqa;

public class Calculator {

    public static int getAddition(int a, int b) {
        return Math.addExact(a, b);
    }

    public static int getSubtraction(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public static int getMultiplication(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public static int getDivision(int a, int b) {
        return Math.floorDiv(a, b);
    }

    /**
     * Возвращает процент a от b
     */
    public static double getPercent(int a, double b) {
        return b / 100 * a;
    }

    /**
     * Возвращает a в степени b
     */
    public static double getExponentiation(int a, int b) {
        return Math.pow(a, b);
    }

    /**
     * Возвращает модуль a
     */
    public static int getAbs(int a) {
        return Math.abs(a);
    }

}
