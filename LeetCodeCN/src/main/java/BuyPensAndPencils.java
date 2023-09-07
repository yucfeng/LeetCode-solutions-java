// https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils/
public class BuyPensAndPencils {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 < cost2) {
            return waysToBuyPensPencils(total, cost2, cost1);
        }

        long ans = 0;
        int n = total / cost1;
        for (int i = 0; i <= n; i++) {
            if (i * cost1 > total) break;
            int m = (total - i * cost1) / cost2;
            ans += m + 1L;
        }
        return ans;
    }
}
