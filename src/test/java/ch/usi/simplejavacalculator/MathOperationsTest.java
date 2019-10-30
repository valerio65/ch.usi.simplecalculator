package ch.usi.simplejavacalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathOperationsTest {

    @Test

    public void testOneDividedByANumber() {
        Double half = 0.5;
        Double expected = 2.0;
        Double result = MathOperations.oneDevidedBy(half);
        assertEquals(expected, result, 0.0000001);
    }

    @Test (expected = ArithmeticException.class)
    public void testOneDividedByZeroThrowsException() {
        MathOperations.oneDevidedBy(0.0);
    }

    @Test
    public void shouldDivideTwoNumbers() {
        double expected = 4.0;
        Double actual = MathOperations.divide(12.0, 3.0);

        assertEquals(expected, actual, 0.000001);
    }

    @Test (expected = ArithmeticException.class)
    public void shouldThrowIfTriesToDivideBy0() {
        MathOperations.divide(12.0, 0.0);
    }
}