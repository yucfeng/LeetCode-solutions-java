package treenode;

import java.util.Stack;

// https://leetcode.cn/problems/symmetric-tree/
public class SymmetricTree {

    // 双指针
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return dfs(left, right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == right) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

}
