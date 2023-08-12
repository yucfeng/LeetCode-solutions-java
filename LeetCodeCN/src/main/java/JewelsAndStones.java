/*
https://leetcode.cn/problems/jewels-and-stones/
 */
public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        for(Character c : stones.toCharArray()) {
            if (jewels.contains(c + "")) {
                ans ++;
            }
        }
        return ans;
    }
}
