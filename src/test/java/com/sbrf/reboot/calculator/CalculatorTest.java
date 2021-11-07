package com.sbrf.reboot.calculator;

import com.github.tagirqa.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, Calculator.getAddition(4, 5));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, Calculator.getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20, Calculator.getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(3, Calculator.getDivision(9, 3));
    }

    @Test
    void classHasSevenMethods(){
        assertEquals(7,Calculator.class.getMethods().length-Object.class.getMethods().length);
    }

    @Test
    void getPercent() {
        assertEquals(20, Calculator.getPercent(100, 20));
    }

    @Test
    void getExponentiation() {
        assertEquals(27, Calculator.getExponentiation(3, 3));
    }

    @Test
    void getAbs() {
        assertEquals(5, Calculator.getAbs(-5));
    }
}