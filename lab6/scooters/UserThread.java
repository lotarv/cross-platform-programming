public class UserThread extends Thread {
    private final ScooterStation station;
    private final long intervalMillis;
    private volatile boolean running = true;

    public UserThread(ScooterStation station, long intervalMillis) {
        this.station = station;
        this.intervalMillis = intervalMillis;
    }
    @Override
    public void run() {
        while(running) {
            station.takeScooter();
            try {
                Thread.sleep(intervalMillis);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopRunning() {
        running = false;
    }
}
