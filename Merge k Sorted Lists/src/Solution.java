import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * Author: yucfeng
 * Date: 2018/7/17
 */
public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        /**
         * Time complexity: O(nk)
         */
//        ListNode curNode = new ListNode(-1);
//        ListNode res = curNode;
//        if (lists.length == 0) return null;
//        boolean ishead = true;
//        while (hasNode(lists)) {
//            int curIndex = -1;
//            ListNode minNode = new ListNode(Integer.MAX_VALUE);
//            for (int i=0; i<lists.length; i++) {  // 获取当前lists中最小node
//                if (lists[i] != null && minNode.val >= lists[i].val) {
//                    minNode = new ListNode(lists[i].val);
//                    curIndex = i;
//                }
//            }
//            curNode.next = minNode;
//            curNode = curNode.next;
//
//            if (curIndex != -1)
//                lists[curIndex] = lists[curIndex].next;
//            if (ishead) ishead = false;
//        }
//        return res.next;

        /**
         * Use PriorityQueue
         */
        ListNode curNode = new ListNode(-1);
        ListNode res = curNode;
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (o1, o2) -> (o1.val - o2.val));
        for (ListNode listNode: lists) {
            if (listNode != null) queue.add(listNode);
        }
        while (!queue.isEmpty()) {
            curNode.next = queue.poll();
            curNode = curNode.next;
            if (curNode.next != null)
                queue.add(curNode.next);
        }
        return res.next;

    }
    public static boolean hasNode(ListNode[] lists) {
        for (ListNode listNode : lists) {
            if(listNode != null) return true;
        }
        return false;
    }

    public static void main(String[] agrs) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = {l1, l2, l3};
        ListNode res = mergeKLists(lists);
        System.out.print(res.next.val);
    }
}
