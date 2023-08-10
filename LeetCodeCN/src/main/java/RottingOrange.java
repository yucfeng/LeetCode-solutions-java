import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/*
https://leetcode.cn/problems/rotting-oranges/
 */
public class RottingOrange {

    // di,dj 配合使用得到 grid[i][j] 上grid[i-1][j]左grid[i][j-1]下grid[i+1][j]右grid[i][j+1]的元素
    int[] di = new int[]{-1, 0, 1, 0};
    int[] dj = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>(); // 每个坐标能用i*n+j转换成int
        Map<Integer, Integer> depth = new HashMap<>();
        for (int i=0;i<m;i++) {
             for (int j=0; j<n;j++) {
                 if (grid[i][j] == 2) {
                     int code = i*n+j;
                     queue.add(code);
                     depth.put(code, 0); //存储橘子变为腐烂时的时间,key为橘子的一维数组下标，value为变腐烂的时间
                 }
             }
        }
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int i = code/n;
            int j = code%n;
            for (int k = 0; k < 4; ++k) {
                int ni = i + di[k];
                int nj = j + dj[k];
                // 如果没有到达边界，且发现新鲜橘子
                if (0 <= ni && ni < m && 0 <= nj && nj < n && grid[ni][nj] == 1) {
                    grid[ni][nj] = 2;
                    int ncode = ni * n + nj;
                    queue.add(ncode);
                    // 计次的关键 元素 grid[i][j] 的上左下右元素得腐烂时间应该一致
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        //检查grid，此时的grid能被感染已经都腐烂了，此时还新鲜的橘子无法被感染
        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;
    }
}
