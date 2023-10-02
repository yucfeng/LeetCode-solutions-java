package treenode.bst;

import org.junit.Test;
import treenode.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/
public class ValidateBst {

    public boolean isValidBST(TreeNode root) {

        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min) {
            return false;
        }
        if (root.val >= max) {
            return false;
        }
        return isValid(root.left, min, root.val) &&
                isValid(root.right, root.val, max);
    }

    @Test
    public void test() {
        System.out.println(isValidBST(new TreeNode(2147483647)));
    }

    // Long 类型数据占用内存较大，改成null。
    boolean isValidBST2(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

}
