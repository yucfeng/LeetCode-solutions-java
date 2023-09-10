package listnode;

// https://leetcode.cn/problems/reverse-linked-list
public class RevertLinkedList {

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode end = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return end;
    }

    // 迭代
    public ListNode reverseList2(ListNode head) {
        ListNode pre, cur, nxt;
        pre = null; cur = head; nxt = head;
        while (cur != null) {
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

}
