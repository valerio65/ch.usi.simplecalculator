package ch.usi.simplejavacalculator;


import org.apache.commons.math3.exception.MathIllegalNumberException;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.util.FastMath;

public class MathOperations {


    protected static Double add(Double num1, Double num2) {
        return num1 + num2;
    }

    protected static Double minus(Double num1, Double num2) {
        return num1 - num2;
    }
    protected static Double multiply(Double num1, Double num2) {
        return num1 * num2;
    }
    protected static Double divide(Double num1, Double num2) {
        if (Math.abs(num2) <= 0.0000000001) {
            throw new ArithmeticException("Cannot divide by 0");
        }

        return num1 / num2;
    }
    protected static Double xpowerofy(Double num1, Double num2) {
        //TODO
        return 0.0;
    }

    protected static Double square(Double num1) {
        //TODO
        return 0.0;
    }


    protected static Double squareRoot(Double num1) {
        if(num1.doubleValue() < 0.0){
            // Needs to throw exception, but cannot seem to do so
            Double zero = 0.0;
            return zero;
        } else {
            Double guess = 1.0;
            Double inc = 1.0;

            for(int i = 0; i < 100; i++){
                if (Math.pow(guess, 2) < num1.doubleValue()) {
                    inc = inc.doubleValue() / 2;
                    guess += inc.doubleValue();
                } else {
                    inc = inc.doubleValue() / 2;
                    guess -= inc.doubleValue();
                }
            }
            return guess;
        }
    }

    protected static Double oneDevidedBy(Double num1) {
        if (num1 == 0.0) {
            throw new ArithmeticException("You can't divide by 0");
        }
        return 1.0 / num1;

    }

    protected static Double cos(Double num1) {
        return Math.cos(num1);

    }

    protected static Double sin(Double num1) {
        //TODO
        return 0.0;
    }

    protected static Double tan(Double num1) {
        // Tan is not defined for PI/2 + k*PI (for all integers k),
        // but since we deal with finite precision arithmetic this is
        // not an issue (we cannot represent those values exactly) and
        // thus can be safely ignored.
        return FastMath.tan(num1);
    }

    protected static Double log(Double num1) {
        // return FastMath.log(num1);
        return Math.log(num1);
    }

    protected static Double rate(Double num1) {
        //TODO rate num1/100
        return 0.0;
    }



}
