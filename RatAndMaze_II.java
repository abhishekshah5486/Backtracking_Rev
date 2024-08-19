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
        List<List<List<Integer>>> ans = new ArrayList<>(); 
        List<List<Integer>> currPath = new ArrayList<>();
        solveRatAndMazeII(ans, maze, currPath, 0, 0);
        System.out.println();
        print3DList(ans);

        scn.close();
    }
    public static void solveRatAndMazeII(List<List<List<Integer>>> ans, List<List<Integer>> maze, List<List<Integer>> currPath, int r, int c){
        if (r < 0 || c < 0 || r >= maze.size() || c >= maze.get(0).size()) return;
        if (maze.get(r).get(c) == 0) return;

        if (r == maze.size() - 1 && c == maze.get(0).size() - 1){
            List<List<Integer>> pathMatrix = helper(maze.size(), currPath);
            ans.add(pathMatrix);
            return;
        }
        // Block the visited cell
        maze.get(r).set(c, 0);
        // Moving Down
        List<Integer> temp = new ArrayList<>();
        temp.add(r + 1);
        temp.add(c);
        currPath.add(temp);
        solveRatAndMazeII(ans, maze, currPath, r+1, c);
        currPath.remove(currPath.size() - 1);

        // Moving Right
        temp.set(0, r);
        temp.set(1, c + 1);
        currPath.add(temp);
        solveRatAndMazeII(ans, maze, currPath, r, c + 1);
        currPath.remove(currPath.size() - 1);

        // Unblock the visited cell 
        maze.get(r).set(c, 1);
    }
    public static List<List<Integer>> helper(int n, List<List<Integer>> currPath){
        List<List<Integer>> pathMatrix = new ArrayList<>();
        for (int j=0; j<n; j++){
            List<Integer> temp = new ArrayList<>();
            for (int k=0; k<n; k++){
                temp.add(0);
            }
            pathMatrix.add(temp);
        }
        pathMatrix.get(0).set(0, 1);
        for (int j=0; j<currPath.size(); j++){
            int r = currPath.get(j).get(0);
            int c = currPath.get(j).get(1);
            pathMatrix.get(r).set(c, 1);
        }
        return pathMatrix;
    }
    public static void print2DList(List<List<Integer>> arr){
        for (int j=0; j<arr.size(); j++){
            for (int k=0; k<arr.get(j).size(); k++){
                System.out.print(arr.get(j).get(k) + " ");
            }
            System.out.println();
        }
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
