package backtrack;

public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        for (int i=0;i<n;i++){
            ans += mat[i][i];
            ans += mat[i][n-1-i];
        }
        if (n%2==1) {
            ans -= mat[n/2][n/2];
        }
        return ans;
    }
}
