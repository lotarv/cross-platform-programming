import java.util.*;

public class Main {
    static String[] varieties = {"Изабелла", "Мускат", "Шардоне", "Лидия", "Каберне", "Ркацители"};
    static String[] colors = {"красный", "черный", "зеленый"};
    static String[] durations = {"неделя", "месяц", "длительное"};
    static String[] types = {"столовый", "винный", "коньячный"};
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrapeBasket<Grape> basket = new GrapeBasket<>();

        System.out.print("Сколько гроздей винограда сгенерировать? ");
        int count = scanner.nextInt();

        // генерация
        for (int i = 0; i < count; i++) {
            Grape g = new Grape(
                    randomElement(varieties),
                    randomElement(colors),
                    randomElement(durations),
                    randomElement(types),
                    1 + Math.round(random.nextDouble() * 10 * 10) / 10.0  // от 1.0 до 11.0
            );
            basket.add(g);
        }

        while (true) {
            System.out.println("\nВыберите группировку:");
            System.out.println("1 - По цвету");
            System.out.println("2 - По сроку хранения");
            System.out.println("3 - По назначению");
            System.out.println("0 - Выход");

            int choice = scanner.nextInt();
            if (choice == 0) break;

            Map<String, List<Grape>> grouped = switch (choice) {
                case 1 -> GrapeGrouper.groupByColor(basket.getAll());
                case 2 -> GrapeGrouper.groupByStorage(basket.getAll());
                case 3 -> GrapeGrouper.groupByType(basket.getAll());
                default -> null;
            };

            if (grouped == null) {
                System.out.println("Неверный выбор");
                continue;
            }

            System.out.print("Сортировать по цене? (y/n): ");
            boolean sort = scanner.next().equalsIgnoreCase("y");

            for (String key : grouped.keySet()) {
                List<Grape> list = grouped.get(key);
                if (sort) GrapeSorter.sortByPrice(list);
                System.out.println("\nГруппа: " + key);
                for (Grape g : list) {
                    System.out.println("  " + g);
                }
            }
        }

        System.out.println("Завершено.");
    }

    private static String randomElement(String[] array) {
        return array[random.nextInt(array.length)];
    }
}
