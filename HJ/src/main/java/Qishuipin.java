import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Qishuipin {

    static int output = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> outputs = new ArrayList<>();
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            if (n == 0) break;
            drink(n);
            outputs.add(output);
            output = 0;
        }
        for (Integer i : outputs) {
            System.out.println(i);
        }
    }

    // n=空瓶数量
    // i=借的数量
    private static void drink(int n) {
        if(n<=1) return;
        if (n==2) {
            output += 1;
            return;
        }
        int a = n/3;
        output += a;
        drink(a + n%3);
    }
}
