package domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface Sort {
    static <T> void bubbleSort(List<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (comparator.compare(list.get(j + 1), list.get(j)) < 0) {
                    Collections.swap(list, j + 1, j);
                }
            }
        }
    }

    static <T> void quickSort(List<T> list, int low, int high, Comparator<T> comparator) {
        if (list.size() == 0 || low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        T prop = list.get(middle);
        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(list.get(i), prop) < 0) {
                i++;
            }
            while (comparator.compare(list.get(j), prop) > 0) {
                j--;
            }
            if (i <= j) {
                Collections.swap(list, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(list, low, j, comparator);
        }
        if (high > i) {
            quickSort(list, i, high, comparator);
        }
    }

    static <T> void quickSort(List<T> list, Comparator<T> comparator) {
        if (list.size() == 0) {
            return;
        }
        int middle = (list.size() - 1) / 2;
        T prop = list.get(middle);
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            while (comparator.compare(list.get(i), prop) < 0) {
                i++;
            }
            while (comparator.compare(list.get(j), prop) > 0) {
                j--;
            }
            if (i <= j) {
                Collections.swap(list, i, j);
                i++;
                j--;
            }
        }
        if (0 < j) {
            quickSort(list, 0, j, comparator);
        }
        if (list.size() - 1 > i) {
            quickSort(list, i, list.size() - 1, comparator);
        }
    }
}
