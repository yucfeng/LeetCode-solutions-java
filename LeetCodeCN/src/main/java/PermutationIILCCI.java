import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.cn/problems/permutation-ii-lcci/
 */
public class PermutationIILCCI {

    List<String> result = new ArrayList<>();

    public void traceback(char[] c, int index) {
        if (index ==c.length){
            result.add(new String(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i=index;i<c.length;i++){
            if (!set.contains(c[i])) {
                set.add(c[i]);
                swap(c, i, index);
                traceback(c, index+1);
                swap(c, i, index);
            }
        }
    }

    public void swap(char[] c, int x, int y){
        char temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(permutation("qqe")));
    }

    public String[] permutation(String S) {
        traceback(S.toCharArray(), 0);
        return result.toArray(new String[0]);
    }

    public String[] permutation1(String S) {
        Set<String> stringSet = f(S);
        return stringSet.toArray(new String[0]);
    }

    public Set<String> f(String s) {
        if (s.length() <= 1) {
            Set<String> stringSet = new HashSet<>();
            stringSet.add(s);
            return stringSet;
        }
        Set<String> stringSet = f(s.substring(1));
        String a = s.substring(0, 1);
        Set<String> stringSet1 = new HashSet<>();
        for (String str : stringSet) {
            for (int i = 0; i <= str.length(); i++) {
                stringSet1.add((i == 0 ? "" : str.substring(0, i)) + a + str.substring(i));
            }
        }
        return stringSet1;
    }
}

