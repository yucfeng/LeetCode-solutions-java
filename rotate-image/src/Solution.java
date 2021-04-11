import java.util.Arrays;

public class Solution {
    public void rotate2(int[][] matrix) {
        int len = matrix.length;
        int[] tmp = new int[len-1];  // tmp 应该存储一轮要rotate的四个元素 int[] tmp = new int[4];
        doRotate(matrix, tmp, 0, len);
    }

    private void doRotate(int[][] matrix, int[] tmp, int start, int len) {
        if (len == 1 || len == 0) return;
        for (int i=start; i<start+len-1; i++) {
            tmp[i] = matrix[0][i];
            matrix[0][i] = matrix[len-(i+1)][0];  // TODO
            matrix[i+1][0] = matrix[len-1][i+1];
            matrix[len-1][i+1] = matrix[len - (i+2)][len-1]; // TODO fix
            matrix[i][len-1] = tmp[i];
        }
        doRotate(matrix, tmp, start+1, len-2);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

    public void rotate1(int[][] matrix) {
        int len = matrix.length;
        int[][] tmp = new int[len][len];
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                tmp[j][len-1-i] = matrix[i][j];
            }
        }
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                matrix[i][j] = tmp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9, 10, 11, 12}, {13,14,15,16}, {13,14,15,16}};
//        Solution solution = new Solution();
//        solution.rotate(matrix);
//        System.out.println(Arrays.deepToString(matrix));
        System.out.println(matrix[0][1]);
        System.out.println(matrix.length);
    }
}
