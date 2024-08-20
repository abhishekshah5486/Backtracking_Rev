import java.util.*;

public class UniquePaths_I {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int ans = uniquePaths(m, n);
        System.out.println(ans);
        scn.close();
    }
    public static int uniquePaths(int m, int n){
        if (m <= 0 || n <= 0 ) return 0;
        if (m == 1 && n == 1) return 1;

        int[][] directions = {
            {-1, 0},
            {0, -1}
        };
        int ans = 0;
        for (int j=0; j<directions.length; j++){
            int nrow = m + directions[j][0];
            int ncol = n + directions[j][1];

            ans += uniquePaths(nrow, ncol);
        }
        return ans;
    }
}
