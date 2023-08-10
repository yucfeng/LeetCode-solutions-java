import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param times string字符串ArrayList
     * @return string字符串ArrayList
     */
    public ArrayList<String> timeSort(ArrayList<String> times) {
        times.sort(this::compareTime);
        return times;
    }

    private int compareTime(String t1, String t2) {
        String[] tStrs1 = t1.split(":");
        String[] tStrs2 = t2.split(":");
        for (int i = 2; i >= 0; i--) {
            if (Integer.parseInt(tStrs1[i]) != Integer.parseInt(tStrs2[i])) {
                return Integer.parseInt(tStrs1[i]) - Integer.parseInt(tStrs2[i]);
            }
        }
        return 0;
    }

    public ArrayList<String> timeSort2(ArrayList<String> times) {
        times.sort((s1, s2) -> (convert(s1) - convert(s2)));
        return times;
    }

    private int convert(String s) {
        String[] ss = s.split(":");
        return Integer.parseInt(ss[2]) * 60 * 60 + Integer.parseInt(ss[1]) * 60 + Integer.parseInt(ss[0]);
    }
}