import java.util.ArrayList;
import java.util.List;

public class GrapeBasket<T extends Grape> {
    private List<T> grapes = new ArrayList<>();

    public void add(T grape) {
        grapes.add(grape);
    }

    public List<T> getAll() {
        return grapes;
    }

    public List<T> sortedByPrice() {
        List<T> sorted = new ArrayList<>(grapes);
        quickSort(sorted, 0, sorted.size() - 1);
        return sorted;
    }

    private void quickSort(List<T> list, int left, int right) {
        if (left >= right) return;

        double pivot = list.get((left + right) / 2).getPrice();
        int i = left;
        int j = right;

        while (i <= j) {
            while (list.get(i).getPrice() < pivot) i++;
            while (list.get(j).getPrice() > pivot) j--;
            if (i <= j) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }

        if (left < j) quickSort(list, left, j);
        if (i < right) quickSort(list, i, right);
    }
}
