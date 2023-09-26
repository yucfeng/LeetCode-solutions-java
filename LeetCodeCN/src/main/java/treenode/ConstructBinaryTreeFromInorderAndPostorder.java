package treenode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructBinaryTreeFromInorderAndPostorder {

    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd) return null;
        int rootIndex = valToIndex.get(postorder[postEnd]);
        int leftSize = rootIndex - inStart;
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = build(postorder, postStart, postStart + leftSize - 1,
                inorder, inStart, rootIndex - 1);
        root.right = build(postorder, postStart + leftSize, postEnd - 1,
                inorder, rootIndex + 1, inEnd);
        return root;
    }
}
