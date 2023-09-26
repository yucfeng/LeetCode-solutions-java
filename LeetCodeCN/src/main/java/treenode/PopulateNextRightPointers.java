package treenode;
// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
public class PopulateNextRightPointers {

    // 将二叉树看做三叉树
    public Node connect(Node root) {
        if (root == null) return root;
        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node cur, Node next) {
        if (cur == null || next == null) return;
        cur.next = next;
        traverse(cur.left, cur.right);
        traverse(cur.right, next.left);
        traverse(next.left, next.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}