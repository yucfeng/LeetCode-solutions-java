import java.util.Arrays;
import java.util.Scanner;

public class Zuzhuangxinshuzu {

    public static int total = 0;
    public static int min = 0;
    public static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        String line = sc.nextLine();
        int n = Integer.parseInt(line);

        int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        min = array[0];
        max = array[array.length - 1];
        dfs(array, 0, n);
        System.out.println(total);

    }

    public static void dfs(int[] array,int index, int remain) {
        /*
        剩下的小于最小数就可以组装,记得这里不能是小于等于，要不然等于的话，会有多余的出来
        比如： 最小值是2 最大值是4，如果是小于等于的话， 2 2 2和2 2 2 2都可以，这样是不符合条件的
         */
        if (remain < min) {
            total++;
            return;
        }
        for (int i = index; i < array.length; i++) {
            int val = array[i];
            if (val > remain) {
                break;
            }
            remain -= val;
            dfs(array, i, remain);
            //下面是回溯
            remain += val;
        }

    }

}
