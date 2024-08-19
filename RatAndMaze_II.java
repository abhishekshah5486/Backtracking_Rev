import java.util.*;

public class RatAndMaze_II {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<List<Integer>> maze = new ArrayList<>();
        for (int j=0; j<n; j++){
            List<Integer> temp = new ArrayList<>();
            for (int k=0; k<n; k++){
                temp.add(scn.nextInt());
            }
            maze.add(temp);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int j=0; j<n; j++){
            List<Integer> temp = new ArrayList<>();
            for (int k=0; k<n; k++){
                temp.add(0);
            }
            ans.add(temp);
        }
        List<List<Integer>> currPath = new ArrayList<>();
        solveRatAndMazeII(ans, maze, currPath, 0, 0);
        scn.close();
    }
    public static void solveRatAndMazeII(List<List<Integer>> ans, List<List<Integer>> maze, List<List<Integer>> currPath, int r, int c){

        // DLRU Approch
        // Block the visited cell
        maze.get(r).set(c, 0);
        // Down Left Right Up
        int directions = 
        // Unblock the visited cell 
        maze.get(r).set(c, 1);
    }
}
