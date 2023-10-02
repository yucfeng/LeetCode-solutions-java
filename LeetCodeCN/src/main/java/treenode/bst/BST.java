package treenode.bst;

import treenode.TreeNode;

public class BST {

    void bst(TreeNode root, int target) {
        if (root.val == target)
            // 找到目标，做点什么
            System.out.println("");
        if (root.val < target)
            bst(root.right, target);
        if (root.val > target)
            bst(root.left, target);
    }

}
