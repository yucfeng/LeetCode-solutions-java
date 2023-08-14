import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
描述
给出一组数字，返回该组数字的所有排列
例如：
[1,2,3]的所有排列如下
[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
（以数字在数组中的位置靠前为优先级，按字典序排列输出。）
 */
public class Main4 {

    private static List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> main(int[] nums) {
        Arrays.sort(nums);
        tb(new LinkedList<>(), nums);
        return ans;
    }

    private void tb(LinkedList<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i=0;i<nums.length;i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            tb(tmp, nums);
            tmp.removeLast();
        }
    }

    @Test
    public void test() {
        System.out.println(main(new int[]{1,2,3}));
    }
}
