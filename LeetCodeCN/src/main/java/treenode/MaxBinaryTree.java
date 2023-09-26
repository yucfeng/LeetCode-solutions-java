package treenode;
// https://leetcode.cn/problems/maximum-binary-tree/
public class MaxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);
        return root;
    }
}
