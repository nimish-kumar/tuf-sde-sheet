package threePointer;

import java.util.ArrayList;
import java.util.Arrays;

// [0, ... , low-1]  For 0, extreme left
// [low, ..., mid-1] For 1, middle
// [mid, ... , high] 
// [high + 1, n -1]  For 2, extreme right

public class ThreePointer {

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<>();

        array.addAll(Arrays.asList(2, 0, 1, 0, 0, 1, 2, 1, 1, 2));

        int low = 0;
        int mid = 0;
        int high = array.size() - 1;
    }
}
