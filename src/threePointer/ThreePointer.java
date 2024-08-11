package threePointer;

import java.util.ArrayList;
import java.util.Arrays;

// [0, ... , low-1]  For 0, extreme left, sorted
// [low, ..., mid-1] For 1, middle, sorted
// [mid, ... , high] Unsorted stuff
// [high + 1, n -1]  For 2, extreme right

/// 0 0 0 0 1 1 1 1 1 [2 0 1 0 0 1 0 1] 2 2 2 2 2
///         L         M               H
// Logic:
// If mid -> 0, swap with low and increase idx of low and mid by 1
// If mid -> 1, inc mid by 1
// If mid -> 2, swap with hi and decrease idx of hi by 1
// if mid == high, then stop but for safety let's stop it at mid > high

public class ThreePointer {

    public static ArrayList<Integer> threePointerSort(ArrayList<Integer> initialArr) {
        ArrayList<Integer> arr = initialArr;
        int low = 0;
        int mid = 0;
        int high = arr.size() - 1;

        while (mid < high) {
            if (arr.get(mid) == 0) {
                int temp = arr.get(mid);
                arr.set(mid, arr.get(low));
                arr.set(low, temp);

                low = low + 1;
                // it can only get swapped with a 1
                // since on left of mid are only 1s and
                // low is on initial 1

                // And since swapping, 0 0 1 1 0
                //                         ^   ^

                // it will result in, 0 0 0 1 1 [Unsorted grabage]
                //                          ^   ^
                // So both low and mid needs to be increaed by 1
                mid = mid + 1;
            }
            if (arr.get(mid) == 1) {
                mid = mid + 1;
            }
            if (arr.get(mid) == 2) {
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);

                high = high - 1;
            }
        }

        return arr;
    }

    public static void testSuite(ArrayList<ArrayList<Integer>> arrays) {

        System.out.println("----SOLUTION----");
        arrays.forEach(y -> {
            threePointerSort(y).forEach(x -> System.out.print(x + " "));
            System.out.println("\n--------------------------------------------------------");
        });
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> array = new ArrayList<>();

        array.add(
                new ArrayList<>(Arrays.asList(2, 0, 1, 0, 0, 1, 2, 1, 1, 2)));
        array.add(
                new ArrayList<>(Arrays.asList(2, 2, 2, 0, 0, 0, 1, 1, 1, 1)));
        array.add(
                new ArrayList<>(Arrays.asList(2, 2, 2, 1, 1, 0, 0, 0)));
        array.add(
                new ArrayList<>(Arrays.asList(2, 0, 2, 1, 1, 0)));

        array.add(
                new ArrayList<>(Arrays.asList(1, 1, 1, 0, 2, 0, 0, 2, 0, 2, 1, 1, 0)));

        testSuite(array);
    }
}
