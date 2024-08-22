import java.util.*;

public class Permutations2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> arr = new ArrayList<>();
        
        for (int j=0; j<n; j++){
            arr.add(scn.nextInt());
        }
        List<List<Integer>> ans =  new ArrayList<>();
        List<Integer> currPermutation = new ArrayList<>();
        generateAllPermutations(ans, currPermutation, arr, 0);
        print2DList(ans);
        System.out.println(ans.size());

        scn.close();
    }
    public static void generateAllPermutations(List<List<Integer>> ans, List<Integer> currPermutation, List<Integer> arr, int idx){
        // Base condition
        if (idx == arr.size()){
            List<Integer> replicatePermutation = new ArrayList<>(currPermutation);
            ans.add(replicatePermutation);
            return;
        }
        for (int j=idx; j<arr.size(); j++){
            currPermutation.add(arr.get(j));
            swap(arr, idx, j);
            generateAllPermutations(ans, currPermutation, arr, idx + 1);
            currPermutation.remove(currPermutation.size() - 1);
            swap(arr, idx, j);
        }
    }
    public static void swap(List<Integer> arr, int s, int e){
        // Swap the elements at idx s and idx e in the given array
        int temp = arr.get(s);
        arr.set(s, arr.get(e));
        arr.set(e, temp);
    }
    public static void print2DList(List<List<Integer>> list){
        System.out.println("  <");
        for (int j=0; j<list.size(); j++){
            System.out.print("    < ");
            for (int k=0; k<list.get(0).size(); k++){
                System.out.print(list.get(j).get(k) + " ");
            }
            System.out.print(">");
            System.out.println();
        }
        System.out.println("  >");
    }
}
