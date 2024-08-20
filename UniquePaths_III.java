import java.util.*;

public class UniquePaths_III{
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
        int countEmptyBlocks = 0;
        int s1 = -1;
        int s2 = -1;
        int e1 = -1;
        int e2 = -1;
        for (int j=0; j<n; j++){
            for (int k=0; k<m; k++){
                if (maze.get(j).get(k) == 1){
                    s1 = j;
                    s2 = k;
                }
                if (maze.get(j).get(k) == 2){
                    e1 = j;
                    e2 = k;
                }
                if (maze.get(j).get(k) == 0) countEmptyBlocks++;
            }
        }
        int ans = solveUniquePathsIII(maze, s1, s2, e1, e2, countEmptyBlocks);
        System.out.println(ans);
        scn.close();
    }
    public static int solveUniquePathsIII(List<List<Integer>> maze, int r, int c, int e1, int e2, int countEmptyBlocks){
        // Base Conditions
        if (r < 0 || c < 0 || r == maze.size() || c == maze.get(0).size()) return 0;
        if (maze.get(r).get(c) == -1) return 0;
        if (maze.get(r).get(c) == 0) countEmptyBlocks--;

        if (r == e1 && c == e2){
            if (countEmptyBlocks == 0){
                return 1;
            }
            return 0;
        }
        int[][] directions = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };
        // Block the current cell
        int finalAns = 0;
        maze.get(r).set(c, -1);
        for (int j=0; j<directions.length; j++){
            int nrow = r + directions[j][0];
            int ncol = c + directions[j][1];
            finalAns += solveUniquePathsIII(maze, nrow, ncol, e1, e2, countEmptyBlocks);
        }
        maze.get(r).set(c, 0);
        return finalAns;
    }
}
