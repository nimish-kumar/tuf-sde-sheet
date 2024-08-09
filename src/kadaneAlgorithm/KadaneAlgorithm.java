package kadaneAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class KadaneAlgorithm {

    // Kadane's Algorithm
    public static Integer findLargestSumOfContinuousSubArray(ArrayList<Integer> nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }

        }
        return max;
    }

    // public static Integer findLargestSumOfContinuousSubArray(ArrayList<Integer>
    // nums) {
    // HashMap<Integer, Integer> map = new HashMap<>();
    // int sum = 0;
    // Integer maxSumIndex = null;
    // int maxSum = 0;

    // for (int i = 0; i < nums.size(); i++) {
    // if (maxSumIndex == null) {
    // maxSumIndex = 0;
    // }
    // sum = sum + nums.get(i);
    // map.put(i, sum);

    // if (map.get(maxSumIndex) < sum) {
    // maxSumIndex = i;
    // }
    // }
    // maxSum = map.get(maxSumIndex);

    // if (maxSumIndex == 0) {
    // return maxSum;
    // }

    // return Collections.max(Arrays.asList(maxSum,
    // maxSum - (Collections.min(
    // map.values().stream()
    // .toList()
    // .subList(0, maxSumIndex + 1)))));
    // }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(5, -2, 1, -2, 5));

        // arr.addAll(Arrays.asList(-5, 4, -3, 7, -10));

        // arr.addAll(Arrays.asList(-1, -3, -4, -5, -6));

        System.out.println(findLargestSumOfContinuousSubArray(arr));

    }
}
