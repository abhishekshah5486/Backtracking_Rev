import java.util.*;
public class CombinationSumI {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int j=0; j<n; j++){
            arr.add(scn.nextInt());
        }
        int target = scn.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        List<Integer> removedDuplicatesArr = removeDuplicates(arr);
        solveCombinationSumI(ans, curr, removedDuplicatesArr, 0, target, 0);
        Collections.sort(ans, new LexicographicalListComparator());
        print2DList(ans);
        System.out.println(ans.size());

        scn.close();
    }
    public static void solveCombinationSumI(List<List<Integer>> ans, List<Integer> curr, List<Integer> arr, int idx, int target, int currSum){
        // Base Condition
        if (currSum > target) return;
        if (idx >= arr.size()){
            if (currSum == target){
                List<Integer> sortedCurr = new ArrayList<>(curr);
                Collections.sort(sortedCurr);
                ans.add(sortedCurr);
            }
            return;
        }
        // Choosing the current idx
        curr.add(arr.get(idx));
        solveCombinationSumI(ans, curr, arr, idx, target, currSum + arr.get(idx));
        curr.remove(curr.size() - 1);
        
        // Skipping the current idx
        solveCombinationSumI(ans, curr, arr, idx + 1, target, currSum);
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
    public static List<Integer> removeDuplicates(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        List<Integer> filteredList = new ArrayList<>();

        for (int j=0; j<list.size(); j++){
            if (!set.contains(list.get(j))){
                set.add(list.get(j));
                filteredList.add(list.get(j));
            }
        }
        return filteredList;
    }
}
class LexicographicalListComparator implements Comparator<List<Integer>>{
    @Override
    public int compare(List<Integer> l1, List<Integer> l2){
        int s1 = l1.size();
        int s2 = l2.size();

        for (int j=0; j<Math.min(s1, s2); j++){
            if (l1.get(j) < l2.get(j)) return -1;
            else if (l1.get(j) > l2.get(j)) return 1;
        }
        if (s1 < s2) return -1;
        else if (s1 > s2) return 1;
        return 0;
    }
}