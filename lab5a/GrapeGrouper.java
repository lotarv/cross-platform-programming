import java.util.*;

public class GrapeGrouper {

    public static Map<String, List<Grape>> groupByColor(List<Grape> grapes) {
        Map<String, List<Grape>> result = new HashMap<>();
        for (Grape grape : grapes) {
            String key = grape.getColor();
            if (!result.containsKey(key)) result.put(key, new ArrayList<>());
            result.get(key).add(grape);
        }
        return result;
    }

    public static Map<String, List<Grape>> groupByStorage(List<Grape> grapes) {
        Map<String, List<Grape>> result = new HashMap<>();
        for (Grape grape : grapes) {
            String key = grape.getStorageDuration();
            if (!result.containsKey(key)) result.put(key, new ArrayList<>());
            result.get(key).add(grape);
        }
        return result;
    }

    public static Map<String, List<Grape>> groupByType(List<Grape> grapes) {
        Map<String, List<Grape>> result = new HashMap<>();
        for (Grape grape : grapes) {
            String key = grape.getType();
            if (!result.containsKey(key)) result.put(key, new ArrayList<>());
            result.get(key).add(grape);
        }
        return result;
    }
}
