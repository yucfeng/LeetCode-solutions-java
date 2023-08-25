// https://leetcode.cn/problems/count-good-nodes-in-binary-tree/description/
public class CountGoodNodesInBinaryTree {

    int ans = 1;

    public int goodNodes(TreeNode root) {
        dfs(root.right, root.val);
        dfs(root.left, root.val);
        return ans;
    }

    private void dfs (TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) {
            max = node.val;
            ans ++;
        }
        dfs(node.right, max);
        dfs(node.left, max);
    }
}
