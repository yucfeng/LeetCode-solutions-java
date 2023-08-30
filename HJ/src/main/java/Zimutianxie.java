import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
小红拿到了一排格子，每个格子的背景是红色或者蓝色。小红希望你将每个格子上填写一个小写字母，需要满足相同的字母背景颜色是相同的。
小红希望最终出现次数最多的字母的出现次数尽可能小。你能帮帮她嘛？

输入描述：
一个仅由字符’0’和’1’组成的字符串，长度不超过200000.
字符串用于表示小红拿到的格子的颜色。第 i 个字符为’0’代表第 i 个格子为蓝色背景，字符’1’ 代表第 i 个格子为红色背景。

输出描述：
一个仅由小写字母构成的字符串，第 i 个字符为第 i 个格子上填写的字母，请务必保证字符串是合法的。如果有多解，输出任意即可。

示例一：
输入 ： 010
输出 ： abc

示例二：
输入 ： 0000000000000000000000000001
输出 ： bbcdefghijklmnopqrstuvwxyza
 */
public class Zimutianxie {

    // 出现次数最多的字母的出现次数尽可能小，即最大值最小化，有单调性
    // 二分解法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num0 = 0, num1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') num0++;
            else
                num1++;
        }
        //二分次数
        int right = Math.max(num0, num1);
        int left = 1;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (judge(num0, num1, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        char c0 = 'a';
        char c1 = 'z';
        num0 = 0;
        num1 = 0;
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                num0++;
                res[i] = c0;
                if (num0 == ans) {
                    c0++;
                    num0 = 0;
                }
            } else {
                num1++;
                res[i] = c1;
                if (num1 == ans) {
                    c1--;
                    num1 = 0;
                }
            }
        }
        for (char c : res) {
            System.out.print(c);
        }
    }

    public static boolean judge(int num0, int num1, int mid) {
        int sum = 0;
        if (num0 % mid != 0) {
            sum = sum + num0 / mid + 1;
        } else {
            sum = sum + num0 / mid;
        }
        if (num1 % mid != 0) {
            sum = sum + num1 / mid + 1;
        } else {
            sum = sum + num1 / mid;
        }
        if (sum <= 26) {
            return true;
        }
        return false;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = input.length();
        char[] array = input.toCharArray();
        double[] res1 = new double[]{0, 0};
        char[] res3 = new char[n];//便利输入字符串，统计0/1出现的次数
        for (char c : array) {
            if (c == '0') res1[0]++;
            else
                res1[1]++;
        }
        double[] res2 = new double[2];
        //计算0和1的比例，并算出应该在26个字母中分配的个数，存储在res2中
        if (res1[0] < res1[1]) {
            res2[0] = Math.ceil(26 * (res1[0] / (res1[0] + res1[1])));
            res2[1] = 26 - res2[0];
        } else {
            res2[1] = Math.ceil(26 * (res1[1] / (res1[0] + res1[1])));
            res2[0] = 26 - res2[1];
        }
        //000000000000000000000000001
        String a2z = "abcdefghijklmnopqrstuvwxyz";
        //s0是给0分配的字母
        String s0 = a2z.substring(0, (int) res2[0]);
        //s1是给1分配的字母
        String s1 = a2z.substring((int) res2[0], a2z.length());
        //双指针
        int zeroIndex = 0;
        int oneIndex = 0;
        //输入少于等于26时直接输出
        if (input.length() <= 26) {
            System.out.println(a2z.substring(0, input.length()));
        } else {
            for (int i = 0; i < n; i++) {
                if (array[i] == '0') {
                    res3[i] = s0.charAt(zeroIndex);
                    zeroIndex++;
                    if (zeroIndex >= s0.length()) {
                        zeroIndex = 0;
                    }
                } else {
                    res3[i] = s1.charAt(oneIndex);
                    oneIndex++;
                    if (oneIndex >= s1.length()) {
                        oneIndex = 0;
                    }
                }
            }
            String result = new String(res3);
            System.out.println(result);
        }
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (char c : res3) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
//            System.out.println(characterIntegerEntry.getKey() + "->" + characterIntegerEntry.getValue());
//        }
    }


}
