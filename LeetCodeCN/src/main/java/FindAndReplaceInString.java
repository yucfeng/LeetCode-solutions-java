import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class FindAndReplaceInString {

    public String findReplaceString2(String s, int[] indices, String[] sources, String[] targets) {
        int len = s.length();
        var replaceStr = new String[len]; // 替换后的字符串
        var replaceLen = new int[len];    // 被替换的长度
        Arrays.fill(replaceLen, 1);     // 无需替换时 i+=1
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            if (s.startsWith(sources[i], idx)) {
                replaceStr[idx] = targets[i];
                replaceLen[idx] = sources[i].length();
            }
        }
        var ans = new StringBuilder();
        for (int i = 0; i < len; i += replaceLen[i]) { // 无需替换时 i+=1
            if (replaceStr[i] == null) {
                ans.append(s.charAt(i));
            } else {
                ans.append(replaceStr[i]);
            }
        }
        return ans.toString();
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int len = s.length(), idxLen = indices.length;
        // 将indices的数组下标按值排序
        int[] order = IntStream.range(0, indices.length).boxed().sorted(Comparator.comparingInt(i -> indices[i]))
                .mapToInt(i -> i).toArray();
        StringBuilder sb = new StringBuilder();
        int offset = 0;

        for (int i=0;i<len;) {
            while (offset < idxLen && indices[order[offset]] < i) {
                offset++;
            }
            boolean succeed = false;
            while (offset < idxLen && indices[order[offset]] == i) {
                if (s.substring(i, Math.min(i + sources[order[offset]].length(), len)).equals(sources[order[offset]])) {
                    succeed = true;
                    break;
                }
                offset++;
            }
            if (succeed) {
                sb.append(targets[order[offset]]);
                i += sources[order[offset]].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();

//        for (int i : order) {
//            int index = indices[i];
//            sb.append(s, offset, index);
//            if (s.startsWith(sources[i], index)) {
//                sb.append(targets[i]);
//                offset = index + sources[i].length();
//            } else {
//                offset = index;
//            }
//        }
//        sb.append(s.substring(offset));
//        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(findReplaceString2("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
    }
}
