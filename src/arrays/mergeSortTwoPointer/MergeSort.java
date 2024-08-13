package mergeSortTwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return;
        }

        int middle = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(list.subList(middle, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    private static void merge(ArrayList<Integer> list, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 5, 1, 2, 6, 8, 7, 0));
        mergeSort(arr);
        arr.forEach(x -> System.out.println(x + " "));
    }
}
