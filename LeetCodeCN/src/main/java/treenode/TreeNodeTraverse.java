package treenode;

public abstract class TreeNodeTraverse {

    void traverse(TreeNode root) {
        // 前序遍历代码
        traverse(root.left);
        // 中序遍历代码
        traverse(root.right);
        // 后序遍历代码
    }

}
