import java.util.Scanner;

public class HJ33 {

    public String convert(String str) {
        // ipv4 -> int
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < 4; i++) {
                result = result * 256 + Integer.parseInt(fields[i]);
            }
            return "" + result;
        }
        // int -> ipv4
        else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < 4; i++) {
                result = ipv4 % 256 + "." + result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String ip = in.nextLine();
            long ipNum = Long.parseLong(in.nextLine());
            long ans = 0L;
            String[] nums = ip.split("\\.");
            for (int i=0; i<nums.length; i++) {
                if ("0".equals(nums[i])) continue;
                long num = Long.parseLong(nums[i]);
                for (int j=3; j>i;j--){
                    num = num * 256;
                }
                ans += num;
            }
            System.out.println(ans);
            StringBuilder ansIp = new StringBuilder();
            for (int i=4;i>0;i--){
                long tmp = ipNum;
                long w = 1;
                for (int j=1; j<i;j++) {
                     w =  w* 256;
                }
                tmp = tmp/w;
                ansIp.append(tmp).append(".");
                ipNum = ipNum - tmp * w;
            }
            System.out.println(ansIp.substring(0, ansIp.length()-1));
        }
    }
}
