public class RefillThread extends Thread {
    private final ScooterStation station;
    private final long intervalMillis;
    private volatile boolean running = true;

    public RefillThread(ScooterStation station, long intervalMillis) {
        this.station = station;
        this.intervalMillis = intervalMillis;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(intervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            station.refill();
        }
    }

    public void stopRunning() {
        running = false;
    }
}
