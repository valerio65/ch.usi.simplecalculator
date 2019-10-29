package ch.usi.simplejavacalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathOperationsTest {

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