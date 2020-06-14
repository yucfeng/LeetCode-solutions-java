/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

/**
 * n位数 和 n位数的乘积位数不超过n+n
 * num1[i] x num2[j] 的结果位数为2，其第一位位于 res[i+j]（可能为0），第二位位于 res[i+j+1]。
 */
class Solution {
    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) return "";
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int tmp = res[i + j + 1] + ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                res[i + j + 1] = tmp % 10;
                res[i + j] += tmp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int n : res) {
            if (!start && n!=0) {
                start = true;
            }
            if (start)
                sb.append(n);
        }
        return sb.toString().isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] at) {
        System.out.println(multiply("99", "0"));
    }
}
