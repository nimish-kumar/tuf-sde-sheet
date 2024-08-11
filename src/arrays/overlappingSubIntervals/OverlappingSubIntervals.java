package overlappingSubIntervals;

import java.util.ArrayList;
import java.util.Collections;

class Tuple implements Comparable<Tuple> {
    private int first;
    private int second;

    Tuple(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int first() {
        return this.first;
    }

    public int second() {
        return this.second;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int compareTo(Tuple comparingTuple) {
        return this.first - comparingTuple.first;
    }

}

public class OverlappingSubIntervals {
    public static ArrayList<Tuple> toSort(ArrayList<Tuple> array) {
        Collections.sort(array);
        return array;
    }

    public static void main(String[] args) {
        ArrayList<Tuple> arr = new ArrayList<>();

        arr.add(new Tuple(1, 3));
        arr.add(new Tuple(2, 6));
        arr.add(new Tuple(8, 10));
        arr.add(new Tuple(5, 7));
        arr.add(new Tuple(12, 13));

        arr = toSort(arr);

        // for (Tuple tuple : arr) {
        //     System.out.println("(" + tuple.first() + ", " + tuple.second() + ") ");
        // }

        int continuosIndex = -1;

        ArrayList<Tuple> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (continuosIndex >= 0
                    && result.get(continuosIndex).second() >= arr.get(i).first() &&
                    arr.get(i).second() >= result.get(continuosIndex).second()) {
                result.get(continuosIndex).setSecond(arr.get(i).second());
            }
            if (continuosIndex >= 0 && result.get(continuosIndex).first() >= arr.get(i).first() &&
                    arr.get(i).second() >= result.get(continuosIndex).first()) {
                result.get(continuosIndex).setFirst(arr.get(i).first());
            }

            if (continuosIndex < 0 || result.get(continuosIndex).second() < arr.get(i).first()) {
                result.add(arr.get(i));
                continuosIndex++;
            }

        }
        // System.out.println("--------------");
        for (Tuple tuple : result) {
            System.out.println("(" + tuple.first() + ", " + tuple.second() + ") ");
        }
    }
}
