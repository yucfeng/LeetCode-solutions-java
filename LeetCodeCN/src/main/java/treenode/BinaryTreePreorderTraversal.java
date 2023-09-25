package treenode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return res;
        }
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    // 分解成子问题 （不推荐）
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}
