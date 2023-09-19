package array;

// https://leetcode.cn/problems/rotate-image/
public class RotateImage {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // 按对角线翻转
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 翻转每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    public void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
