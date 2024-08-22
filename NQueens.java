import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        List<List<Character>> arr = new ArrayList<>();
        for (int j=0; j<n; j++){
            List<Character> temp = new ArrayList<>();
            for (int k=0; k<n; k++){
                temp.add('.');
            }
            arr.add(temp);
        }
        List<List<String>> ans = new ArrayList<>();
        solveNQueens(ans, arr, 0, n);
        print3DList(ans);
        System.out.println(ans.size());

        scn.close();
    }
    public static void solveNQueens(List<List<String>> ans, List<List<Character>> arr, int r, int countQueens){
        if (r == arr.size()){
            List<String> replicateNQueen = new ArrayList<>();
            for (int j=0; j<arr.size(); j++){
                StringBuilder sb = new StringBuilder();
                for (int k=0; k<arr.get(0).size(); k++){
                    sb.append(arr.get(j).get(k));
                }
                replicateNQueen.add(sb.toString());
            }
            ans.add(replicateNQueen);
            return;
        }
        for (int j=0; j<arr.get(0).size(); j++){
            if (isValidNQueen(arr, r, j)){
                arr.get(r).set(j, 'Q');
                solveNQueens(ans, arr, r + 1, countQueens);
                arr.get(r).set(j, '.');
            }
        }
    }
    public static boolean isValidNQueen(List<List<Character>> arr, int r, int c){
        // Check for the same column
        for (int j=0; j<arr.size(); j++){
            if (arr.get(j).get(c) == 'Q') return false;
        }

        // Check for Upper Left Diagonal
        int nr = r;
        int nc = c;
        while (nr >= 0 && nc >= 0){
            if (arr.get(nr).get(nc) == 'Q') return false;
            nr--;
            nc--;
        }

        // Check for the Upper Right Diagonal
        nr = r;
        nc = c;
        while (nr >= 0 && nc < arr.get(0).size()){
            if (arr.get(nr).get(nc) == 'Q') return false;
            nr--;
            nc++;
        }
        return true;
    }
    public static void print3DList(List<List<String>> ans){
        for (int j=0; j<ans.size(); j++){
            for (int k=0; k<ans.get(0).size(); k++){
                for (int z=0; z<ans.get(0).get(0).length(); z++){
                    System.out.print(ans.get(j).get(k).charAt(z) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
