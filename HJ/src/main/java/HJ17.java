import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            Map<String, Integer> moved = getValidStep(str);
            int v = 0;
            int h = 0;
            for (Map.Entry<String, Integer> entry : moved.entrySet()) {
                switch (entry.getKey()) {
                    case "A":
                        v = v - entry.getValue();
                        break;
                    case "S":
                        h = h - entry.getValue();
                        break;
                    case "D":
                        v += entry.getValue();
                        break;
                    case "W":
                        h += entry.getValue();
                        break;
                }
            }
            System.out.println(v + ","+h);
        }
    }

    public static Map<String, Integer> getValidStep(String str) {
        String regex = "^[ASDW]\\d{1,2}";
        Pattern pattern = Pattern.compile(regex);
        Map<String, Integer> moved = new HashMap<>();
        List<String> steps = Arrays.stream(str.split(";")).collect(Collectors.toList());
        for (String step: steps) {
            if (pattern.matcher(step).matches()) {
                if (moved.containsKey(step.substring(0,1))) {
                    moved.put(step.substring(0,1) ,moved.get(step.substring(0,1)) + Integer.parseInt(step.substring(1)));
                } else {
                    moved.put(step.substring(0,1) , Integer.parseInt(step.substring(1)));
                }
            }
        }
        return moved;
    }
}
