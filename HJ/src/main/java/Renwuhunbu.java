import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Renwuhunbu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        //差分数组
        int[] arr = new int[50000];

        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int startTime = Integer.parseInt(split[0]);
            int endTime = Integer.parseInt(split[1]);
            int parallelism = Integer.parseInt(split[2]);
            //循环比较，取最大的时间
            maxTime = Math.max(endTime, maxTime);

            //下面是给差分数组赋值
            arr[startTime] = parallelism;
            arr[endTime] = -parallelism;
        }

        int res = 0;
        int count = 0;
        //遍历，将差分数组的值累加，取最大的一个
        for (int i = 0; i <= maxTime; i++) {
            count += arr[i];
            res = Math.max(res, count);
        }
        System.out.println(res);

    }
}

