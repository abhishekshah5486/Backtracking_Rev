import java.util.*;

public class RatAndCheese_IV {
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
        int r1 = scn.nextInt(); // 1-based indexing
        int r2 = scn.nextInt(); // 1-based indexing
        int e1 = scn.nextInt(); // 1-based indexing
        int e2 = scn.nextInt(); // 1-based indexing
        int countCheese = 0;
        for (int j=0; j<n; j++){
            for (int k=0; k<m; k++){
                if (maze.get(j).get(k) == 0) countCheese++;
            }
        }
        List<List<List<Integer>>> ans = new ArrayList<>();
        List<List<Integer>> currPath = new ArrayList<>();
        for (int j=0; j<n; j++){
            List<Integer> temp = new ArrayList<>();
            for (int k=0; k<m; k++){
                temp.add(0);
            }
            currPath.add(temp);
        }
        solveRatAndCheeseIV(ans, maze, currPath, r1-1, r2-1, e1-1, e2-1, countCheese);
        print3DList(ans);
        System.out.println(ans.size());
        
        scn.close();
    }
    public static void solveRatAndCheeseIV( List<List<List<Integer>>> ans, List<List<Integer>> maze, List<List<Integer>> currPath, int r, int c, int e1, int e2, int countCheese){
        // Base Conditions
        if (r < 0 || c < 0 || r >= maze.size() || c >= maze.get(0).size()) return;
        if (maze.get(r).get(c) == 1) return;
        if (maze.get(r).get(c) == 0) countCheese--;

        if (r == e1 && c == e2){
            if (countCheese == 0){
                currPath.get(r).set(c, 1);
                List<List<Integer>> replicatePath = new ArrayList<>();
                for (int j=0; j<currPath.size(); j++){
                    List<Integer> temp = new ArrayList<>(currPath.get(j));
                    replicatePath.add(temp);
                }
                ans.add(replicatePath);
            }
            return;
        }
        int[][] directions = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };
        // Blocking the current cell
        int blockedVal = maze.get(r).get(c);
        maze.get(r).set(c, 1);
        currPath.get(r).set(c, 1);
        for (int j=0; j<directions.length; j++){
            int nr = r + directions[j][0];
            int nc = c + directions[j][1];
            solveRatAndCheeseIV(ans, maze, currPath, nr, nc, e1, e2, countCheese);
        }
        maze.get(r).set(c, blockedVal);
        currPath.get(r).set(c, 0);
    }
    public static void print3DList(List<List<List<Integer>>> arr){
        for (int i=0; i<arr.size(); i++){
            for (int j=0; j<arr.get(0).size(); j++){
                for (int k=0; k<arr.get(0).get(0).size(); k++){
                    System.out.print(arr.get(i).get(j).get(k) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

// Q. Given
//     Start point of rat (ri, rj)
//     End point of rat (ei, ej)
//     Cells with cheese (A[i][j] = 0)
//     Blocked cells (A[i][j] = 1)
//     Empty cells (A[i][j] = 2)
// Count number of paths from (ri, rj) to (ei, ej) such that the rat can eat all the cheese in the maze.

