package treenode;
// https://leetcode.cn/problems/count-complete-tree-nodes/
public class CountCompleteTreeNodes {

    int ans;
    // O(N)
    public int countNodes(TreeNode root) {
        traverse(root);
        return ans;
    }

    void traverse(TreeNode root) {
        if (root == null) return;
        ans++;
        traverse(root.left);
        traverse(root.right);
    }

    public int countNodes2(TreeNode root) {
        TreeNode l = root, r = root;
        // 沿最左侧和最右侧分别计算高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右侧计算的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }
        // 如果左右侧的高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
