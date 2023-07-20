import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HJ3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = -1;
        int n = Integer.MAX_VALUE;
        Set<Integer> numSet = new HashSet<>();
        while (i < n) {
            if (i == -1) {
                n = in.nextInt();
                i++;
                continue;
            }
            numSet.add(in.nextInt());
            i++;
        }
        List<Integer> res = new ArrayList<>(numSet);
        res.sort(Comparator.comparingInt(a -> a));
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] arr = new int[1001];
            for (int i = 0; i < num; i++) {
                int n = scanner.nextInt();
                arr[n] = 1;
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 1) {
                    System.out.println(i);
                }
            }
        }
    }
}
