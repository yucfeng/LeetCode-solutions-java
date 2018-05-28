
/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        /**
         * O(n^2)
         */
//        ListNode curNode = l1, lastNode = l1, insertNode = l2, res = l1;
//        if (l1.val > l2.val) {
//            curNode = l2;
//            lastNode = l2;
//            insertNode = l1;
//            res = l2;
//        }
//        curNode = curNode.next;
//        while (insertNode != null) {
//            while ( curNode!=null && insertNode.val >= curNode.val) {
//                if (curNode.next == null) break;
//                curNode = curNode.next;
//                lastNode = lastNode.next;
//            }
//            ListNode tmpNode = new ListNode(insertNode.val);
//            if (curNode!=null && curNode.val <= insertNode.val) {
//                curNode.next = tmpNode;
//            } else {
//                lastNode.next = tmpNode;
//                lastNode = tmpNode;
//                tmpNode.next = curNode;
//            }
//            insertNode = insertNode.next;
//        }
        /**
         * O(n) solution
         */
        ListNode res = new ListNode(-1);
        ListNode l1Node = l1;
        ListNode l2Node = l2;
        if (l1.val < l2.val) {
            res.next = l1;
            l1Node = l1.next;
        } else {
            res.next = l2;
            l2Node = l2.next;
        }
        ListNode curNode = res.next;
        while (l1Node!=null || l2Node!=null) {
            if (l1Node == null) {
                curNode.next = l2Node;
                curNode = curNode.next;
                l2Node = l2Node.next;
                continue;
            }
            if (l2Node == null) {
                curNode.next = l1Node;
                curNode = curNode.next;
                l1Node = l1Node.next;
                continue;
            }
            if(l1Node.val < l2Node.val) {
                curNode.next = l1Node;
                curNode = curNode.next;
                l1Node = l1Node.next;
            } else {
                curNode.next = l2Node;
                curNode = curNode.next;
                l2Node = l2Node.next;
            }
        }
        return res.next;
    }

    public static void main(String[] agrs) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = mergeTwoLists(l1, l2);
    }
}
