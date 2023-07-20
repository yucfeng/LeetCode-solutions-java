import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            Set<Character> set = new HashSet<>();
            input.chars().filter(c -> c>0 && c<127).forEach(c -> set.add((char)(c+'0')));
            System.out.println(set.size());
        }
    }
}
