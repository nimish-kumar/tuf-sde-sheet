package pascalTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PascalTriangle {

    public static ArrayList<Integer> generatePascalTriangleRow(int rowIndex){

        var firstRow = new ArrayList<>(Arrays.asList(1));
        var secondRow = new ArrayList<>(Arrays.asList(1,1));


        if(rowIndex == 0){
            return firstRow;
        }

        if(rowIndex == 1){
            return secondRow;
        }
        var currentRow = new ArrayList<Integer>();
        var prevRow = generatePascalTriangleRow(rowIndex -1);
        for (int i=0; i<rowIndex;i++){
            if (i==0){
               currentRow.add(1);
            }
            else if(i==rowIndex-1){
                currentRow.add(1);
            }
            else {
                currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
            }   
        }
        return currentRow;
    }

    public static void main(String[] args) {
  
        var targetRowIndex = 5;
        var pascalTriangleRow = generatePascalTriangleRow(targetRowIndex).stream().map(e->Integer.toString(e)).collect(Collectors.toList());

        System.out.println(String.join(" ", pascalTriangleRow));

    }
}
