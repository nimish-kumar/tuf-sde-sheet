package mergeTwoSortedArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static ArrayList<Integer> mergeSortedArrays(
            ArrayList<Integer> firstArr,
            ArrayList<Integer> secondArr) {

        int firstIndex = 0;
        int secondIndex = 0;
        int smallestIndex = Integer.min(firstArr.size(), secondArr.size()) - 1;

        ArrayList<Integer> result = new ArrayList<>();

        while (firstIndex <= smallestIndex || secondIndex <= smallestIndex) {
            if (firstArr.get(firstIndex) <= secondArr.get(secondIndex)) {
                result.add(firstArr.get(firstIndex));
                firstIndex++;
            }
            if (firstArr.get(firstIndex) > secondArr.get(secondIndex)) {
                result.add(secondArr.get(secondIndex));
                secondIndex++;
            }

            // if (firstIndex < firstArr.size() && secondIndex < secondArr.size()
            //         && firstArr.get(firstIndex) == secondArr.get(secondIndex)) {
            //     result.add(firstArr.get(firstIndex));
            //     result.add(secondArr.get(secondIndex));
            //     firstIndex++;
            //     secondIndex++;
            // }

        }

        if (firstArr.size() == secondArr.size()) {
            return result;
        }
        if (smallestIndex == secondArr.size() - 1) {
            result.addAll(firstArr.subList(smallestIndex + 1, firstArr.size()));
        } else {
            result.addAll(secondArr.subList(smallestIndex + 1, secondArr.size()));

        }
        return result;
    }

    public static void printResults(
            ArrayList<Integer> firstArr,
            ArrayList<Integer> secondArr) {
        var resultArr = mergeSortedArrays(firstArr, secondArr);

        for (Integer value : resultArr) {
            System.out.print(value + " ");
        }
        System.out.println("\n------------------------");

    }

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(2, 3, 5, 9));

        System.out.println("\n");
        printResults(first, second);

    }

}
