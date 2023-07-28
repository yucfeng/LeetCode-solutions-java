import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Kuaisujianzhan {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int taskNum = Integer.parseInt(sc.nextLine());
            int relationsNum = Integer.parseInt(sc.nextLine());

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < relationsNum; i++) {
                String line = sc.nextLine();
                String[] strings = line.split(" ");
                int left = Integer.parseInt(strings[0]);
                int right = Integer.parseInt(strings[1]);
                List<Integer> list = map.getOrDefault(left, new ArrayList<>());
                list.add(right);
                map.put(left, list);
            }
            int[] taskMinTimes = new int[taskNum];

            int res = 0;
            for (int i = 0; i < taskNum; i++) {
                int needTime = getMinNeedTime(i, map, taskMinTimes);
                res = Math.max(res, needTime);
            }
            System.out.println(res);
        }

        //获取当前任务启动所需时间，就是所有依赖的任务里面时间最多的一个，为了减枝，用一个数组记录任务的最小启动时间
        public static int getMinNeedTime(int currNum, Map<Integer, List<Integer>> map, int[] taskMinTimes) {
            List<Integer> list = map.getOrDefault(currNum, new ArrayList<>());
            if (list.size() == 0) {
                //记录当前task任务所需的时间
                taskMinTimes[currNum] = 1;
                return 1;
            }

            int minDependTime = Integer.MIN_VALUE;
            for (int taskNum : list) {
                //先看看任务数组有没有值，如果数组里还没记录最小启动时间，那么递归获取,否则，如果已经有了，直接进行下面的比较
                if (taskMinTimes[taskNum] == 0) {
                    taskMinTimes[taskNum] = getMinNeedTime(taskNum, map, taskMinTimes);
                }
                minDependTime = Math.max(minDependTime, taskMinTimes[taskNum]);
            }
            int needTime = minDependTime + 1;
            //记录当前task任务所需的时间
            taskMinTimes[currNum] = needTime;
            return needTime;

        }

    }

