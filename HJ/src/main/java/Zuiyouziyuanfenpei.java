import java.util.Scanner;

public class Zuiyouziyuanfenpei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int m = Integer.parseInt(str);
        String nStr = sc.nextLine();
        int n = Integer.parseInt(nStr);
        String line = sc.nextLine();
        char[] array = line.toCharArray();

        //此数组用来记录每个芯片用了多少个单位容量
        int[] used = new int[n];

        for (int i = 0; i < array.length; i++) {
            char currChar = array[i];
            int needVolume = 0;
            if (currChar == 'A') {
                needVolume = 1;
            } else if (currChar == 'B') {
                needVolume = 2;
            }else {
                needVolume = 8;
            }

            //下面是重点
            for (int j = 0; j < n; j++) {
                int reamin = m - used[j];
                //如果此配置需要的容量 <= 当前芯片剩余容量，说明足够使用，按需要的容量使用后跳出循环
                if (needVolume <= reamin) {
                    used[j] += needVolume;
                    break;
                }
            }
        }

        //下面是打印结果
        for (int i = 0; i < used.length; i++) {
            int usedLen = used[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if (j < usedLen) {
                    sb.append("1");
                }else {
                    sb.append("0");
                }
            }
            System.out.println(sb);
        }

    }

}
