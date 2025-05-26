public class NumeratorWorker implements Runnable {
    private final SharedData data;

    public NumeratorWorker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.numerator = 1;
        for (int i = 2; i <= data.n; i++) {
            data.numerator *= i;
        }

        for (int i = 0; i < data.n; i++) {
            synchronized(data) {
                while(!data.turnA) {
                    try {
                        data.wait();
                    } catch( InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("A");
                data.turnA = false;
                data.notifyAll();
            }
        }
    }
}
