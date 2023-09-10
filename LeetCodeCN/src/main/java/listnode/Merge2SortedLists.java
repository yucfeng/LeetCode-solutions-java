package listnode;

import listnode.ListNode;

// https://leetcode.cn/problems/merge-two-sorted-lists/
public class Merge2SortedLists {

    // 合并 返回头结点 需要一个虚拟头结点
    // 需要三个指针 拉拉链
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        dummy.next = list1;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1!=null && p2!=null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }
}
