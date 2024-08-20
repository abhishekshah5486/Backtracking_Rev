import java.util.*;

public class RatAndMaze_III {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        for (int j=0; j<n; j++){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int k=0; k<n; k++){
                temp.add(scn.nextInt());
            }
            maze.add(temp);
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> currPath = new ArrayList<>();
        for (int j=0; j<n; j++){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int k=0; k<n; k++){
                temp.add(0);
            }
            currPath.add(temp);
        }
        solveRatAndMazeIII(maze, ans, currPath, 0, 0);
        print2DList(ans);

        scn.close();
    }
    public static boolean solveRatAndMazeIII(ArrayList<ArrayList<Integer>> maze, ArrayList<ArrayList<Integer>> ans, ArrayList<ArrayList<Integer>> currPath, int r, int c){
        if (r < 0 || c < 0 || r == maze.size() || c >= maze.get(0).size()) return false;
        if (maze.get(r).get(c) == 0) return false;

        if (r == maze.size() - 1 && c == maze.get(0).size() - 1){
            currPath.get(r).set(c, 1);
            for (int idx=0; idx<currPath.size(); idx++){
                ArrayList<Integer> row = new ArrayList<>(currPath.get(idx));
                ans.add(row);
            }
            return true;
        }
        int[][] directions = {
            {0, 1},
            {1, 0}
        };
        maze.get(r).set(c, 0);
        currPath.get(r).set(c, 1);

        for (int j=0; j<directions.length; j++){
            int nRow = r + directions[j][0];
            int ncol = c + directions[j][1];
            if (solveRatAndMazeIII(maze, ans, currPath, nRow, ncol)){
                return true;
            }
        }
        maze.get(r).set(c, 1);
        return false;
    }
    public static void print2DList(ArrayList<ArrayList<Integer>> arr){
        for (int j=0; j<arr.size(); j++){
            for (int k=0; k<arr.get(j).size(); k++){
                System.out.print(arr.get(j).get(k) + " ");
            }
            System.out.println();
        }
    }
}

// Given a grid A, a rat is at position (1, 1). He wants to go to the position (n, n) where n is size of the square matrix A.
// 1 represents a traversable cell and 0 represents a non-traversable cell. Rat can only move right or down.
// Return a path that the rat can take.