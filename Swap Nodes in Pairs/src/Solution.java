/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Author: yucfeng
 * Date: 2018/7/18
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        /**
         * constant extra space
         */
        ListNode res = head;
        if (head == null || head.next == null) return res;
        boolean isHead = true;
        ListNode lastNode = null;
        while (true) {
            ListNode tmpNode = new ListNode(head.next.val);
            if (!isHead) {
                lastNode.next = tmpNode;
            } else {
                res = tmpNode;
            }
            lastNode = new ListNode(head.val);
            tmpNode.next = lastNode;
            if (head.next == null || head.next.next == null) break;
            lastNode.next = head.next.next;
            if(isHead) isHead = false;
            head = head.next.next;
            if (head.next == null) break;
        }
        return res;
        /**
         * use recursion
         */
//        if (head == null || head.next == null) return head;
//        ListNode nextPair = head.next.next;
//        ListNode res = head.next;
//        head.next = swapPairs(nextPair);
//        res.next = head;
//        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode curNode = l1;
        int len = 0;
        while (curNode != null) {
            len++;
            curNode = curNode.next;
        }
        System.out.println(len);
        System.out.print(l1.val);
    }
}
