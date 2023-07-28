import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 基站维修工程师
 *
 * 解题思路：
 * 本题可以理解为排列问题的变种 参考 leetcode 46. 全排列
 * 比如有3个基站， 除基站0外，分别是1,2
 * 1 2
 * 2 1
 *
 * 比如有4个基站， 除基站0外，分别是1,2,3
 * 那么全排列对应
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 *
 */
public class Jizhanweixiugongchengshi {

    public static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(str);

        int[][] stations = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] strings = line.split(" ");
            for (int j = 0; j < n; j++) {
                stations[i][j] = Integer.parseInt(strings[j]);
            }
        }

        int[] nums = new int[n-1];
        boolean[] used = new boolean[n-1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            nums[i] = i+1;
        }
        dfs(nums, used, list, 0, stations);
        System.out.println(res);



    }

    //用list把所有的排列转起来，并计算当前排列对应的总路程
    public static void dfs(int[] nums, boolean[] used, List<Integer> list, int index, int[][] stations) {
        //如果list里的元素个数与数组个数相等，说明都加进去了, 比如list 里存的是 2 1 3，则计算0-2-1-3-0 的总路程
        if (list.size() == nums.length) {
            calculateMin(list, stations);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, index + 1, stations);
            //下面是回退
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    //计算当前排列的总路程，并对比
    public static void calculateMin(List<Integer> list, int[][] stations) {
        int pre = 0;
        int distance = 0;
        for (int cur : list) {
            distance += stations[pre][cur];
            pre = cur;
        }
        //记得最后还得回到0
        distance += stations[pre][0];
        res = Math.min(distance, res);
    }
}
