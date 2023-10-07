package treenode.bst;

import treenode.TreeNode;

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInBst {

    int ans;
    int size;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }

    void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        // 中序遍历代码
        size++;
        if (size == k) {
            ans = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
