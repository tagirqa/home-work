package com.github.tagirqa;

public class Calculator {

    public static double getAddition(double a, double b) {
        return a + b;
    }

    public static double getSubtraction(double a, double b) {
        return a - b;
    }

    public static double getMultiplication(double a, double b) {
        return a * b;
    }

    public static double getDivision(double a, double b) {
        return a / b;
    }

    /*
    Возвращает процент a от b
     */
    public static double getPercent(double a, double b) {
        return b / 100 * a;
    }

    /*
    Возвращает a в степени b
     */
    public static double getExponentiation(double a, int b) {
        return Math.pow(a, b);
    }

    /*
    Возвращает модуль a
     */
    public static double getAbs(double a) {
        return Math.abs(a);
    }

}
