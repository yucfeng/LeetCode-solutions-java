import java.util.Scanner;

// https://leetcode.cn/problems/flip-string-to-monotone-increasing/description/
public class Dizengzifuchuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int incr = getMinVal(line);
        System.out.println(incr);
    }

    public static int getMinVal(String s) {
        char[] chars = s.toCharArray();

        //前一个字符是0
        int preDpA = 0;
        //前一个字符是1
        int preDpB = 0;
        for (int i = 0; i < chars.length; i++) {
            char currChar = chars[i];
//            System.out.print(" cur char=" + currChar);
            //现将当前dp设置为前面一位dp，后面根据情况看是否要翻转
            int curDpA = preDpA;
            int curDpB = Math.min(preDpA, preDpB);
            //如果当前char为B，那么对于定义curDpA的值要翻转一次，因此+1
            if (currChar == 'B') {
                curDpA++;
            } else {
                //如果当前char为A，那么对于定义curDpB的值要翻转一次，因此+1
                curDpB++;
            }
            //刷新值
            preDpA = curDpA;
            preDpB = curDpB;

//            System.out.print(" dp0=" + curDpA);
//            System.out.print(" dp1=" + curDpB);
        }
        return Math.min(preDpA, preDpB);
    }

}

