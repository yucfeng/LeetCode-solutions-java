import com.yucfeng.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = head;
        if (head == null || head.next == null || k == 1) return res;
        boolean isHead = true;
        ListNode lastNode = null;
        while (!isLastGroup(head, k)) {
            ListNode lastMoveNode = head;
            ListNode nextNode = head;
            ListNode curMoveNode = null;
            for (int i = 0; i < k - 1; i++) {
                lastMoveNode = lastMoveNode.next;
                // reverse
                curMoveNode = new ListNode(lastMoveNode.val);
                curMoveNode.next = nextNode;
                nextNode = curMoveNode;
            }
            if (!isHead) {
                lastNode.next = curMoveNode;
            } else {
                res = nextNode;
                isHead = false;
            }
            head.next = lastMoveNode.next;
            lastNode = head;
            head = head.next;
        }
        return res;
    }

    public boolean isLastGroup(ListNode node, int k) {
        int i = 0;
        while (node != null) {
            node = node.next;
            i++;
        }
        if (i < k )return true;
        return false;
    }
}
