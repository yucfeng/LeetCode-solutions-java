import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NC61 {
    /**
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(target - numbers[0], 1); // 当前下标 的数所需要的数：当前下标
        for (int i=1; i<numbers.length; i++) {
            int current = numbers[i];
            if (indexMap.containsKey(current)) {
                return new int[]{indexMap.get(current) ,i+1};
            } else {
                indexMap.put(target - numbers[i], i+1);
            }
        }
        return new int[]{};
    }

    @Test
    public void test() {
        int[] numbers = new int[]{3,2,4};
        System.out.println(Arrays.toString(twoSum(numbers, 6)));
    }
}
