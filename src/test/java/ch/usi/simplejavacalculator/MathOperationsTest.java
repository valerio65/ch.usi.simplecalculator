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

//  Minus
    @Test
    public void minusTest1(){
        double expected = 0.0;
        Double actual = MathOperations.minus(30.0, 30.0);
        assertEquals(expected, actual, 0.000000001);
    }

    @Test
    public void minusAssociativeProperty(){
//      (3 - 4) - 2 ≠ 3 - (4 - 2)
        double first_expected = -3.0;
        double second_expected = 1.0;

        double first_actual = MathOperations.minus(MathOperations.minus(3.0, 4.0), 2.0);
        double second_actual = MathOperations.minus(3.0, MathOperations.minus(4.0, 2.0));

        assertNotEquals(first_actual, second_actual, 0.000000001);
        assertEquals(first_actual, first_expected, 0.000000001);
        assertEquals(second_actual, second_expected, 0.000000001);
    }

    @Test
    public void minusIdentityProperty(){
        double expected = 3.0;
        Double actual = MathOperations.minus(3.0, 0.0);
        assertEquals(expected, actual, 0.000000001);
    }

}
