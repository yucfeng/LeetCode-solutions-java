package treenode.bst;

import treenode.TreeNode;

// https://leetcode.cn/problems/insert-into-a-binary-search-tree/
public class InsertIntoBst {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
//        if (root.val == val)
            // 找到目标，做点什么
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}
