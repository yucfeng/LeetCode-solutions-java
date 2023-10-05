package treenode.bst;

import org.junit.Test;
import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/unique-binary-search-trees-ii/
public class UniqueBst2 {

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    List<TreeNode> dfs(int l, int r) {
        if (l > r) {
            return new ArrayList<>(){{add(null);}};
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i =l;i<=r;i++) {
            for (TreeNode left : dfs(l, i-1)) {
                for (TreeNode right : dfs(i+1, r)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
