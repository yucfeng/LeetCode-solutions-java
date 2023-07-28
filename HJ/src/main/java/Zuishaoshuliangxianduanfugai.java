import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zuishaoshuliangxianduanfugai {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] strings = line.split(",");
            int left = Integer.parseInt(strings[0]);
            int right = Integer.parseInt(strings[1]);
            int[] node = new int[]{left, right};
            list.add(node);
        }
        //将每个线段，按照左侧升序排列，如果左侧相等，则按照右侧降序排列（这里千万不要搞错了）
        list.sort((a1, a2) -> {
            if (a1[0] != a2[0]) {
                return a1[0] - a2[0];
            } else {
                return a2[1] - a1[1];
            }
        });

        //下面是初始化
        int total = 1;
        int[] ints = list.get(0);
        //已经覆盖的右节点
        int coveredRight = ints[1];
        //最大右节点
        int maxRight = ints[1];

        for (int i = 1; i < list.size(); i++) {
            int[] node = list.get(i);
            int left = node[0];
            int right = node[1];
            //如果当前线段左节点比前面的右节点小，说明此线段可以和前面的合并，
            if (left <= coveredRight) {
                //如果此线段的右节点比maxRight大，更新maxRight
                maxRight = Math.max(maxRight, right);
            } else {
                //如果当前线段左节点比前面的右节点大，先将之前未合并的合并，合并次数+1，合并后 覆盖线段右节点coveredRight 设置为maxRight
                if (maxRight > coveredRight) {
                    total++;
                    coveredRight = maxRight;
                }
                //接着比较当前左节点与覆盖后的右节点,如果左节点比覆盖后的小
                if (left <= coveredRight) {
                    maxRight = Math.max(maxRight, right);
                } else {
                    //如果当前线段左节点比前面的右节点大，合并次数+1，合并后，更新maxRight和coveredRight
                    total++;
                    maxRight = right;
                    coveredRight = right;
                }

            }

        }
        if (maxRight > coveredRight) {
            total++;
        }
        System.out.println(total);
    }
}
