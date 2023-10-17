package graph;
// https://leetcode.cn/problems/find-the-celebrity/
public class FindTheCelebrity {

    int[][] graph;
    /*
    [
    [1,1,1,0],
    [1,1,1,1],
    [0,0,1,0],
    [0,0,1,1]
    ]
     */

    public FindTheCelebrity(int[][] graph) {
        this.graph = graph;
    }

    boolean knows(int i, int j) {
        return graph[i][j] == 1;
    }

    // 请你实现：返回「名人」的编号
    int findCelebrity(int n) {
        int[] known = new int[n];
        int[] knows = new int[n];
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (knows(i, j)) {
                    knows[i] ++;
                    known[j] ++;
                }
            }
        }
        for (int i=0;i<n;i++) {
            if (knows[i] == 4 && known[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    int findCelebrity2(int n) {
        // 先假设 0 是名人
        int cand = 0;
        for (int other = 1; other < n; other++) {
            if (!knows(other, cand) || knows(cand, other)) {
                // cand 不可能是名人，排除
                // 假设 other 是名人
                cand = other;
            } else {
                // other 不可能是名人，排除
                // 什么都不用做，继续假设 cand 是名人
            }
        }

        // 现在的 cand 是排除的最后结果，但不能保证一定是名人
        for (int other = 0; other < n; other++) {
            if (cand == other) continue;
            // 需要保证其他人都认识 cand，且 cand 不认识任何其他人
            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }

        return cand;
    }

}
