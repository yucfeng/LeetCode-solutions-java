package treenode.bst;

import treenode.TreeNode;

// https://leetcode.cn/problems/delete-node-in-a-bst/
public class DeleteNodeInBst {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key)
            return remoteCurrentNode(root);
        if (root.val < key)
            root.right = deleteNode(root.right, key);
        if (root.val > key)
            root.left = deleteNode(root.left, key);
        return root;
    }

    private TreeNode remoteCurrentNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            root = null;
        } else if (root.left == null) {
            root = root.right;
        } else if (root.right == null) {
            root = root.left;
        } else {
            TreeNode maxNode = getMax(root.left);
            root.left = deleteNode(root.left, maxNode.val);
            maxNode.left = root.left;
            maxNode.right = root.right;
            root = maxNode;
        }
        return root;
    }

    private TreeNode getMax(TreeNode root) {
        if (root.right == null) return root;
        else return getMax(root.right);
    }
}
