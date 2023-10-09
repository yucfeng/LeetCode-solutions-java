package treenode;

import java.util.Stack;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果p、q都在左边，则left不为null；如果p、q都在右边，则right不为null
        if (left != null && right != null) {
            // 当前节点就是最近祖先
            return root;
        }
        return left == null ? right : left;
    }

}
