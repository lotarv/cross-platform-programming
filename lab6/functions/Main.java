public class Main {
    public static void main(String[] args) {
        int n = 5;
        SharedData data = new SharedData(n);

        Thread t1 = new Thread(new NumeratorWorker(data));
        Thread t2 = new Thread(new DenominatorWorker(data));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nРезультат деления: " + data.numerator + " / " + data.denominator +
                " = " + ((double) data.numerator / data.denominator));
    }
}
