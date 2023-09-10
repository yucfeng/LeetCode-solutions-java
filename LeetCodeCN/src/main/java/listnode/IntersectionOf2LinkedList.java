package listnode;

// https://leetcode.cn/problems/intersection-of-two-linked-lists/
public class IntersectionOf2LinkedList {

    // 直接两个链表连一起，长度就一样了
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        if (p1 == null) return null;
        return p1;
    }

    // 如果两个链表长度不一致，补齐
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int l1 = 1, l2 = 1;
        ListNode p1 = headA, p2 = headB;
        while (p1.next != null) {
            p1 = p1.next;
            l1++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            l2++;
        }
        if (p1 != p2) return null;
        int k = Math.abs(l1 - l2);
        if (k != 0) {
            ListNode dummy = new ListNode(-1);
            ListNode newHead = dummy;
            for (int i = 0; i < k - 1; i++) {
                dummy.next = new ListNode(-1);
                dummy = dummy.next;
            }
            if (l1 < l2) {
                dummy.next = headA;
                while (newHead != headB) {
                    newHead = newHead.next;
                    headB = headB.next;
                }
            } else {
                dummy.next = headB;
                while (newHead != headA) {
                    newHead = newHead.next;
                    headA = headA.next;
                }
            }
            return newHead;
        } else {
            while (headB != headA) {
                headB = headB.next;
                headA = headA.next;
            }
            return headA;
        }
    }
}
