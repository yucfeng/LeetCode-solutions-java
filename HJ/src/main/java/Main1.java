import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

// 拼接数组
//3
//3
//1,2
//2,2,2,3,3,3,4,4
//5,5,5,6,6,6
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int l = Integer.parseInt(in.nextLine());
            int n = Integer.parseInt(in.nextLine());
//            List<String> strs = new ArrayList<>();
//            int count =0;
//            for (int i = 0; i < n; i++) {
//                String tmpStr = in.nextLine();
//                strs.add(tmpStr);
//                count += tmpStr.length()/l;
//                if (tmpStr.length()%l !=0) count++;
//            }
//
//            for (int )

            Map<Integer, String[]> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] current = in.nextLine().split(",");
                int cutCount = current.length / l;
                if (current.length%l !=0) cutCount ++;
                for (int j = 0; j < cutCount; j++) {
                    String[] tmp = Arrays.copyOfRange(current, j*l, Math.min((j + 1) * l, current.length));
                    map.put(i + j * l, tmp);
                }
            }
            StringBuilder ans = new StringBuilder();
            List<Integer> indexs = map.keySet().stream().sorted().collect(Collectors.toList());
            for (Integer i : indexs) {
                for (String s : map.get(i)) {
                    ans.append(s).append(",");
                }
            }
            System.out.println(ans.substring(0, ans.length() - 1));
        }
    }
}
