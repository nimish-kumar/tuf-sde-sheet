package pascalTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PascalTriangle {

    public static Integer combination(Integer n, Integer r) {
        if (r == 0) {
            return 1;
        }
        Integer numerator = 1;
        Integer denominator = 1;
        Integer base = n - r > r ? r : n - r;
        for (int i = 1; i <= base; i++) {
            numerator = numerator * (n - i + 1);
            denominator = denominator * i;

        }
        return (int) ((double) numerator / (double) denominator);
    }

    public static ArrayList<Integer> generatePascalTriangleRow(int rowNumber) {
        ArrayList<Integer> pascalRow = new ArrayList<>();
        if (rowNumber == 0) {
            pascalRow.add(1);
            return pascalRow;
        }
        for (int i = 0; i < rowNumber; i++) {
            pascalRow.add(combination(rowNumber - 1, i));
        }
        return pascalRow;
    }

    // public static ArrayList<Integer> generatePascalTriangleRow(int rowIndex) {

    // var firstRow = new ArrayList<>(Arrays.asList(1));
    // var secondRow = new ArrayList<>(Arrays.asList(1, 1));

    // if (rowIndex == 0) {
    // return firstRow;
    // }

    // if (rowIndex == 1) {
    // return secondRow;
    // }
    // var currentRow = new ArrayList<Integer>();
    // var prevRow = generatePascalTriangleRow(rowIndex - 1);
    // for (int i = 0; i < rowIndex; i++) {
    // if (i == 0) {
    // currentRow.add(1);
    // } else if (i == rowIndex - 1) {
    // currentRow.add(1);
    // } else {
    // currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
    // }
    // }
    // return currentRow;
    // }

    public static void main(String[] args) {

        var targetRowIndex = 6;
        var pascalTriangleRow = generatePascalTriangleRow(targetRowIndex)
                .stream()
                .map(e -> Integer.toString(e))
                .collect(Collectors.toList());

        System.out.println("Combination: " + String.join(" ", pascalTriangleRow));

    }
}
