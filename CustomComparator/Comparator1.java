package CustomComparator;

import java.util.*;

public class Comparator1 {
    public static void main(String[] args) {
        Integer[] arr = {13, 7, 6, 8, 3, -1, 9};
        // Sort the array
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
               // Return a positive value, if o1 should appear after o2 in the sorted array
               // Return a negative value, if o2 should appear after o1 in the sorted array
               // Return 0 if the order of o1 and o2 doesn't matter

               if (o1.intValue() < o2.intValue()) return 1;
               else if (o1.intValue() > o2.intValue()) return -1;
               else return 0;
            }
        });
        for (int j=0; j<arr.length; j++){
            System.out.print(arr[j] + " ");
        }
    }
}
