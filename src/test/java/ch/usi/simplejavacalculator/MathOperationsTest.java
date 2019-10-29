package ch.usi.simplejavacalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathOperationsTest {


    @Test
    public void testMinus1(){
// sum 10 - 5
        Double expected = 5.0;
        Double actual = MathOperations.minus(10.0,5.0);
        assertEquals(expected,actual,0.00000000001);
    }





}