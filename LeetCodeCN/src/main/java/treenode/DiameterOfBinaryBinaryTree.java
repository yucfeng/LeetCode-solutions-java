package treenode;

// https://leetcode.cn/problems/diameter-of-binary-tree/
public class DiameterOfBinaryBinaryTree {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        maxDepth(root);
        return res;
    }

    /** 该根节点的直径 = 左子树的深度 + 右子树的深度
     * @param root 根节点
     * @return root 的深度
     */
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        res = Math.max(leftDepth + rightDepth, res);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
