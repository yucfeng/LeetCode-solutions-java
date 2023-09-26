package treenode;
// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTree2LinkedList {

    // 1. 将左子树移动到root右分支
    // 2. 将原右子树接在原左子树末尾
    public static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;
        TreeNode left = root.left;

        root.right = left;
        root.left = null;

        TreeNode leftEnd = root;
        while (leftEnd.right != null) {
            leftEnd = leftEnd.right;
        }
        leftEnd.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2  = new TreeNode(2);
        root2.left = new TreeNode(3);
        root.right = root2;
        flatten(root);
    }
}
