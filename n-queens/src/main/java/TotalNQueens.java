import java.util.*;

public class TotalNQueens {

    int i = 0;

    public int totalNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(queens, n, 0, columns, diagonals1, diagonals2);
        return i;
    }

    private void backtrack(int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
             i ++;
        } else {
            for (int i = 0; i < n; i++) { // 代表列数的下表i
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i; // 列下标与行下表的差相等，则两点在同一斜线上
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i; // 列下标与行下表的和相等，则两点在同一斜线上
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }
}
