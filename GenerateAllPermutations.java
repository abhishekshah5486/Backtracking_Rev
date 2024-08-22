import java.util.*;

public class GenerateAllPermutations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> arr = new ArrayList<>();
        
        for (int j=0; j<n; j++){
            arr.add(scn.nextInt());
        }
        List<List<Integer>> ans =  new ArrayList<>();
        List<Integer> currPermutation = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        generateAllPermutations(ans, currPermutation, arr, set);
        print2DList(ans);
        System.out.println(ans.size());

        scn.close();
    }
    public static void generateAllPermutations(List<List<Integer>> ans, List<Integer> currPermutation, List<Integer> arr,  Set<Integer> set){
        // Base Conditions
        if (currPermutation.size() == arr.size()){
            List<Integer> replicatePermutation = new ArrayList<>(currPermutation);
            ans.add(replicatePermutation);
            return;
        }
        for (int j=0; j<arr.size(); j++){
            if (!set.contains(arr.get(j))){
                set.add(arr.get(j));
                currPermutation.add(arr.get(j));
                generateAllPermutations(ans, currPermutation, arr, set);
                set.remove(arr.get(j));
                currPermutation.remove(currPermutation.size() - 1);
            }
        }
    }
    public static void print2DList(List<List<Integer>> list){
        for (int j=0; j<list.size(); j++){
            for (int k=0; k<list.get(0).size(); k++){
                System.out.print(list.get(j).get(k) + " ");
            }
            System.out.println();
        }
    }
}
