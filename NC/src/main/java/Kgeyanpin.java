import java.util.Scanner;

public class Kgeyanpin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int t = Integer.parseInt(in.nextLine());
        int count = 0;
        int[] ans = new int[t];
        while (count < t) { // 注意 while 处理多个 case
            String line = in.nextLine();

            int n = Integer.parseInt(line.split(" ")[0]);
            int k = Integer.parseInt(line.split(" ")[1]);

            if (n==k || k==0) {
                ans[count] = 0;
            } else {
                ans[count] = n-1;
            }
            count++;
        }

        for (int a: ans
             ) {
            System.out.println(a);
        }
    }
}
