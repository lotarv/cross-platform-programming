package calc;

import calc.operation.Adder;
import calc.operation.Divider;
import calc.operation.Modder;
import calc.operation.Multiplier;
import calc.operation.Substractor;
public class Calculator {
    public int sum(int... a) {
        Adder adder = new Adder();
        for (int i : a) {
            adder.add(i);
        }
        return adder.getSum();
    }
    public int mult(int... a) {
        Multiplier multiplier = new Multiplier();
        for (int i : a) {
            multiplier.multiply(i);
        }
        return multiplier.getMult();
    }

    public float divide(float a, float b) {
        return Divider.divide(a,b);
    }

    public int sub(int a, int b) {
        return Substractor.substract(a, b);
    }

    public float mod(float a, float b){
        return Modder.mod(a,b);
    }
}
