import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

enum StorageDuration {
    WEEK, MONTH, LONG_TERM
}

class Grape {
    private final String variety;
    private final String color;
    private final StorageDuration storage;
    private final String type;
    private final double price;

    public Grape(String variety, String color, StorageDuration storage, String type, double price) {
        this.variety = variety;
        this.color = color;
        this.storage = storage;
        this.type = type;
        this.price = price;
    }

    public String getVariety() { return variety; }
    public String getColor() { return color; }
    public StorageDuration getStorage() { return storage; }
    public String getType() { return type; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Grape{variety='%s', color='%s', storage=%s, type='%s', price=%.2f}",
                variety, color, storage, type, price);
    }
}

public class GrapeProcessor {
    static class PriceRangePredicate implements Predicate<Grape> {
        private final double minPrice;
        private final double maxPrice;

        public PriceRangePredicate(double minPrice, double maxPrice) {
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
        }

        @Override
        public boolean test(Grape grape) {
            return grape.getPrice() >= minPrice && grape.getPrice() <= maxPrice;
        }
    }

    public static void main(String[] args) {
        List<Grape> grapes = Arrays.asList(
                new Grape("Изабелла", "черный", StorageDuration.MONTH, "винный", 2.5),
                new Grape("Мускат", "зеленый", StorageDuration.WEEK, "столовый", 3.0),
                new Grape("Шардоне", "зеленый", StorageDuration.LONG_TERM, "коньячный", 5.5),
                new Grape("Лидия", "красный", StorageDuration.MONTH, "винный", 2.0),
                new Grape("Каберне", "черный", StorageDuration.MONTH, "винный", 4.8),
                new Grape("Ркацители", "зеленый", StorageDuration.WEEK, "столовый", 3.6)
        );

        double minPrice = 2.0;
        double maxPrice = 4.0;

        System.out.println("=== Фильтрация с Predicate ===");
        Predicate<Grape> filter = new PriceRangePredicate(minPrice, maxPrice);
        processGrapes(grapes, filter);

        System.out.println("\n=== Фильтрация с лямбда-функцией ===");
        Predicate<Grape> lambdaFilter = g -> g.getPrice() >= minPrice && g.getPrice() <= maxPrice;
        processGrapes(grapes, lambdaFilter);
    }

    private static void processGrapes(List<Grape> grapes, Predicate<Grape> filter) {
        Map<String, List<Grape>> grouped = grapes.stream()
                .filter(filter)
                .sorted(Comparator.comparing(Grape::getPrice))
                .collect(Collectors.groupingBy(Grape::getType));

        grouped.forEach((type, list) -> {
            System.out.println("\nТип: " + type);
            System.out.println("Гроздья: " + list);

            findPriceExtremes(list);
        });
    }

    private static void findPriceExtremes(List<Grape> grapes) {
        Optional<Grape> min = grapes.stream().min(Comparator.comparingDouble(Grape::getPrice));
        Optional<Grape> max = grapes.stream().max(Comparator.comparingDouble(Grape::getPrice));

        min.ifPresent(g -> System.out.println("Минимальная цена: " + g));
        max.ifPresent(g -> System.out.println("Максимальная цена: " + g));
    }
}

