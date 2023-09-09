package structure;

// https://leetcode.cn/problems/middle-of-the-linked-list/
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!=null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
