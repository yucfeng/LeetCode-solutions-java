import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Date: 2018/5/17
 * Author: yucfeng
 */
public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> resSet = new HashSet<>();
        Arrays.sort(nums);  // ascending order
        if (nums.length < 4) return res;
        for(int first = 0; first <nums.length-3; first++) {
            if (nums[first] > target && nums[first] > 0) break;
            for (int sec = first+1; sec < nums.length-2; sec++) {
                if (nums[first]+nums[sec] > target && nums[sec] > 0) break;
                for (int thd = sec+1; thd < nums.length -1; thd++) {
                    if (nums[first]+nums[sec]+nums[thd] > target && nums[thd] > 0) break;
                    for(int fou = thd +1; fou < nums.length; fou++) {
                        if (nums[first]+nums[sec]+nums[thd]+nums[fou] == target) {
                            List<Integer> tmpList = new ArrayList<>();
                            tmpList.add(nums[first]);  // int type cannot use Arrays.aList(...);
                            tmpList.add(nums[sec]);
                            tmpList.add(nums[thd]);
                            tmpList.add(nums[fou]);
                            resSet.add(tmpList);
                        }
                    }
                }
            }
        }
        res.addAll(resSet);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,-2,-5,-4,-3,3,3,5};
//        System.out.println(Arrays.stream(a).reduce(0, (b, c) -> b + c));
//        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
//        System.out.println(list);
        System.out.println(fourSum(a, -11));
    }
}
