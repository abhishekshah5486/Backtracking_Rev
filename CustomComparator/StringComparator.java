package CustomComparator;

import java.util.*;
public class StringComparator {
    public static void main(String[] args) {
        String[] rareFruits = {
            "Rambutan",
            "Durian",
            "Mangosteen",
            "Salak",
            "Cherimoya",
            "Longan",
            "Carambola",
            "HornedMelon",
            "BuddhasHand",
            "Jackfruit"
        };
        Arrays.sort(rareFruits);
        // Sorts the string array in the alphabetical order by default.
        Arrays.sort(rareFruits, new StringSizeComparator());
        printList(rareFruits);
        System.out.println();
        Arrays.sort(rareFruits, new VowelsCountStringComparator());
        printList(rareFruits);
    }
    public static void printList(String[] arr){
        for (int j=0; j<arr.length; j++){
            System.out.print(arr[j] + " ");
        }
    }
    public static int countVowels(String s){
        int countVowels = 0;
        for (int j=0; j<s.length(); j++){
            if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u'){
                countVowels++;
            }
        }
        return countVowels;
    }
}
class StringSizeComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        if (s1.length() < s2.length()) return -1;
        else if (s1.length() > s2.length()) return 1;
        else return 0;
    }
}
class VowelsCountStringComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        int c1 = StringComparator.countVowels(s1);
        int c2 = StringComparator.countVowels(s2);

        if (c1 < c2) return -1;
        else if (c1 > c2) return 1;
        else return 0;
    }
}
