import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

n[0][0], n[0][1], n[0][2],
n[1][0], n[1][1], n[1][2],
n[2][0], n[2][1], n[2][2]
 */

public class SpiralMatrix2 {

    public int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int upper_bound = 0, lower_bound = n - 1;
        int left_bound = 0, right_bound = n - 1;

        int num = 1;
        while (num <= n * n) {
            // -->
            if (upper_bound <= lower_bound) {
                for (int i = left_bound; i <= right_bound; i++) {
                    matrix[upper_bound][i] = num;
                    num++;
                }
                upper_bound++;
            }
            // 向下
            if (left_bound <= right_bound) {
                for (int i = upper_bound; i <=lower_bound; i++) {
                    matrix[i][right_bound] = num;
                    num++;
                }
                right_bound--;
            }
            // <--
            if (upper_bound <= lower_bound) {
                for (int i = right_bound; i >= left_bound; i--) {
                    matrix[lower_bound][i] = num++;
                }
                lower_bound--;
            }
            // 向上
            if (left_bound <= right_bound) {
                for (int i = lower_bound; i >= upper_bound; i--) {
                    matrix[i][left_bound] = num++;
                }
                left_bound++;
            }
        }
        return matrix;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        return spiralOrder(matrix, n, 1);
    }

    private int[][] spiralOrder(int[][] matrix, int n, int num) {
        int rowsStart = (matrix.length - n) >> 1;
        int colStart = (matrix[0].length - n) >> 1;
        if (n == 0) {
            return matrix;
        }
        if (n <= 1) {
            matrix[rowsStart][colStart] = num;
            return matrix;
        }
        for (int i = colStart; i < colStart + n; i++) { //→
            matrix[rowsStart][i] = num;
            num++;
        }
        for (int i = rowsStart + 1; i < rowsStart + n; i++) { //↓
            matrix[i][colStart + n - 1] = num;
            num++;
        }
        for (int i = colStart + n - 2; i >= colStart; i--) {  // ←
            matrix[rowsStart + n - 1][i] = num;
            num++;
        }
        if (n != 2) {
            for (int i = rowsStart + n - 2; i > rowsStart; i--) { // ↑
                matrix[i][colStart] = num;
                num++;
            }
        }
        return spiralOrder(matrix, n - 2, num); // 缩小
    }

    @Test
    public void test() {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        spiralMatrix2.generateMatrix(2);
    }
}
