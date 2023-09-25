package treenode;
// https://leetcode.cn/problems/maximum-depth-of-binary-tree/
public class MaxDepthOfBinaryTree {

    int res= 0;
    int depth=0;

    // 遍历二叉树
    public int maxDepth2(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        if (root.left == null && root.right==null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        // 中序位置
        traverse(root.right);
        // 后序位置
        depth--;
    }

    // 分解成子问题
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
