import java.util.ArrayList;
import java.util.List;

/**
 * Josephus permutation
 * Given a int array, remove one number in every three.
 * If reaches the end, cycle to the start and continue.
 * Return the last number's original index.
 * Date: 2018/5/21
 * Author: yucfeng
 */
public class Solution {

    public static int getLastOne(int len){
        List<Integer> nums = new ArrayList<>();
        for (int i =0; i< len; i++) {
            nums.add(i);
        }
        return removeElement(nums);
    }

    public static int removeElement(List<Integer> nums) {
        if (nums.size() == 1) return nums.get(0);
        if (nums.size() == 2) return nums.get(1);
        int rest = nums.size() % 3;
        int len = nums.size();
        for (int i=0; i<len; i++) {
            if ((i+1)%3==0) nums.set(i, -1);
        }
        int j = 0;
        while (j < nums.size()){
            if (nums.get(j) == -1) nums.remove(j);
            j ++;
        }
        for (int i=0; i<rest; i++) { // move the remaining elements from end to head
            int tmp = nums.get(nums.size()-1);
            nums.remove(nums.size()-1);
            nums.add(0, tmp);
        }
        return removeElement(nums);
    }

    public static int getLastDeletedIndex(int len) {
        if (len <= 0) { // 如果数组长度不满足要求则返回 -1
            return -1;
        }

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) { // 初始化每个元素的值为当前下标
            arr[i] = len;
        }

        final int DELFLAG = len + 1; // 删除标志位
        int currentSize = len; // 记录数组当前有效长度（即未被置为删除标志的元素个数），最后变为 0
        final int STEP = 2; // 步长
        int count = 0; // 步长计数
        int lastDelIndex = 0; // 记录最后被删除的元素的下标
        int i = 0; // 循环下标

        while (currentSize != 0) {
            if (arr[i] != DELFLAG) { // 判读当前元素是否等于删除标志
                if (count++ == STEP) { // 当步长计数满足步长则
                    arr[i] = DELFLAG; // 将元素置为删除标志位
                    lastDelIndex = i; // 记录该处下标
                    currentSize--; // 有效数组长度减 1
                    count = 0; // 步长计数归零
                    System.out.println("Deleted index is " + i % len);
                }
            }
            i = (i + 1) % len; // 下标取余实现循环下标
        }
        return lastDelIndex;
    }

    public static void main(String[] args) {
        System.out.println(getLastOne(56));
        System.out.println(getLastDeletedIndex(56));
    }
}
