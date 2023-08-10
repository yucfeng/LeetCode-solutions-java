import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class HJ25 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int IL = in.nextInt();
            String[] I = new String[IL];
            for (int i = 0; i < IL; i++) {
                I[i] = in.nextInt() + "";
            }
            int RL = in.nextInt();
            Set<Integer> RSet = new HashSet<>();
            for (int i = 0; i < RL; i++) {
                RSet.add(in.nextInt());
            }
            List<String> R = RSet.stream().sorted().map(r -> r + "").collect(Collectors.toList());

            Map<String, Map<Integer, String>> ans = new HashMap<>();
            for (String r : R) {
                boolean has = false;
                Map<Integer, String> tmpMap = new HashMap<>();
                for (int i =0;i<I.length; i++) {
                    if (I[i].contains(r)) {
                        tmpMap.put(i, I[i]);
                        has = true;
                    }
                }
                if (has) ans.put(r, tmpMap);
            }

            int len = 0;
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<R.size();i++) {
                if (ans.containsKey(R.get(i))) {
                    sb.append(" ").append(R.get(i));
                    len ++;
                    Map<Integer, String> tmpMap = ans.get(R.get(i));
                    sb.append(" ").append(tmpMap.size());
                    len ++;
                    List<Integer> keys = tmpMap.keySet().stream().sorted().collect(Collectors.toList());
                    for (int key : keys) {
                        sb.append(" ").append(key);
                        sb.append(" ").append(tmpMap.get(key));
                        len +=2;
                    }
                }
            }
            System.out.println(len + sb.toString());
        }
    }

}
