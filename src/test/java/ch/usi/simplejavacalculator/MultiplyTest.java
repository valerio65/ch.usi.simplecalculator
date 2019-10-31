package ch.usi.simplejavacalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyTest {

    @Test
    public void multiplyBy0ShouldPass(){
        assertEquals(MathOperations.multiply(0.0, Math.PI),0, 0);
        assertEquals(0, MathOperations.multiply(0.0, Math.PI), 0);

    }

    @Test
    public void multiplyShouldPass(){
        assertEquals(MathOperations.multiply(Math.PI, Math.PI), Math.pow(Math.PI, 2), 0.000000001);
    }

}
