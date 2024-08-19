import java.util.*;

public class GenerateAllCombinations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int A = scn.nextInt();
        int B = scn.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int j=1; j<=A; j++){
            arr.add(j);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateAllCombinations(ans, curr, arr, 0, B);
        print2DList(ans);
    }
    public static void generateAllCombinations(List<List<Integer>> ans, List<Integer> curr, List<Integer> arr, int idx, int B){
        if (idx == arr.size()){
            if (curr.size() == B){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        curr.add(arr.get(idx));
        generateAllCombinations(ans, curr, arr, idx + 1, B);
        curr.remove(curr.size() - 1);
        generateAllCombinations(ans, curr, arr, idx + 1, B);
    }
    public static void print2DList(List<List<Integer>> lst){
        System.out.println(" <");
        for (int j=0; j<lst.size(); j++){
            System.out.print("   < ");
            for (int k=0; k<lst.get(j).size(); k++){
                System.out.print(lst.get(j).get(k) + " ");
            }
            System.out.print(">");
            System.out.println();
        }
        System.out.println(" >");
    }
    public static void printList(List<Integer> arr){
        for (int j=0; j<arr.size(); j++){
            System.out.print(arr.get(j) + " ");
        }
        System.out.println();
    }
}
