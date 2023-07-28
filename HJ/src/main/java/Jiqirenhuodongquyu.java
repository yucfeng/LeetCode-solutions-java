import java.util.Scanner;

public class Jiqirenhuodongquyu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        String[] strings = numStr.split(" ");
        int m = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);

        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            for (int j = 0; j < split.length; j++) {
                nums[i][j] = Integer.parseInt(split[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currNum = nums[i][j];
                if (currNum != -1) {
                    max = Math.max(max, dfs(nums, i, j, currNum));
                }
            }
        }
        System.out.println(max);

    }

    /**
     * 返回从i,j开始，前面的值是preNum,能够覆盖的总数
     *
     * @param nums   数组
     * @param i      i
     * @param j      j
     * @param preNum 前一个遍历的值
     * @return 可以覆盖的总数
     */
    public static int dfs(int[][] nums, int i, int j, int preNum) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length) {
            return 0;
        }
        int curNum = nums[i][j];
        if (curNum == -1) {
            return 0;
        }
        //绝对值大于1，不符合条件
        if (Math.abs(curNum - preNum) > 1) {
            return 0;
        }

        //先标记
        nums[i][j] = -1;
        //count设置为1，表示先加上自己这个
        int count = 1;

        //遍历上下左右
        count += dfs(nums, i - 1, j, curNum);  //上
        count += dfs(nums, i + 1, j, curNum);  //下
        count += dfs(nums, i, j - 1, curNum);  //左
        count += dfs(nums, i, j + 1, curNum);  //右
        return count;

    }

}

