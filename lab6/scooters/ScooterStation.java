public class ScooterStation {
    private int scooters = 10;
    private final int capacity = 10;
    private int refused = 0;

    public synchronized boolean takeScooter() {
        if (scooters > 0) {
            scooters--;
            System.out.println("Пользователь взял самокат. Осталось: " + scooters);
            return true;
        } else {
            refused++;
            System.out.println("Самокатов нет! Пользователь ушел без самоката :(");
            return false;
        }
    }

    public synchronized void refill() {
        int added = capacity - scooters;
        scooters = capacity;
        System.out.println("Пополнение стоянки. Добавлено: " + added + ", всего: " + scooters);
    }

    public synchronized int getRefusedCount() {
        return refused;
    }
}
