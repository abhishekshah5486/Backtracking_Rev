import java.util.*;
public class RatAndMaze_I {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        List<List<Integer>> maze = new ArrayList<>();
        for (int j=0; j<n; j++){
            List<Integer> temp = new ArrayList<>();
            for (int k=0; k<m; k++){
                temp.add(scn.nextInt());
            }
            maze.add(temp);
        }
        StringBuilder currPath = new StringBuilder();
        List<String> ans = new ArrayList<>();
        generateAllPossiblePathsInMaze(ans, maze, currPath, 0, 0);
        Collections.sort(ans, new LexicographicalListComparator());
        printList(ans);

        scn.close();
    }
    public static void generateAllPossiblePathsInMaze(List<String> ans, List<List<Integer>> maze, StringBuilder currPath, int r, int c){
        // Base Condtions
        if ( r < 0 || c < 0 || r >= maze.size() || c >= maze.get(0).size()) return;
        if (maze.get(r).get(c) == -1) return;

        if (r == maze.size() - 1 && c == maze.get(0).size() - 1){
            StringBuilder replicatePath = new StringBuilder(currPath);
            ans.add(replicatePath.toString());
        }
        // DLRU Down Left Right Up
        maze.get(r).set(c, -1);
        // Moving Down
        currPath.append("D");
        generateAllPossiblePathsInMaze(ans, maze, currPath, r + 1, c);
        currPath.deleteCharAt(currPath.length() - 1);
        // Moving Left
        currPath.append("L");
        generateAllPossiblePathsInMaze(ans, maze, currPath, r, c - 1);
        currPath.deleteCharAt(currPath.length() - 1);
        // Moving Right
        currPath.append("R");
        generateAllPossiblePathsInMaze(ans, maze, currPath, r, c + 1);
        currPath.deleteCharAt(currPath.length() - 1);
        // Moving Up
        currPath.append("U");
        generateAllPossiblePathsInMaze(ans, maze, currPath, r - 1, c);
        currPath.deleteCharAt(currPath.length() - 1);

        maze.get(r).set(c, 0);
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
class LexicographicalListComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        for (int j=0; j<Math.min(s1.length(), s2.length()); j++){
            int n1 = (int) s1.charAt(j);
            int n2 = (int) s2.charAt(j);
            if (n1 < n2) return -1;
            else if (n1 > n2) return 1;
        }
        if (s1.length() < s2.length()) return -1;
        else if (s1.length() > s2.length()) return 1;
        return 0;
    }
}
