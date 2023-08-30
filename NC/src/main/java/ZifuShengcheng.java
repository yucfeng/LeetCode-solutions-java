import java.util.Scanner;

// https://www.nowcoder.com/questionTerminal/f8659377ca104b1aad45dd2fb564c940
public class ZifuShengcheng {

    public static void main(String[] args) {
//        System.out.println('z' - 'a');  // 25
//        System.out.println(Math.log(20) / Math.log(2)); // 4.3
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int x = in.nextInt();

            StringBuilder res = new StringBuilder();
            int log = (int) (Math.log(x) / Math.log(2));  // 求log2(x)
            int mod = x % 2;
            while (log != 0) {
                res.append((char) ('a' + log));
                x -= (int) Math.pow(2, log);
                if (x == 0)break;
                log = (int) (Math.log(x) / Math.log(2));
            }
            if (mod != 0) {
                res.append('a');
            }
            System.out.println(res);
        }
    }
}
