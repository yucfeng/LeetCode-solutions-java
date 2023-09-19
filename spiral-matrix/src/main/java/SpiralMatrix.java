import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
n[0][0], n[0][1], n[0][2],
n[1][0], n[1][1], n[1][2],
n[2][0], n[2][1], n[2][2]
 */
public class SpiralMatrix {

    // 按照右、下、左、上的顺序遍历数组，并使用四个变量圈定未遍历元素的边界
    List<Integer> spiralOrder2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upper_bound = 0, lower_bound = m - 1;
        int left_bound = 0, right_bound = n - 1;
        List<Integer> res = new LinkedList<>();
        // res.size() == m * n 则遍历完整个数组
        while (res.size() < m * n) {
            if (upper_bound <= lower_bound) {
                // 在顶部从左向右遍历
                for (int j = left_bound; j <= right_bound; j++) {
                    res.add(matrix[upper_bound][j]);
                }
                // 上边界下移
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                // 在右侧从上向下遍历
                for (int i = upper_bound; i <= lower_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                // 右边界左移
                right_bound--;
            }

            if (upper_bound <= lower_bound) {
                // 在底部从右向左遍历
                for (int j = right_bound; j >= left_bound; j--) {
                    res.add(matrix[lower_bound][j]);
                }
                // 下边界上移
                lower_bound--;
            }

            if (left_bound <= right_bound) {
                // 在左侧从下向上遍历
                for (int i = lower_bound; i >= upper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                // 左边界右移
                left_bound++;
            }
        }
        return res;
    }


    // 一层层递进
    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralOrder(new ArrayList<>(), matrix, matrix.length, matrix[0].length);
    }

    private List<Integer> spiralOrder(List<Integer> list, int[][] matrix, int rowsNum, int colNum) {
        int rowsStart = (matrix.length - rowsNum) >> 1;
        int colStart = (matrix[0].length - colNum) >> 1;
        if (rowsNum <= 1 || colNum <= 1) {
            return generateList(list, matrix, rowsNum, colNum);
        }
        for (int i = colStart; i < colStart + colNum; i++) {
            list.add(matrix[rowsStart][i]);
        }
        for (int i = rowsStart + 1; i < rowsStart + rowsNum; i++) {
            list.add(matrix[i][colStart + colNum - 1]);
        }
        for (int i = colStart + colNum - 2; i >= colStart; i--) {
            list.add(matrix[rowsStart + rowsNum - 1][i]);
        }
        for (int i = rowsStart + rowsNum - 2; i > rowsStart; i--) {
            list.add(matrix[i][colStart]);
        }
        return spiralOrder(list, matrix, rowsNum - 2, colNum - 2); // 缩小矩阵
    }

    private List<Integer> generateList(List<Integer> list, int[][] matrix, int rowsNum, int colNum) {
        int rowsStart = (matrix.length - rowsNum) >> 1;
        int colStart = (matrix[0].length - colNum) >> 1;
        if (rowsNum == 0 || colNum == 0) {
            return list;
        }
        if (rowsNum == 1) {
            for (int i = colStart; i < colStart + colNum; i++) {
                list.add(matrix[rowsStart][i]);
            }
            return list;
        }

        if (colNum == 1) {
            for (int i = rowsStart; i < rowsStart + rowsNum; i++) {
                list.add(matrix[i][colStart]);
            }
            return list;
        }
        return list;
    }
}
