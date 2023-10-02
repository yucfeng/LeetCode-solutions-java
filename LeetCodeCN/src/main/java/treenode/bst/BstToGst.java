package treenode.bst;

import treenode.TreeNode;

// https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/
public class BstToGst {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    // 中序遍历 -> 降序
    void traverse(TreeNode root) {
        if (root == null) return;
        // 先递归遍历右子树
        traverse(root.right);
        // 中序遍历代码位置
        sum += root.val;
        root.val = sum;
        // 后递归遍历左子树
        traverse(root.left);
    }
}
