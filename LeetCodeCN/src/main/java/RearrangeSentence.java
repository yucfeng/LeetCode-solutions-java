import java.util.Arrays;
import java.util.Comparator;

public class RearrangeSentence {

    public String arrangeWords(String text) {
        String[] arr = text.toLowerCase().split(" ");
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        String start = arr[0];
        String c = start.substring(0,1);
        arr[0] = c.toUpperCase() + start.substring(1);

        StringBuilder ans = new StringBuilder();
        for (String str :arr) {
            ans.append(str).append(" ");
        }
        return ans.substring(0, ans.length()-1);
    }
}
