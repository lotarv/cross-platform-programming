import java.util.List;

public class GrapeSorter {
    public static void sortByPrice(List<Grape> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(List<Grape> list, int left, int right) {
        if (left >= right) return;

        double pivot = list.get((left + right) / 2).getPrice();
        int i = left;
        int j = right;

        while (i <= j) {
            while (list.get(i).getPrice() < pivot) i++;
            while (list.get(j).getPrice() > pivot) j--;
            if (i <= j) {
                Grape temp = list.get(i);
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
