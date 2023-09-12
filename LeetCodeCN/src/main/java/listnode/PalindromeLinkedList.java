package listnode;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

// https://leetcode.cn/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode oldHead = copyList(head);
        ListNode newHead = reverseList(dummy.next);
        while (newHead.next != null) {
            if (newHead.val == oldHead.val) {
                newHead = newHead.next;
                oldHead = oldHead.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public ListNode copyList(ListNode head) {
        ListNode oldHead = new ListNode(head.val);
        ListNode dummy = new ListNode(-1);
        dummy.next = oldHead;
        while (head.next != null) {
            oldHead.next = new ListNode(head.next.val);
            oldHead = oldHead.next;
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode end = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return end;
    }

    // O(1) 空间复杂度
    // 快慢指针找中点
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode newHead = reverseList(slow);
        while (newHead != null) {
            if (newHead.val == head.val) {
                newHead = newHead.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
