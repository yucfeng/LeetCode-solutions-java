import java.util.Scanner;

public class Yunpintaiduanxin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int maxNum = Integer.parseInt(str);
        String line = sc.nextLine();
        String[] strings = line.split(" ");
        int n = strings.length;

        //要考虑到物品0的情况，物品0的重量和价值都是0
        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(strings[i - 1]);
        }

        int[] wight = new int[n + 1];
        for (int i = 0; i < wight.length; i++) {
            wight[i] = i;
        }

        int[][] dp = new int[n + 1][maxNum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxNum; j++) {
                if (j < wight[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - wight[i]] + values[i]);
                }
            }
        }
        System.out.println(dp[n][maxNum]);

    }

}
