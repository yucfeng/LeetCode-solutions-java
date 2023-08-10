import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

// 字符串统计
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] b = s.split("@")[0].split(",");
            if (s.split("@").length == 1) {
                System.out.println(s.split("@")[0]);
                continue;
            }
            String[] a = s.split("@")[1].split(",");

            List<String> xx = Arrays.stream(b).map(bs -> bs.split(":")[0]).collect(Collectors.toList());
            Map<String, Integer> all = new HashMap<>();
            for (int i=0;i<b.length;i++) {
                all.put(b[i].split(":")[0], Integer.parseInt(b[i].split(":")[1]));
            }
            for (String as : a) {
                String s1 = as.split(":")[0];
                if (!all.containsKey(s1)) continue;
                int num = all.get(s1);
                if (num <= Integer.parseInt(as.split(":")[1])) {
                    all.remove(s1);
                    xx.remove(s1);
                    continue;
                }
                all.put(s1, num - Integer.parseInt(as.split(":")[1]));
            }

            StringBuilder sb = new StringBuilder();
            for (String s2 : xx) {
                sb.append(s2).append(":").append(all.get(s2)).append(",");
            }
            System.out.println(sb.substring(0, sb.length()-1));
        }
    }
}
