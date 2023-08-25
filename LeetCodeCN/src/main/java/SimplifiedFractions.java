import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/simplified-fractions/
public class SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {
        Map<Float, String> map = new HashMap<>();
        for (int i = n;i>0;i--) {
            for (int j = i-1; j>0;j--) {
                map.put(j / (float) i, j + "/" + i);
            }
        }
        List<String> ans = new ArrayList<>();
        map.forEach((k,v) -> {
            ans.add(v);
        });
        return ans;
    }

    public List<String> simplifiedFractions2(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) ans.add(i + "/" + j);
            }
        }
        return ans;
    }

    int gcd(int a, int b) { // 欧几里得算法
        return b == 0 ? a : gcd(b, a % b);
    }
}
