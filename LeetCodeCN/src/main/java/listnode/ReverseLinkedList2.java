package listnode;

public class ReverseLinkedList2 {

    ListNode successor = null;

    // 转化成reverseN
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left-1, right-1);

        return head;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    // 转化成reverseList
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode beforeLeft = dummy;
        ListNode rightNode = dummy;
        for (int i=0;i<left-1;i++) {
            beforeLeft = beforeLeft.next;
        }
        for (int i=0;i<right;i++) {
            rightNode = rightNode.next;
        }

        ListNode newHead = reverseList(beforeLeft.next, rightNode.next);
        beforeLeft.next = newHead;
        return dummy.next;
    }

    public ListNode reverseList(ListNode head, ListNode end) {
        if (head == end || head.next == end) return head;
        ListNode last = reverseList(head.next, end);
        head.next.next = head;
        head.next = end;

        return last;
    }


}
