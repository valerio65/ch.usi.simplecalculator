package ch.usi.simplejavacalculator;

import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {
    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy 
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDevidedBy, cos, sin, tan ,log , rate
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            return MathOperations.add(num1,num2);
        }
        if (mode == BiOperatorModes.minus) {
            return MathOperations.minus(num1,num2);
        }
        if (mode == BiOperatorModes.multiply) {
            return MathOperations.multiply(num1,num2);
        }
        if (mode == BiOperatorModes.divide) {
            return MathOperations.divide(num1,num2);
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return MathOperations.xpowerofy(num1,num2);
        }

        // never reach
        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return Double.NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return Double.NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.square) {
            return MathOperations.square(num1);
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            return MathOperations.squareRoot(num1);
        }
        if (newMode == MonoOperatorModes.oneDevidedBy) {
            return MathOperations.oneDevidedBy(num1);
        }
        if (newMode == MonoOperatorModes.cos) {
            return MathOperations.cos(num1);
        }
        if (newMode == MonoOperatorModes.sin) {
            return MathOperations.sin(num1);
        }
        if (newMode == MonoOperatorModes.tan) {
            return MathOperations.tan(num1);
        }
        if (newMode == MonoOperatorModes.log) {
            return MathOperations.log(num1);
        }
        if (newMode == MonoOperatorModes.rate) {
           return MathOperations.rate(num1);
        }


        // never reach
        throw new Error();
    }

}
