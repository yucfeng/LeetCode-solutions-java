import java.util.*;

public class NQueens {
    // 枚举
    // 回溯

    /*
    使用三个集合分别记录每一列以及两个方向的每条斜线
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    /**
     *
     * @param solutions 解
     * @param queens index记录行数，value记录列数，-1置空
     * @param n n
     * @param row 处理到第row行
     * @param columns 不可放置queen的列
     * @param diagonals1 不可放置queen的斜线1从左到右
     * @param diagonals2 不可放置queen的斜线2
     */
    private void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens);
            solutions.add(board);
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
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    private List<String> generateBoard(int[] queens) {
        List<String> board = new ArrayList<String>();
        for (int queen : queens) {
            char[] row = new char[queens.length];
            Arrays.fill(row, '.');
            row[queen] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    /*
    可以用二进制的整数分别记录每一列以及两个方向的每条斜线，从而减少空间
     */
    public void solveNQueens(List<List<String>> results,int[] queens,int n,int row,int columns,int diagonals1,int diagonals2){
        if(row==n){
            results.add(generateBoard(queens));
            return;
        }
        // 1<<n-1 是为了转化一个长度为n的，每位上都是1的二进制数，
        // ~ 取反，用1表示可选的位置
        // 三个整数的按位或运算的结果即为不能放置皇后的位置，其余位置即为可以放置皇后的位置。
        int availableLocations=((1<<n)-1)&(~(columns|diagonals1|diagonals2));
        // 我们通过下面的操作来保持之前所有的行对下一行的影响
        // 左斜边因为下降了一行需要左移一位
        diagonals1<<=1;
        // 右斜边因为下降了一行需要右移一位
        diagonals2>>=1;
        // 开始检查每个可选的位置
        while(availableLocations!=0){
            // 定位最后一个1的位置，这个操作可以自己手写验证一下（不要忘了把负数转成补码）
            // 这个定位的意思是，生成的这个二进制数只有最后一个1还为1，其他位都变成了0
            int position=availableLocations&(-1*availableLocations);
            // 这个方法是统计一个二进制数中所有的“1”的个数
            int columnNum=Integer.bitCount(position-1);
            // 将这个位置添加到记录数组中
            queens[row]=columnNum;
            // 将这一位从可选取的位中移除
            // 减1把最后一个1拆成后面的多个1，再经过一次与操作把这些多出来的1全部清除
            availableLocations=availableLocations&(availableLocations-1);
            // 沿着这个位置向下搜索，可选行和可选列的直接在参数上变化即可，这样就不需要手动重置状态了
            solveNQueens(results,queens,n,row+1,columns|position,diagonals1|position<<1,diagonals2|position>>1);
            // 官方在这里曾经重置过数组queens的状态，但实际上没这个必要，每次循环上一次的结果都会被覆盖
            // queens[row]=-1;
        }
    }
}
