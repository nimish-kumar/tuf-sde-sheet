package stockBuyAndSell;

import java.util.ArrayList;
import java.util.Arrays;

public class StockBuyAndSell {

    public static Integer maximizeProfit(
            ArrayList<Integer> arr) {

        Integer minPrice = Integer.MAX_VALUE;
        Integer profit = 0;

        for(int i=0; i<arr.size(); i++){
            if (arr.get(i) < minPrice){
                minPrice = arr.get(i);
            }
            if(arr.get(i) > minPrice && profit < arr.get(i) - minPrice) {
                profit = arr.get(i) - minPrice;
            }

        }

        return profit;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.addAll(Arrays.asList(6, 5, 2, 1, 5, 1, 10));

        // arr.addAll(Arrays.asList(7,6,4,3,1));
        // arr.addAll(Arrays.asList(2,6,4,3,7));

        System.out.println("Max Profit: " + maximizeProfit(arr));
    }
}
