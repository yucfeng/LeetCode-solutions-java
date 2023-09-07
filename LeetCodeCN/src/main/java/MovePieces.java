import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.cn/problems/move-pieces-to-obtain-a-string/
public class MovePieces {

    public boolean canChange(String start, String target) {
        int n = start.length();
        TreeMap<Integer, Character> startIdx = new TreeMap<>();
        TreeMap<Integer, Character> targetIdx = new TreeMap<>();
        int fi = n;
        while (true) {
            int idx = start.lastIndexOf('R', fi);
            if (idx > -1) {
                startIdx.put(idx, 'R');
                fi = idx-1;
            } else {
                break;
            }
        }
        fi = n;
        while (true) {
            int idx = start.lastIndexOf('L', fi);
            if (idx > -1) {
                startIdx.put(idx, 'L');
                fi = idx-1;
            } else {
                break;
            }
        }

        fi = n;
        while (true) {
            int idx = target.lastIndexOf('R', fi);
            if (idx > -1) {
                targetIdx.put(idx, 'R');
                fi = idx-1;
            } else {
                break;
            }
        }
        fi = n;
        while (true) {
            int idx = target.lastIndexOf('L', fi);
            if (idx > -1) {
                targetIdx.put(idx, 'L');
                fi = idx-1;
            } else {
                break;
            }
        }
        if (startIdx.size() != targetIdx.size()) return false;

        int size = startIdx.size();
        for (int i =0; i<size; i++) {
            Map.Entry<Integer, Character> startEntry = startIdx.firstEntry();
            Map.Entry<Integer, Character> targetEntry = targetIdx.firstEntry();
            if (startEntry.getValue() != targetEntry.getValue()) {
                return false;
            } else if (startEntry.getValue() == 'R') {
                if (startEntry.getKey() > targetEntry.getKey()) {
                    return false;
                }
            } else if (startEntry.getValue() == 'L') {
                if (startEntry.getKey() < targetEntry.getKey()) {
                    return false;
                }
            }

            startIdx.remove(startEntry.getKey());
            targetIdx.remove(targetEntry.getKey());
        }
        return true;
    }

    @Test
    public void test1() {
        System.out.println(canChange("_L__R__RL", "L_____RLR"));
    }

    public boolean canChange2(String start, String target) {
        if (!start.replaceAll("_", "").equals(target.replaceAll("_", "")))
            return false;
        for (int i = 0, j = 0; i < start.length(); i++) {
            if (start.charAt(i) == '_') continue;
            while (target.charAt(j) == '_')
                j++;
            if (i != j && (start.charAt(i) == 'L') == (i < j))
                return false;
            j++;
        }

        return true;
    }

    @Test
    public void test() {
        String start = "_L__R__R_";

        int r1 = start.lastIndexOf('R', start.length());
        System.out.println(r1);
        int r2 = start.lastIndexOf('R', r1-1);
        System.out.println(r2);
        System.out.println(start.lastIndexOf('R', r2-1));
    }
}
