import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Jisuankuaidizhuzhandian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(str);

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] strings = line.split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }

        int result = 0;
        //已经有连通的站点
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            dfs(set, arr, i);
            result++;
        }
        System.out.println(result);

    }

    /**
     * 找到所有跟index相连的站点，放入set里面
     */
    public static void dfs(Set<Integer> set, int[][] arr, int index) {
        for (int i = index; i < arr.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (arr[index][i] == 1) {
                set.add(i);
                dfs(set, arr, i);
            }
        }
    }


}

