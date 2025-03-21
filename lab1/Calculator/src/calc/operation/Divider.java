package calc.operation;

public class Divider {
    public static float divide(float num1, float num2){
        if (num2 == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return num1 / num2;
    }
}
