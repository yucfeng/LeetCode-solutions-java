
/*
有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。

假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/replace-the-substring-for-balanced-string
 */
public class ReplaceTheSubstring4BalancedString {

    public int balancedString(String s) {
        // [QWER]
        // [0123]
        int n = s.length();
        int[] arr = new int[4];
        int[] counts = new int[4];
        for (int i=0;i<n;i++) {
            char c = s.charAt(i);
            arr[i] = c=='W'?1:(c=='E'?2:(c=='R'?3:0));
            counts[arr[i]]++;
        }
        int ans = n;
        for (int l=0,r=0;l<n;l++){
            // 窗口[l,r)
            while (!f(counts, l, r) && r<n) {
                counts[arr[r]]--;
                r ++;
            }
            if (f(counts, l ,r)) {
                ans = Math.min(ans, r-l);
            } else {
                break;
            }
            counts[arr[l]]++;
        }
        return ans;
    }

    // count: 窗口外剩余字符
    public boolean f(int[] count, int l, int r) {
        int maxCount = Math.max(Math.max(count[0], count[1]), Math.max(count[2], count[3]));
        int changes = maxCount - count[0] - count[1] - count[2] - count[3];
        int rest = r-l-changes;
        return rest >= 0&& rest%4==0;
    }
}
