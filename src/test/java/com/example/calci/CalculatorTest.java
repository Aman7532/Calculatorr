package com.example.calci;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    private final calculator Calculator = new calculator();

    @Test
    public void testFindSquareRoot() {
        assertEquals(2.0, Calculator.findSquareRoot(4.0), 0.001);
    }

    @Test
    public void testFindFactorial() {
        assertEquals(24.0, Calculator.findFactorial(4.0), 0.001);
    }

    @Test
    public void testFindLog() {
        assertEquals(1.61, Calculator.findLog(5.0), 0.001);
    }

    @Test
    public void testFindPower() {
        assertEquals(8.0, Calculator.findPower(2.0, 3.0), 0.001);
    }
}
