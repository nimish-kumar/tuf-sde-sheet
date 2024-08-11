package rotateMatrix;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {
    public static ArrayList<ArrayList<Integer>> rotateMatrix(ArrayList<ArrayList<Integer>> arr) {
        int columns = arr.get(0).size();
        int rows = arr.size();

        ArrayList<ArrayList<Integer>> rotatedArray = new ArrayList<>();

        for (int i = 0; i < columns ; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = rows - 1; j >= 0; j--) {
                
                row.add(arr.get(j).get(i));
            }
            rotatedArray.add(new ArrayList<>(row));
        }

        return rotatedArray;
    }

    public static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            for (Integer value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // MATRIX 1

        // matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        // matrix.add(new ArrayList<>(Arrays.asList(6, 7, 8)));

        // MATRIX 2

        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, -1)));
        matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, -2)));
        matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12, -3)));
        matrix.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16, -4)));

        printMatrix(matrix);

        System.out.println("--------------------------------------");
        ArrayList<ArrayList<Integer>> rotatedMatrix = rotateMatrix(matrix);

        printMatrix(rotatedMatrix);
    }
}
