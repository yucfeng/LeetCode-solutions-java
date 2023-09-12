package listnode;

public abstract class ListNodeTraverse {

    void traverse(ListNode head) {
        // 前序遍历代码
        traverse(head.next);
        // 后序遍历代码
    }

}
