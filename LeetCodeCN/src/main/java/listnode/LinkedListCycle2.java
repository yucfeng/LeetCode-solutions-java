package listnode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/linked-list-cycle-ii
public class LinkedListCycle2 {

    // 快慢指针
    // fast 走的步数是 slow 步数的 2 倍，即 f=2s；（解析： fast 每轮走 222 步）
    // fast 比 slow 多走了 n 个环的长度，即 f=s+nb；（ 解析： 双指针都走过 aaa 步，然后在环内绕圈直到重合，重合时 fast 比 slow 多走 环的长度整数倍 ）。
    // 将以上两式相减得到 f=2nb，s=nb，即 fast 和 slow 指针分别走了 2n，n 个环的周长。

    // 令 fast 重新指向链表头部节点。此时 f=0，s=nb 。
    //slow 和 fast 同时每轮向前走 1 步。
    //当 fast 指针走到 f=a 步时，slow 指针走到 s=a+nb 步。此时两指针重合，并同时指向链表环入口，返回 slow 指向的节点即可。
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;
        Set<ListNode> nodes = new HashSet<>();
        nodes.add(head);
        while (head.next != null && !nodes.contains(head.next)) {
            nodes.add(head.next);
            head = head.next;
        }
        if (head.next == null) return null;
        return head.next;
    }
}
