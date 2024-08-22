import java.util.*;

public class SudokuSolver {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();

        List<List<Character>> sudoku = new ArrayList<>();
        for (int j=0; j<n; j++){
            String str = scn.nextLine();
            List<Character> temp = new ArrayList<>();
            for (int k=0; k<str.length(); k++){
                temp.add(str.charAt(k));
            }
            sudoku.add(temp);
        }
        List<List<List<Character>>> ans = new ArrayList<>();
        String auxilString = "123456789";
        solveSudokuSolver(ans, sudoku, 0, 0, auxilString);
        System.out.println();
        print3DCharacterList(ans);
        System.out.println(ans.size());
        scn.close();
    }
    public static void solveSudokuSolver(List<List<List<Character>>> ans,  List<List<Character>> sudoku, int r,  int c, String auxilString){
        // Base Conditions
        if (r == 9){
            List<List<Character>> replicateSolvedSudoku = new ArrayList<>();
            for (int j=0; j<sudoku.size(); j++){
                List<Character> temp = new ArrayList<>(sudoku.get(j));
                replicateSolvedSudoku.add(temp);
            }
            ans.add(replicateSolvedSudoku);
            return;
        }
        if (c == 9){
            solveSudokuSolver(ans, sudoku, r + 1, 0, auxilString);
            return;
        }
        if (sudoku.get(r).get(c) != '.') solveSudokuSolver(ans, sudoku, r, c + 1, auxilString);

        if (sudoku.get(r).get(c) == '.'){
            for (int j=0; j<auxilString.length(); j++){
                char temp = auxilString.charAt(j);
                if (checkIfValidSudoku(sudoku, r, c, temp)){
                    sudoku.get(r).set(c, temp);
                    solveSudokuSolver(ans, sudoku, r, c + 1, auxilString);
                }
            }
            sudoku.get(r).set(c, '.');
        }
    }
    public static boolean checkIfValidSudoku(List<List<Character>> sudoku, int r, int c, char target){
        // Check for row validity
        for (int j=0; j<sudoku.get(0).size(); j++){
            if (sudoku.get(r).get(j) == target) return false;
        }
        // Check for column validity
        for (int j=0; j<sudoku.size(); j++){
            if (sudoku.get(j).get(c) == target) return false;
        }
        // Check for 3X3 board validity
        for (int j=0; j<9; j++){
            int nr = (3 * (r/3) + j/3);
            int nc = (3 * (c/3) + j%3);
            if (sudoku.get(nr).get(nc) == target) return false;
        }
        return true;
    }
    public static void print3DCharacterList(List<List<List<Character>>> arr){
        for (int j=0; j<arr.size(); j++){
            for (int k=0; k<arr.get(0).size(); k++){
                for (int z=0; z<arr.get(0).get(0).size(); z++){
                    System.out.print(arr.get(j).get(k).get(z) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

// Rules for sudoku solver
// The digits 1-9 should appear exactly once in any given row
// The digits 1-9 should appear exactly once in any given column
// The digits 1-9 should appear exactly once in any 3X3 board.
