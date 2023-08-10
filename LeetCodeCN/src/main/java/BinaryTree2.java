import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree2 {

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;
        System.out.println(levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        if (root == null) {
            return arr;
        }

        List<TreeNode> curNodes = new ArrayList<>();
        curNodes.add(root);

        while (curNodes.size() > 0) {
            List<Integer> tmpArr = new ArrayList<>();
            List<TreeNode> tmpNodes = new ArrayList<>();
            for (TreeNode node : curNodes) {
                tmpArr.add(node.val);
                if (node.left != null) tmpNodes.add(node.left);
                if (node.right != null) tmpNodes.add(node.right);
            }

            arr.add(tmpArr);
            curNodes = tmpNodes;
        }
        return arr;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}