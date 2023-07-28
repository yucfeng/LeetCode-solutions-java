import java.util.Scanner;

public class Quchujinliangshaodeqiu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] strings = line1.split(" ");
        long sum = Long.parseLong(strings[0]);
        int len = Integer.parseInt(strings[1]);

        long[] buckets = new long[len];
        String line = sc.nextLine();
        String[] split = line.split(" ");

        //实际装的球的总量
        long total = 0;
        //数组里单个桶所装的最大值
        long max = 0;
        for (int i = 0; i < len; i++) {
            buckets[i] = Integer.parseInt(split[i]);
            total += buckets[i];
            max = Math.max(max, buckets[i]);
        }
        if (total < sum) {
            System.out.println("[]");
        }

        long left = 0;
        long right = max;
        while (left < right) {
            //每个桶的最大容量，因为要向上取整，所以要 left + right + 1
            long mid = (left + right + 1) / 2;
            long tempTotal = 0;
            for (int i = 0; i < len; i++) {
                //如果当前桶的球数量大于容量mid， 取mid，否则取当前数量
                long curNum = Math.min(mid, buckets[i]);
                tempTotal += curNum;
            }
            if (tempTotal <= sum) {
                left = mid;
            } else {
                right = mid - 1;
            }

        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                sb.append(",");
            }
            long num = 0;
            if (buckets[i] > left) {
                num = buckets[i] - left;
            }
            sb.append(num);
        }
        sb.append("]");

        System.out.println(sb);
    }

}

