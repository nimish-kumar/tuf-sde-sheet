package mergeTwoSortedArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedArrays {
    // 2 pointer
    public static ArrayList<Integer> mergeSortedArrays(
            ArrayList<Integer> firstArr,
            ArrayList<Integer> secondArr) {

        int firstPtr = 0;
        int secondPtr = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (firstPtr < firstArr.size() && secondPtr < secondArr.size()) {
            if (firstArr.get(firstPtr) < secondArr.get(secondPtr)) {
                result.add(firstArr.get(firstPtr));
                firstPtr++;
            } else {
                result.add(secondArr.get(secondPtr));
                secondPtr++;
            }
        }

        while (firstPtr < firstArr.size()) {
            result.add(firstArr.get(firstPtr));
            firstPtr++;
        }

        while (secondPtr < secondArr.size()) {
            result.add(secondArr.get(secondPtr));
            secondPtr++;
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
