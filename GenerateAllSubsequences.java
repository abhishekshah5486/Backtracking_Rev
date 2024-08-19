import java.util.*;

public class GenerateAllSubsequences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int x = scn.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int j=0; j<x; j++){
            list.add(scn.nextInt());
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generateAllSubsequences(ans, list, temp, 0);
        print2DList(ans);
        System.out.println(ans.size());

        scn.close();
    }
    public static void generateAllSubsequences(List<List<Integer>> ans, List<Integer> list, List<Integer> temp, int idx){
        if (idx >= list.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // Adding the idx indexed element to the subsequence
        temp.add(list.get(idx));
        generateAllSubsequences(ans, list, temp, idx + 1);
        temp.remove(temp.size() - 1);
        generateAllSubsequences(ans, list, temp, idx + 1);
    }
    public static void print2DList(List<List<Integer>> lst){
        for (int j=0; j<lst.size(); j++){
            System.out.print("< ");
            for (int k=0; k<lst.get(j).size(); k++){
                System.out.print(lst.get(j).get(k) + " ");
            }
            System.out.print(">");
            System.out.println();
        }
    }
    public static void printList(List<Integer> arr){
        for (int j=0; j<arr.size(); j++){
            System.out.print(arr.get(j) + " ");
        }
        System.out.println();
    }
}
