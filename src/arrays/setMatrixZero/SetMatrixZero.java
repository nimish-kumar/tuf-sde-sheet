package setMatrixZero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZero {

    public static HashSet<String> zeroedIndexes(
            Integer rowIndex,
            Integer colIndex,
            Integer rowCount,
            Integer colCount) {
        var indexes = new HashSet<String>();
        for (int c = 0; c < colCount; c++) {
            indexes.add(rowIndex + ":" + c);
        }
        for (int r = 0; r < rowCount; r++) {
            indexes.add(r + ":" + colIndex);
        }

        return indexes;
    }

    public static ArrayList<ArrayList<Integer>> zeroMatrix(
            ArrayList<ArrayList<Integer>> arr) {
        var indexesList = new HashSet<String>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (arr.get(i).get(j) == 0) {
                    indexesList.addAll(zeroedIndexes(i, j, arr.size(), arr.get(0).size()));
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (indexesList.contains(i + ":" + j)) {
                    arr.get(i).set(j, 0);
                }
            }
        }

        return arr;

    }

    public static void main(String args[]) {
        var matrix = new ArrayList<ArrayList<Integer>>();

        // Added data
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 2, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(3, 4, 5, 2)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 3, 1, 5)));

        matrix = zeroMatrix(matrix);

        System.out.println("The Final matrix is: ");

        for (ArrayList<Integer> row : matrix) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }
}
