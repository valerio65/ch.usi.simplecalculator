package ch.usi.simplejavacalculator;

import org.apache.commons.math3.util.FastMath;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Ignore;

import java.util.Random;
import java.util.stream.Stream;

public class MathOperationsTest {

    @Test

    public void testOneDividedByANumber() {
        Double half = 0.5;
        Double expected = 2.0;
        Double result = MathOperations.oneDevidedBy(half);
        assertEquals(expected, result, 0.0000001);
    }

    @Test(expected = ArithmeticException.class)
    public void testOneDividedByZeroThrowsException() {
        MathOperations.oneDevidedBy(0.0);
    }

    @Test
    public void shouldDivideTwoNumbers() {
        double expected = 4.0;
        Double actual = MathOperations.divide(12.0, 3.0);

        assertEquals(expected, actual, 0.000001);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowIfTriesToDivideBy0() {
        MathOperations.divide(12.0, 0.0);
    }

    //  Minus
    @Test
    public void minusTest1() {
        double expected = 0.0;
        Double actual = MathOperations.minus(30.0, 30.0);
        assertEquals(expected, actual, 0.000000001);
    }

    @Test
    public void minusAssociativeProperty() {
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
    public void minusIdentityProperty() {
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
        assertEquals(expected, MathOperations.tan(-FastMath.PI), 0.000000001);
    }

    @Test
    public void testTanPi4() {
        double actual_pi4 = MathOperations.tan(FastMath.PI / 4);
        double actual_pi34 = MathOperations.tan(3 * FastMath.PI / 4);
        assertEquals(1, actual_pi4, 0.000000001);
        assertEquals(-1, actual_pi34, 0.000000001);
    }

    @Test
    public void cosineRangeTest() {
        double max = 1.0;
        double min = -1.0;
        Double actual = MathOperations.cos(Math.PI / 3);
        assertTrue(min <= actual && actual <= max);
    }

    @Test
    public void cosineValueTest() {
        //cos(X°) == cos(X°+360°)
        double degree1 = Math.PI / 3;
        double oneLap = 2 * Math.PI;
        Double value1 = MathOperations.cos(degree1);
        Double value2 = MathOperations.cos(degree1 + oneLap);
        assertEquals(value1, value2, 0.000000001);

    }

    @Test
    public void squareRootValueTest() {
        Double a = 2.0;
        Double sqrt_Math = Math.sqrt(a);
        Double sqrt_Manual = MathOperations.squareRoot(a);
        Double difference = 0.000000001;
        assertEquals(sqrt_Math.doubleValue(), sqrt_Manual.doubleValue(), difference);
    }

    @Test
    @Ignore
    public void squareRootValueHardTest() {
        // test now fixed
        Double a = 153.9483726;
        Double sqrt_Math = Math.sqrt(a);
        Double sqrt_Manual = MathOperations.squareRoot(a);
        Double difference = 0.000000001;
        assertEquals(sqrt_Math.doubleValue(), sqrt_Manual.doubleValue(), difference);
    }

    @Test
    public void testNaturalLogInf() {
        double expected1 = 2.0;
        Double actual1 = MathOperations.log(Math.exp(2.0));
        assertEquals(expected1, actual1, 0.000000000001);

        double expected2 = Double.NEGATIVE_INFINITY;
        Double actual2 = MathOperations.log(0.0);
        assertEquals(expected2, actual2, 0.000000000001);
    }

    @Test
    public void testNaturalLog1() {
        double expected1 = 0.0;
        Double actual1 = MathOperations.log(1.0);
        assertEquals(expected1, actual1, 0.000000000001);
    }

    @Test
    public void sinPeriodicityTest() {
        //sin(x) == sin(x + 2π)
        double x = Math.PI / 4;

        double y1 = MathOperations.sin(x);
        double y2 = MathOperations.sin(x + 2 * Math.PI);

        assertEquals(y1, y2, Math.ulp(x));
    }

    @Test
    public void sinValuesTest() {
        assertEquals(MathOperations.sin(0.0), 0, 0.000000001);
        assertEquals(MathOperations.sin(Math.PI / 2), 1, 0.000000001);
        assertEquals(MathOperations.sin(Math.PI), 0, 0.000000001);
        assertEquals(MathOperations.sin(3 * Math.PI / 2), -1, 0.000000001);
    }

    @Test
    public void xPowerofy() {
        // power 0 -> 1
        final double delta = 1.0E-7;
        assertEquals(1, MathOperations.xpowerofy(1.05D, 0D), delta);
        assertEquals(1, MathOperations.xpowerofy(-100.1234, 0D), delta);
        // Power 1
        assertEquals(12D, MathOperations.xpowerofy(12D, 1D), delta);
        assertEquals(-1024.516, MathOperations.xpowerofy(-1024.516, 1D), delta);

        // Power 2
        double base = 169.5;
        double expected = base * base;
        assertEquals(expected, MathOperations.xpowerofy(base, 2D), delta);

        // Random integer powers
        Random rand = new Random(123);
        for (int i = 2; i <= 12; i++) {
            base = rand.nextDouble() * 10;
            expected = base;
            for (int j = 1; j < i; j++) {
                expected *= base;
            }
            System.out.println(String.format("Testing %e ^ %d (%e), expected %e", base, i, ((double) i), expected));
            assertEquals(expected, MathOperations.xpowerofy(base, (double) i), delta);
        }
    }

    public void shouldComputeRate() {
        assertEquals(MathOperations.rate(100.0), 1.0, 0.000000001);
        assertEquals(MathOperations.rate(50.0), 0.5, 0.000000001);
        assertEquals(MathOperations.rate(1.0), 0.01, 0.000000001);
    }

    @Test (expected = ArithmeticException.class)
    public void shouldThrowIfTriesToComputeNegativeRate() {
        MathOperations.rate(-50.0);
    }
}
