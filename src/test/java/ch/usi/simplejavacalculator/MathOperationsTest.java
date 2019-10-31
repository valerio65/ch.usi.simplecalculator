package ch.usi.simplejavacalculator;

import org.apache.commons.math3.util.FastMath;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Ignore;

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

    // Tan tests
    @Test
    public void testTanZero() {
        double expected = 0.0;
        assertEquals(expected, MathOperations.tan(0.0), 0.000000001);
        assertEquals(expected, MathOperations.tan(FastMath.PI), 0.000000001);
        assertEquals(expected, MathOperations.tan(2 * FastMath.PI), 0.000000001);
        assertEquals(expected, MathOperations.tan(- FastMath.PI), 0.000000001);
    }

    @Test
    public void testTanPi4() {
        double actual_pi4 = MathOperations.tan(FastMath.PI / 4);
        double actual_pi34 = MathOperations.tan(3 * FastMath.PI / 4);
        assertEquals(1, actual_pi4, 0.000000001);
        assertEquals(-1, actual_pi34, 0.000000001);
    }

    @Test
    public void cosineRangeTest(){
        double max = 1.0;
        double min = -1.0;
        Double actual = MathOperations.cos(Math.PI/3);
        assertTrue( min <= actual && actual <= max);
    }

    @Test
    public void cosineValueTest(){
        //cos(X°) == cos(X°+360°)
        double degree1 = Math.PI/3;
        double oneLap = 2*Math.PI;
        Double value1 = MathOperations.cos(degree1);
        Double value2 = MathOperations.cos(degree1+oneLap);
        assertEquals(value1, value2, 0.000000001);

    }

    @Test
    public void squareRootValueTest(){
        Double a = 2.0;
        Double sqrt_Math = Math.sqrt(a);
        Double sqrt_Manual = MathOperations.squareRoot(a);
        Double difference = 0.000000001;
        assertEquals(sqrt_Math.doubleValue(), sqrt_Manual.doubleValue(), difference);
    }

    @Test
    @Ignore
    public void squareRootValueHardTest(){
        Double a = 153.9483726;
        Double sqrt_Math = Math.sqrt(a);
        Double sqrt_Manual = MathOperations.squareRoot(a);
        Double difference = 0.000000001;
        assertEquals(sqrt_Math.doubleValue(), sqrt_Manual.doubleValue(), difference);
    }
}
