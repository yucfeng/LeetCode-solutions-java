package listnode;

// https://leetcode.cn/problems/reverse-nodes-in-k-group/
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        for (int i=0;i<k;i++) {
            if (b==null) return head;
            b = b.next;
        }
        // b 此时指向下一段k链表的开头节点。
        ListNode newHead = reverseList(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public ListNode reverseList(ListNode head, ListNode b) {
        if (head == b || head.next == b) return head;
        ListNode end = reverseList(head.next, b);
        head.next.next = head;
        head.next = b;

        return end;
    }
}
