package listnode;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val != cur.next.val) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        ListNode p = head;
        ListNode q = p.next;
        while (q != null) {
            if (p.val != q.val) {
                p = q;
                q = q.next;
                continue;
            }
            while (q != null && p.val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
            if (q != null) {
                q = q.next;
            }
        }
        return head;
    }
}
