import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Chazhaoshuzhongyuansu {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        int[][] nodes = new int[size][];
        for (int i = 0; i < size; i++) {
            nodes[i] = parseOneLine(in.nextLine());
        }
        int[] xy = parseOneLine(in.nextLine());
        String result = doQuery(nodes, xy[0], xy[1]);
        System.out.println(result);

    }


    private static int[] parseOneLine(String text) {
        ByteArrayInputStream stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        Scanner in = new Scanner(stream);
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            list.add(in.nextInt());
        }
        return list.stream().mapToInt(it -> it).toArray();
    }


    public static String doQuery(int[][] nodes, int x, int y) {
        if (x < 0 || y < 0) {
            return "{}";
        }

        return bfs(nodes, x, y);
    }


    public static String bfs(int[][] nodes, int x, int y) {
        //根节点
        int[] arr = nodes[0];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(arr);

        int level = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();
            //获取当前层各个节点
            for (int i = 0; i < n; i++) {
                int[] currNodeArr = queue.poll();

                int currVal = currNodeArr[0];

                //处理节点的子节点
                for (int j = 1; j < currNodeArr.length; j++) {
                    //rowIndex 子节点对应行的索引下标
                    int rowIndex = currNodeArr[j];
                    queue.add(nodes[rowIndex]);
                }

                if (level == x && y == i) {
                    return "{" + currVal + "}";
                }

            }
            //走到这里，说明在在x层找不到y
            if (level == x) {
                return "{}";
            }
            //遍历完当前层，后level+1
            level++;
        }
        return "{}";
    }

}

