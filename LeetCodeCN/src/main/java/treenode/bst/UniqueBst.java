package treenode.bst;

import org.junit.Test;

// https://leetcode.cn/problems/unique-binary-search-trees/
public class UniqueBst {

    public int numTrees(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i=1; i<=n;i++) {
            for (int j=1;j<=i;j++) {
                f[i] += f[j-1] * f[i-j];
            }
        }
        return f[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(4));
    }
}
