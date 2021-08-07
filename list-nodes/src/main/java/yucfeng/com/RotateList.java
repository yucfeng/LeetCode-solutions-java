package yucfeng.com;

import org.junit.Test;

/*
https://leetcode-cn.com/problems/rotate-list/
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 1;
        ListNode listNode = head;
        while (listNode.next != null){
            listNode = listNode.next;
            len ++;
        }
        k = k % len;

        if (k==0) {
            return head;
        }
        // 先首位相连
        listNode.next = head;
        // 再找断开的位置
        for (int i=1; i<len-k; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }

    @Test
    public void test() {
        int k=7, len=3;
        k = k % len;
        System.out.println(k);
    }
}
