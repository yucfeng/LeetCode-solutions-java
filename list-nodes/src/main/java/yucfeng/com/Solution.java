package yucfeng.com;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Could you do this in one pass?
 * Given n will always be valid.
 * Date: 2018/5/18
 * Author: yucfeng
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode lastNode = null;
        /**
         * two pass algorithm:
         * in first pass, get the length of the linked list
         * in second pass, remove the n-th node from the end.
         */
        //....
        /**
         * one pass algorithm:
         */
        ListNode curNode = head;
        ListNode anotherNode = head;
        int i = 0;
        while (i < n - 1) {
            anotherNode = anotherNode.next;
            i++;
        }
        while (true) {
            if (anotherNode.next == null) {
                if (lastNode == null) {
                    head = curNode.next;
                } else {
                    lastNode.next = curNode.next;
                }
                break;
            }
            lastNode = curNode;
            curNode = curNode.next;
            anotherNode = anotherNode.next;
        }

//        yucfeng.com.ListNode curNode = head;
//        yucfeng.com.ListNode anotherNode = head;
//        while (true) {
//            int i = 0;
//            while (i < n - 1) {
//                anotherNode = anotherNode.next;
//                i++;
//            }
//            if (anotherNode.next == null) {
//                if (lastNode == null) {
//                    head = curNode.next;
//                } else {
//                    lastNode.next = curNode.next;
//                }
//                break;
//            }
//            lastNode = curNode;
//            curNode = curNode.next;
//            anotherNode = curNode;
//        }
        return head;
    }
}
