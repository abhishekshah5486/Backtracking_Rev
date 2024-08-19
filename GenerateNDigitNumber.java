import java.util.*;

public class GenerateNDigitNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = scn.nextInt();
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int j=0; j<x; j++){
            list.add(scn.nextInt());
        }
        // generateNDigitNumberUsing1N2(n, temp);
        generateNDigitNumber(ans, list, n, temp);
        print2DList(ans);
        System.out.println(ans.size());
        scn.close();
    }
    public static void generateNDigitNumberUsing1N2(int n, List<Integer> temp){
        if (n == 0){
            printList(temp);
            return;
        }
        // Add 1 to the list at the current idx
        temp.add(1);
        generateNDigitNumberUsing1N2(n-1, temp);
        temp.remove(temp.size() - 1);
        // Add 2 to the list at the current idx
        temp.add(2);
        generateNDigitNumberUsing1N2(n-1, temp);
        temp.remove(temp.size() - 1);
    }
    public static void generateNDigitNumber(List<List<Integer>> ans, List<Integer> list, int n, List<Integer> temp){
        if (n == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j=0; j<list.size(); j++){
            temp.add(list.get(j));
            generateNDigitNumber(ans, list, n-1, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public static void printList(List<Integer> arr){
        for (int j=0; j<arr.size(); j++){
            System.out.print(arr.get(j) + " ");
        }
        System.out.println();
    }
    public static void print2DList(List<List<Integer>> lst){
        for (int j=0; j<lst.size(); j++){
            for (int k=0; k<lst.get(0).size(); k++){
                System.out.print(lst.get(j).get(k) + " ");
            }
            System.out.println();
        }
    }
} 
