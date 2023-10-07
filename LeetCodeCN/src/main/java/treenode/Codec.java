package treenode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

// https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class Codec {

    private final String SPLIT = ",";
    private final String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return NULL + SPLIT;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(SPLIT);
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SPLIT);
        LinkedList<String> nodeList = new LinkedList<>(Arrays.asList(nodes));
        return build(nodeList);
    }

    /**
     * @param nodeList 以root节点为开头的list
     * @return root 子树
     */
    private TreeNode build(LinkedList<String> nodeList) {
        if (NULL.equals(nodeList.get(0))) {
            nodeList.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodeList.get(0)));
        nodeList.removeFirst();
        root.left = build(nodeList);
        root.right = build(nodeList);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String a = serialize(root);
        System.out.println(a);
        TreeNode root2 = deserialize(a);
    }
}
