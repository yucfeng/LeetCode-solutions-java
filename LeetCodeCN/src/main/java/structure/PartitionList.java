package structure;

// https://leetcode.cn/problems/partition-list/
public class PartitionList {

    // 双指针 双链表
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        while(head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
