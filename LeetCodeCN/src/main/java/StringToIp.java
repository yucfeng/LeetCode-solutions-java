/*
现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
例如：
给出的字符串为"25525522135",
返回["255.255.22.135", "255.255.221.35"]. (顺序没有关系)

数据范围：字符串长度
要求：空间复杂度 ,时间复杂度

注意：ip地址是由四段数字组成的数字序列，格式如 "x.x.x.x"，其中 x 的范围应当是 [0,255]。
"25525522135"  ["255.255.22.135","255.255.221.35"]
1111 ["1.1.1.1"]
"000256"  []

 */

import org.junit.Test;

import java.util.ArrayList;

public class StringToIp {

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("01123"));
    }

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<>();
        dfs(s, ans, new StringBuilder(), 0, 0);
        return ans;
    }

    /**
     * 回溯
     *
     * @param s     input
     * @param ans   ans
     * @param nums  ip
     * @param step  第几段数字
     * @param index current index of s
     */
    public void dfs(String s, ArrayList<String> ans, StringBuilder nums, int step, int index) {
        String cur = "";
        if (step == 4) { // base point
            if (index != s.length())
                return;
            ans.add(nums.toString());
        } else {
            for (int i = index; i < index + 3 && i < s.length(); i++) {
                cur += s.charAt(i);
                int num = Integer.parseInt(cur);
                String temp = nums.toString();
                if (num <= 255 && (cur.length() == 1 || cur.charAt(0) != '0')) {
                    if (step != 3)
                        nums.append(cur).append(".");
                    else
                        nums.append(cur);
                    dfs(s, ans, nums, step + 1, i + 1);
                    //回溯
                    nums = new StringBuilder(temp);
                }
            }
        }
    }
}
