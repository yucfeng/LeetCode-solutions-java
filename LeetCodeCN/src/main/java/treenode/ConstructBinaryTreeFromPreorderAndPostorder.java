package treenode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
public class ConstructBinaryTreeFromPreorderAndPostorder {

    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftRootIndex = valToIndex.get(preorder[preStart + 1]);
        int leftSize = leftRootIndex - postStart;
        root.left = build(preorder, preStart + 1, preStart + 1 + leftSize,
                postorder, postStart, leftRootIndex);
        root.right = build(preorder, preStart + 1 + leftSize + 1, preEnd,
                postorder, leftRootIndex + 1, postEnd - 1);
        return root;
    }

    @Test
    public void test() {
        constructFromPrePost(new int[]{1}, new int[]{1});
    }
}
