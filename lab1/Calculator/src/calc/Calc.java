package calc;

public class Calc {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Calculator calc = new Calculator();
        System.out.println("2+2 = " + calc.sum(2, 2));
        System.out.println("5 * 5 = " + calc.mult(5,5));
        System.out.println("12 / 4 = " + calc.divide(12, 4));
        System.out.println("Попытка деления на ноль:");
        try {
            System.out.println("12 / 0 = " + calc.divide(12,0));
        }
        catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("1000 - 7 = " + calc.sub(1000, 7));
        System.out.println("(float) 54.3 % 8 =  " + calc.mod(54.3f, 8));

        System.out.println("Нажмите Enter для выхода...");
        new java.util.Scanner(System.in).nextLine();
    }
}