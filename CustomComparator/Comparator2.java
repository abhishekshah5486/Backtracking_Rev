package CustomComparator;

import java.util.*;
public class Comparator2 {
    public static void main(String[] args) {
        Integer[] arr = {13, 7, 6, 8, 3, -1, 9};
        Arrays.sort(arr, new CountOfFatorsComparator());
        ListPrinter(arr);
    }
    public static void ListPrinter(Integer[] arr){
        for (int j=0; j<arr.length; j++){
            System.out.print(arr[j].intValue() + " ");
        }
    }
    public static int countFactors(int num){
        int count = 0;
        for (int j=1; j<=num; j++){
            if (num % j == 0) count++;
        }
        return count;
    }
}
class CountOfFatorsComparator implements Comparator<Integer>{
    // @Override
    // public int compare(Integer o1, Integer o2){
    //     return o1.intValue() - o2.intValue();
    // }
    @Override
    public int compare(Integer o1, Integer o2){
        int c1 = Comparator2.countFactors(o1.intValue());
        int c2 = Comparator2.countFactors(o2.intValue());
        if (c1 < c2) return -1;
        else if (c1 > c2) return 1;
        else {
            return o1.intValue() - o2.intValue();
        }
    }
}
