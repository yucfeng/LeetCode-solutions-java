import java.util.HashSet;
import java.util.Set;

/**
 *Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *     Each row must contain the digits 1-9 without repetition.
 *     Each column must contain the digits 1-9 without repetition.
 *     Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *     Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 */

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] digits = new int[10];
        // validate row
        for (char[] row : board) {
            for (char num : row) {
                if (num == '.') continue;
                else {
                    if (digits[Integer.parseInt(String.valueOf(num))] != 0) return false;
                    else
                        digits[Integer.parseInt(String.valueOf(num))] = 1;
                }
            }
            digits = new int[10];
        }
        // validate column
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<9; j++) {
                if (board[j][i] == '.') continue;
                else {
                    if (digits[Integer.parseInt(String.valueOf(board[j][i]))] != 0) return false;
                    else
                        digits[Integer.parseInt(String.valueOf(board[j][i]))] = 1;
                }
            }
            digits = new int[10];
        }
        // validate sub-boxes
        intF[][] nums = {{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
        for (int[] num : nums) {
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    if (board[num[0]*3 + j][num[1]*3 + i] == '.') continue;
                    else {
                        if (digits[Integer.parseInt(String.valueOf(board[num[0]*3 + j][num[1]*3 + i]))] != 0) return false;
                        else
                            digits[Integer.parseInt(String.valueOf(board[num[0]*3 + j][num[1]*3 + i]))] = 1;
                    }
                }
            }
            digits = new int[10];
        }

        // use HashSet
        Set seen = new HashSet<String>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }

        return true;
    }
}
