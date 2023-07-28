import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zuhechuzuixiaoshu {
        public static List<Integer> list = new ArrayList<>();
        public static int min = Integer.MAX_VALUE;

        //存放，以0开头的字符串，对应的数
        public static List<Integer> zeroList = new ArrayList<>();
        //取，所有以0开头的字符串，对应的数 中，最小的一个
        public static int zeroMin = Integer.MAX_VALUE;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();

//        List<String> list = new ArrayList<>();

            String[] strings = str.split(" ");
            boolean[] used = new boolean[strings.length];
            dfs(strings, 0, "", used);
            if (list.size() != 0) {
                System.out.println(min);
            } else {
                System.out.println(zeroMin);
            }
        }

        public static void dfs(String[] strings, int useNum, String append, boolean[] used) {
            if (useNum == strings.length) {
                int num = getNum(append);
                //看是否以0开头
                if (!append.startsWith("0")) {
                    //不以 0 开头
                    list.add(num);
                    min = Math.min(num, min);
                } else {
                    //以 0 开头
                    zeroList.add(num);
                    zeroMin = Math.min(num, min);
                }
                return;
            }
            for (int i = 0; i < strings.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                String curStr = strings[i];
                dfs(strings, useNum + 1, append + curStr, used);
                //回退
                used[i] = false;
            }
        }


        public static int getNum(String str) {
            int i = 0;
            while (i < str.length() && str.charAt(i) == '0') {
                i++;
            }
            //从下标0开始遍历，直到找到不是0的下标为止
            if (i < str.length()) {
                String substring = str.substring(i);
                return Integer.parseInt(substring);
            } else {
                //全是是0，那么返回0
                return 0;
            }
        }


    }

