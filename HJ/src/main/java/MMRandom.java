import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MMRandom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine());

        List<Integer> nums = new ArrayList<>();
        while (in.hasNextLine()) {
            int a = Integer.parseInt(in.nextLine());
            nums.add(a);
            if (nums.size() == N) break;
        }
        Set<Integer> set = new HashSet<>(nums);
        List<Integer> output = set.stream().sorted((a, b) -> a-b).collect(Collectors.toList());
        for (Integer o : output) {
            System.out.println(o);
        }
    }
}
