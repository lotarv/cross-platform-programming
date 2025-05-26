public class DenominatorWorker implements Runnable {
    private final SharedData data;

    public DenominatorWorker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.denominator = 0;
        for (int i = 0; i <= data.n; i++) {
            data.denominator += data.n + i;
        }

        for (int i = 0; i < data.n; i++) {
            synchronized(data) {
                while (data.turnA) {
                    try {
                        data.wait();
                    } catch(InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("B");
                data.turnA = true;
                data.notifyAll();
            }
        }
    }

}
