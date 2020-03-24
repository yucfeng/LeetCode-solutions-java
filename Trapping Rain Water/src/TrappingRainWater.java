import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */

public class TrappingRainWater {
    public static int trap(int[] height) {
        int len = height.length;
        int v = 0;
        for (int i=0; i< len; i++) {
            int left = height[i];
            int right = height[i];
            // find left
            for (int l=i; l>=0; l--) {
                left = Math.max(height[l], left);
            }
            // find right
            for (int r=i; r<len; r++) {
                right = Math.max(height[r], right);
            }
            v += Math.min(right, left) - height[i];
        }

        return v;
    }

    /*
    在遍历数组时维护一个栈.
    如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，
    如果发现当前的条形块长于栈顶，弹出栈顶元素并且累加答案v
     */
    public static int trap2(int[] height) {
        int res = 0, current = 0;
        LinkedList<Integer> st = new LinkedList<>();
        while (current < height.length) {
            while (!st.isEmpty() && height[current] > height[st.getFirst()]) {
                int top = st.getFirst();
                st.pop();
                if (st.isEmpty())
                    break;
                int distance = current - st.getFirst() - 1;
                int bounded_height = Math.min(height[current], height[st.getFirst()]) - height[top];
                res += distance * bounded_height;
            }
            st.push(current++);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,1,2}; // {0,1,0,2,1,0,1,3,2,1,2,1}; //  1 + 1 + 3 + 1
        System.out.println(trap2(nums));
    }
}
