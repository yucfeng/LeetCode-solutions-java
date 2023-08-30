import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
小红定义一个字符串是好串,当且仅当只有一个字符出现的次数为奇数,其它字母均为偶数。
小红拿到了一个字符串,她想知道该字符串有多少子串是好串?子串的定义:一个字符串取一段连续的区间得到的新字符串。
例如"arcaea"的子串有"arc"、"ca"等,但"ara”则不是它的子串。

输入描述：
一个不超过200000的，仅由小写字母组成的字符串。
输出描述：
好子串的数量

用例：
输入：
ababa
输出：
9
 */
public class Haochuanggeshu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<Integer, Integer> hm = new HashMap<>();
        long res = 0;
        // 当前每种字符是奇数个还是偶数个
        int cur = 0;
        hm.put(0, 1);
        for (char c : str.toCharArray()) {
            // 异或运算为什么能得到符合条件的子串啊？
            cur ^= 1 << (c - 'a');
            for (int i = 0; i < 26; ++i) {
                res += hm.getOrDefault(cur ^ (1 << i), 0);
            }
            hm.put(cur, hm.getOrDefault(cur, 0) + 1);
        }
        System.out.println(res);
    }
}
