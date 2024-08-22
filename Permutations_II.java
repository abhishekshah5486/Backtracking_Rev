import java.util.*;

public class Permutations_II {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int j=0; j<n; j++){
            arr.add(scn.nextInt());
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currPermuteSeq = new ArrayList<>();
        solvePermuteUnique(ans, currPermuteSeq, arr, 0);
        print2DList(ans);
        System.out.println(ans.size());

        scn.close();
    }
    public static void solvePermuteUnique(List<List<Integer>> ans, List<Integer> currPermuteSeq,  List<Integer> arr, int idx){
        if (idx == arr.size()){
            List<Integer> replicatePermuteSeq = new ArrayList<>(currPermuteSeq);
            ans.add(replicatePermuteSeq);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int j=idx; j<arr.size(); j++){
            if (!set.contains(arr.get(j))){
                set.add(arr.get(j));    
                currPermuteSeq.add(arr.get(j));
                swap(arr, idx, j);
                solvePermuteUnique(ans, currPermuteSeq, arr, idx + 1);
                currPermuteSeq.remove(currPermuteSeq.size() - 1);
                swap(arr, idx, j);
            }
        }
    }
    public static void swap(List<Integer> arr, int s, int e){
        int temp = arr.get(s);
        arr.set(s, arr.get(e));
        arr.set(e, temp);
    }
    public static void print2DList(List<List<Integer>> arr){
        for (int j=0; j<arr.size(); j++){
            for (int k=0; k<arr.get(0).size(); k++){
                System.out.print(arr.get(j).get(k) + " ");
            }
            System.out.println();
        }
    }
}
