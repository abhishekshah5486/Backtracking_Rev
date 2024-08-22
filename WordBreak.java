import java.util.*;

class TrieNode{
    private Map<Character, TrieNode> map;
    private boolean isEnd;

    public TrieNode(){
        this.map = new HashMap<>();
        this.isEnd = false;
    }
    public Map<Character, TrieNode> getMap(){
        return this.map;
    }
    public boolean getIsEnd(){
        return this.isEnd;
    }
    public void setIsEnd(boolean bool){
        this.isEnd = bool;
    }
    public void setMap(Map<Character, TrieNode> map){
        this.map = map;
    }
}
public class WordBreak {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        TrieNode curr = new TrieNode();
        // String[] dict = {"cat", "cats", "and", "sand", "dog"};
        // String[] dict = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa"};
        String[] dict = {"apple", "pen", "applepen", "pine", "pineapple"};
        for (int j=0; j<dict.length; j++){
            insertIntoTrie(dict[j], curr);
        }
        // String str = "catsanddog";
        // String str = "aaaaaaa";  
        String str = "pineapplepenapple";
        List<List<String>> ans = new ArrayList<>();
        List<String> currSequence = new ArrayList<>();
        solveWordBreakII(ans, currSequence, curr, str, 0, str.length() - 1);
        print2DList(ans);

        scn.close();
    }   
    public static void solveWordBreakII(List<List<String>> ans, List<String> currSequence, TrieNode curr, String str, int s, int e){
        if (s > e){
            List<String> replicateStringSequence = new ArrayList<>(currSequence);
            ans.add(replicateStringSequence);
            return;
        }
        for (int j=s; j<=e; j++){
            String substr = subString(str, s, j);
            if (isValidWordInTrie(substr, curr)){
                currSequence.add(substr);
                solveWordBreakII(ans, currSequence, curr, str, j + 1, e);
                currSequence.remove(currSequence.size() - 1);
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
    public static void insertIntoTrie(String str, TrieNode curr){
        for (int j=0; j<str.length(); j++){
            char ch = str.charAt(j);
            if (!curr.getMap().containsKey(ch)){
                curr.getMap().put(ch, new TrieNode());
            }
            curr = curr.getMap().get(ch);
        }
        curr.setIsEnd(true);
    }
    public static boolean isValidWordInTrie(String str, TrieNode curr){
        for (int j=0; j<str.length(); j++){
            char ch = str.charAt(j);
            if (!curr.getMap().containsKey(ch)){
                return false;
            }
            curr = curr.getMap().get(ch);
        }
        if (curr.getIsEnd() == false) return false;
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
