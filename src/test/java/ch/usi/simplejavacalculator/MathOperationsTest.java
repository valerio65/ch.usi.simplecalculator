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

    @Test
    public void testOneDividedByZeroThrowsException() {
        Double zero = 0.0;
        try {
            MathOperations.oneDevidedBy(zero);
            // If the exception isn't thrown, the test should fail
            fail("oneDevidedBy 0.0 should throw an exception");
        } catch (Exception e) {
            assertEquals(ArithmeticException.class, e.getClass());
        }
    }
}