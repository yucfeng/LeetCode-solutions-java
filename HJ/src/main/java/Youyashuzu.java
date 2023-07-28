import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Youyashuzu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        int[] nums = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        //左指针
        int i = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // 记录上一次r位置,为了方便计算，初始值设置为-1
        int preLeft = -1;
        for (int j = 0; j < nums.length; j++) {
            int val = nums[j];
            //指针到这时，窗口里val 的个数
            int sameNum = map.getOrDefault(val, 0) + 1;
            map.put(val, sameNum);
            //如果相同的个数>=k，那么所有能够覆盖此数组的都满足条件
            if (sameNum == k) {
                //不断的移动左指针，指针指向与有指针指向的值相同
                while (i < j) {
                    if (nums[i] == nums[j]) {
                        break;
                    }
                    // 左指针l移动过程中删除窗口外记录
                    map.put(nums[i], map.get(nums[i] - 1));
                    i++;
                }
                //算出还未统计的，且能覆盖此子数组的所有子数组个数(nums.length-j) * (i-preRight)
                res += (nums.length-j) * (i-preLeft);

                // 记录左指针
                preLeft = i;
                // 移除左指针元素
                map.put(val, map.get(val) - 1);
                i++;
            }
        }
        System.out.println(res);


    }
}
