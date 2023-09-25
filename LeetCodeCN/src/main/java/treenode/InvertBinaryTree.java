package treenode;
// https://leetcode.cn/problems/invert-binary-tree/
public class InvertBinaryTree {

    // 传入一个root节点，翻转该节点的二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
