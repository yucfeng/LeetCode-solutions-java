package structure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/merge-k-sorted-lists/
public class MergeKSortedLists {

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode p : lists) {
            ListNode t = p;
            while (t != null) {
                q.offer(t);
                t = t.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!q.isEmpty()) {
            cur = cur.next = q.poll();
        }

        cur.next = null;
        return dummy.next;
    }

    // 优先级队列
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (ListNode listNode: lists) {
            if (listNode != null) queue.add(listNode);
        }

        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            p.next = tmp;
            p = p.next;
            if (queue.isEmpty()) break;
            while (tmp.next != null) {
                if (tmp.next.val <= queue.peek().val) {
                    p.next = tmp.next;
                    p = p.next;
                    tmp = tmp.next;
                } else {
                    break;
                }
            }
            if (tmp.next != null) {
                queue.add(tmp.next);
            }
        }

        return dummy.next;
    }
}
