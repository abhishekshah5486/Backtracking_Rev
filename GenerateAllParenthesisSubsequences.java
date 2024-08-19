import java.util.*;

public class GenerateAllParenthesisSubsequences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int A = scn.nextInt();

        List<String> ans = new ArrayList<>();
        StringBuilder currSeq = new StringBuilder();
        int countLeft = A;
        int countRight = A;
        generateAllParenthesisSubsequences(ans, currSeq, countLeft, countRight);
        Collections.sort(ans, new LexicographicalParenthesisSequenceComparator());
        printList(ans);
        System.out.println(ans.size());

        scn.close();
    }
    public static void generateAllParenthesisSubsequences(List<String> ans, StringBuilder currSeq, int countLeft, int countRight){
        if (countRight < countLeft) return;
        if (countLeft < 0 || countRight < 0) return;

        if (countLeft == 0 && countRight == 0){
            StringBuilder replicateSequence = new StringBuilder(currSeq);
            ans.add(replicateSequence.toString());
            return;
        }
        // Adding opening ( bracket to the curr sequence
        currSeq.append('(');
        generateAllParenthesisSubsequences(ans, currSeq, countLeft - 1, countRight);
        currSeq.deleteCharAt(currSeq.length() - 1);

        // Adding closing ) symbol to the curr sequence
        currSeq.append(')');
        generateAllParenthesisSubsequences(ans, currSeq, countLeft, countRight -1);
        currSeq.deleteCharAt(currSeq.length() - 1);
    }
    public static void printList(List<String> arr){
        for (int j=0; j<arr.size(); j++){
            for (int k=0; k<arr.get(j).length(); k++){
                System.out.print(arr.get(j).charAt(k));
            }
            System.out.println();
        }
    }
}
class LexicographicalParenthesisSequenceComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        for (int j=0; j<Math.min(s1.length(), s2.length()); j++){
            if (s1.charAt(j) == '(' && s2.charAt(j) == ')') return -1;
            else if (s1.charAt(j) == ')' && s2.charAt(j) == '(') return 1;
        }
        if (s1.length() < s2.length()) return -1;
        else if (s1.length() > s2.length()) return 1;
        return 0;
    }
}

