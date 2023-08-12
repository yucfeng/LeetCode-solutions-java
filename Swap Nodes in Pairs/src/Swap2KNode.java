public class Swap2KNode {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;// 第k个节点
        ListNode right = head;// 倒数第k个节点
        for(int i = 1; i < k; i++){left = left.next;}
        ListNode cur = left;
        while(cur.next != null){
            right = right.next;
            cur = cur.next;
        }
        // 交换左右两个节点的值
        int m = right.val;
        right.val = left.val;
        left.val = m;
        return head;
    }

    public ListNode swapNodes2(ListNode head, int k) {
        if (head.next == null) return head;
        ListNode zs = head;
        ListNode ds = head; // tmp and daoshu
        int n = 1;
        while(ds.next != null) {
            ds = ds.next;
            n++;
        }
        ds = head;
        for (int i=0;i<k-1;i++) {
            zs = zs.next;
        }
        int zsVal = zs.val;
        for (int i=0;i<n-k;i++) {
            ds = ds.next;
        }
        zs.val = ds.val;
        ds.val = zsVal;
        return head;
    }
}
