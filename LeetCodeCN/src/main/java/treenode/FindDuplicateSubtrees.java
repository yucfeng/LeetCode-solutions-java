package treenode;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.cn/problems/find-duplicate-subtrees/
public class FindDuplicateSubtrees {

    Map<String, TreeNode> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    // 序列化子树
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return new ArrayList<>(repeat);
    }

    private String traverse(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(root.val);
        String left = traverse(root.left);
        if (!left.equals("[]")) {
            if (seen.containsKey(left)) {
                repeat.add(seen.get(left));
            } else {
                seen.put(left, root.left);
            }
        }
        sb.append(left);

        String right = traverse(root.right);
        if (!right.equals("[]")) {
            if (seen.containsKey(right)) {
                repeat.add(seen.get(right));
            } else {
                seen.put(right, root.right);
            }
        }
        sb.append(right);
        sb.append("]");
//        System.out.println(seen);
        return sb.toString();
    }
}
