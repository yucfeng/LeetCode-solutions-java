import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int n = in.nextInt();
        while (i < n) {
            int index = in.nextInt();
            int value = in.nextInt();
            if (map.containsKey(index)) {
                map.put(index, map.get(index) + value);
            } else {
                map.put(index, value);
            }
            i ++;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey))
                .collect(Collectors.toList())) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
