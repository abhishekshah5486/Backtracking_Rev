import java.util.*;

public class LetterCombinationsLeetcode {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String digits = scn.nextLine();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        StringBuilder currCombination = new StringBuilder();
        solveLetterCombinations(map, ans, currCombination, digits, 0);
        printList(ans);
        System.out.println(ans.size());

        scn.close();
    }
    public static void solveLetterCombinations(Map<Character, String> map, List<String> ans, StringBuilder currCombination, String digits, int idx){
        if (digits.isEmpty()) return;
        if (idx == digits.length()){
            StringBuilder replicateLetterCombination = new StringBuilder(currCombination);
            ans.add(replicateLetterCombination.toString());
            return;
        }
        String str = map.get(digits.charAt(idx));
        for (int j=0; j<str.length(); j++){
            currCombination.append(str.charAt(j));
            solveLetterCombinations(map, ans, currCombination, digits, idx + 1);
            currCombination.deleteCharAt(currCombination.length() - 1);
        }
    }
    public static void printList(List<String> ans){
        for (int j=0; j<ans.size(); j++){
            System.out.print(ans.get(j) + " ");
        }
    }
}
