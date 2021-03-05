import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
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
