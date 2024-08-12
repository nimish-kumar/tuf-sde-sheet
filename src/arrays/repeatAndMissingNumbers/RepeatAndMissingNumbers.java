package repeatAndMissingNumbers;

import java.util.ArrayList;
import java.util.Arrays;

record Tuple(
        Double missingNumber,
        Double repeatingNumber) {

}

public class RepeatAndMissingNumbers {

    public static Double naturalSumDiff(ArrayList<Integer> numbers) {
        // R - M = SUMM - REAL_SUM

        int n = numbers.size();
        double summ = (n * (n + 1)) / (double) 2;

        double realSum = 0;

        for (Integer number : numbers) {
            realSum = realSum + number;
        }

        return summ - realSum;
    }

    public static Double naturalSquaredSumDiff(ArrayList<Integer> numbers) {
        // R^2 - M^2 = SUMM - REAL_SUM

        int n = numbers.size();
        double summ = (double) (n * ((2 * n) + 1) * (n + 1)) / (double) 6;

        double realSum = 0;

        for (Integer number : numbers) {
            realSum = realSum + Math.pow(number, 2);
        }

        return (summ - realSum);
    }

    public static Tuple solveEquation(ArrayList<Integer> numbers) {
        /// R + M = NS^2DIFF/NSDIFF

        // R =( (NS^2DIFF/NSDIFF) + NSDIFF) / 2

        // M = R - NSDIFF

        var nSsquaredDiff = naturalSquaredSumDiff(numbers);
        var nsDiff = naturalSumDiff(numbers);

        var addition = nSsquaredDiff / nsDiff;
        var repeatingNumber = (double) (addition + nsDiff) / (double) 2;
        var missingNumber = repeatingNumber - nsDiff;
        return new Tuple(missingNumber, repeatingNumber);

    }

    public static void main(String[] args) {
        var tup = solveEquation(new ArrayList(Arrays.asList(1, 2, 3, 3, 5)));
        System.out.println("Missing number: " + tup.missingNumber().intValue());
        System.out.println("Repeating number: " + tup.repeatingNumber().intValue());
    }
}
