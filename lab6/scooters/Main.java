public class Main {
    public static void main(String[] args) throws InterruptedException {
        ScooterStation station = new ScooterStation();

        long userInterval = 1000;   // 1 сек = 10 минут
        long refillInterval = 10000; // 24 сек = 4 часа

        UserThread user = new UserThread(station, userInterval);
        RefillThread refill = new RefillThread(station, refillInterval);

        user.start();
        refill.start();

        Thread.sleep(30000); 

        user.stopRunning();
        refill.stopRunning();

        user.join();
        refill.join();

        System.out.println("Пользователи, не получившие самокат: " + station.getRefusedCount());
    }
}
