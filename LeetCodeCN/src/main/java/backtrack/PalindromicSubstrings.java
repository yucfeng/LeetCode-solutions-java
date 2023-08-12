package backtrack;


public class PalindromicSubstrings {

    // 枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，
    // 当两个指针指向的元素相同的时候就拓展，否则停止拓展。
    // "aaa"
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int i=0;i<n*2-1;i++) {  // n*2-1个回文中心
            int l=i/2;
            int r=i/2 + i%2;
            while (l>=0 && r<n) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                ans ++;
                l--;
                r++;
            }
        }
        return ans;
    }
}
