import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        List<List<String>> ans = new ArrayList<>();
        List<String> currPalindromeSeq = new ArrayList<>();
        solvePalindromePartitioning(ans, currPalindromeSeq, str, 0, str.length() - 1);
        print2DList(ans);
        System.out.println(ans.size());

        scn.close();
    }
    public static void solvePalindromePartitioning(List<List<String>> ans, List<String> currPalindromeSeq, String str, int s, int e){
        if (s > e){
            List<String> replicatePalindromeSeq = new ArrayList<>(currPalindromeSeq);
            ans.add(replicatePalindromeSeq);
            return;
        }
        for (int j=s; j<=e; j++){
            if (isPalindrome(str, s, j)){
                String substr = subString(str, s, j);
                currPalindromeSeq.add(substr);
                solvePalindromePartitioning(ans, currPalindromeSeq, str, j + 1, e);
                currPalindromeSeq.remove(currPalindromeSeq.size() - 1);
            }
        }
    }
    public static String subString(String str, int s, int e){
        StringBuilder sb = new StringBuilder();
        for (int j=s; j<=e; j++){
            sb.append(str.charAt(j));
        }
        return sb.toString();
    }
    public static boolean isPalindrome(String str, int s, int e){
        while (s <= e){
            if (str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
    public static void print2DList(List<List<String>> arr){
        for (int j=0; j<arr.size(); j++){
            for (int k=0; k<arr.get(j).size(); k++){
                System.out.print(arr.get(j).get(k) + " ");
            }
            System.out.println();
        }
    }
}
