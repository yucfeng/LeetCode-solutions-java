package treenode;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorderAndInorder {

    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR) return null;
        int rootIndex = valToIndex.get(preorder[preL]);
        int leftSize = rootIndex - inL;
        TreeNode root = new TreeNode(preorder[preL]);
        root.left = build(preorder, preL + 1, preL + leftSize,
                inorder, inL, rootIndex - 1);
        root.right = build(preorder, preL + leftSize + 1, preR,
                inorder, rootIndex + 1, inR);
        return root;
    }
}
