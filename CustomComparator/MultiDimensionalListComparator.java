package CustomComparator;

import java.util.*;
public class MultiDimensionalListComparator{
    public static void main(String[] args) {

        // Sort the coordinates such that all the points with lesser x-coordinate appear first,
        // if x-coordinate is equal --> compare y-coordinate
        // if 2 coordinates are equal, order doesn't matter.
        Integer[][] list = {
            {1, 2},
            {3, 4},
            {-1, -1},
            {4, 5},
            {4, 7},
            {-3, 9},
            {0, 2},
            {8, -4}
        };
        Arrays.sort(list, new CoordinateListComparator());
        printList(list);
    }
    public static void printList(Integer[][] list){
        for (int j=0; j<list.length; j++){
            for (int k=0; k<list[0].length; k++){
                System.out.print(list[j][k] + " ");
            }
            System.out.println();
        }
    }
}
class CoordinateListComparator implements Comparator<Integer[]>{
    @Override
    public int compare(Integer[] p1, Integer[] p2){
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];

        if (x1 < x2) return -1;
        else if (x1 > x2) return 1;
        else {
            if (y1 < y2) return -1;
            else if (y1 > y2) return 1;
            else return 0;
        }
    }
}