package searchInTwoDimensionMatrix;

import java.util.ArrayList;
import java.util.Arrays;

class Coordinate {
    Integer x;
    Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}

public class SearchInTwoDimensionMatrix {

    public static Coordinate searchNumber(
            ArrayList<ArrayList<Integer>> matrix,
            Integer numberToBeSearched) {

        Integer rowIndex = 0;

        for (int i = 0; i < matrix.size(); i++) {

            if (numberToBeSearched == matrix.get(i).get(0)) {
                return new Coordinate(i, 0);
            }
            if (numberToBeSearched < matrix.get(i).get(0)) {
                break;
            }
            rowIndex = i;
        }

        // System.out.println("Row Index : " + rowIndex);

        for (int i = 1; i < matrix.get(rowIndex).size(); i++) {
            if (numberToBeSearched == matrix.get(rowIndex).get(i)) {
                return new Coordinate(rowIndex, i);
            }
        }

        return new Coordinate(-1, -1);
    }

    public static void printCoordinate(Coordinate c) {
        if (c.x == -1 && c.y == -1) {
            System.out.println("Coordinates not found");
        } else {
            System.out.println("Co-ordinates X: " + c.x + " & Y: " + c.y);
        }

    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
        matrix.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16)));

        printCoordinate(searchNumber(matrix, 7));
        printCoordinate(searchNumber(matrix, 12));
        printCoordinate(searchNumber(matrix, 1));
        printCoordinate(searchNumber(matrix, 13));
        printCoordinate(searchNumber(matrix, 9));

        printCoordinate(searchNumber(matrix, -1));
    }
}
