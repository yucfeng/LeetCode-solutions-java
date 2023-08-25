package dfs;

import org.junit.Test;
import structure.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return dfs(root,  Long.MIN_VALUE , Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long l, long r) {
        if (root == null) return true;
        if (root.val <= l || root.val >= r)
            return false;
        return dfs(root.left, l , root.val) && dfs(root.right, root.val, r);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }
}

