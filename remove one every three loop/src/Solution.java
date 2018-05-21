import java.util.ArrayList;
import java.util.List;

/**
 * Josephus permutation
 * Given a int array, remove one number in every three.
 * If reaches the end, cycle to the start and continue.
 * Return the last number's original index.
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

    public static void main(String[] args) {
        System.out.println(getLastOne(56));
    }
}
