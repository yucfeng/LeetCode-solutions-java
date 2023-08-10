import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 成绩排序
public class HJ68 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer,String> map = new HashMap<>(); // 姓名编号：姓名
        while(in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            boolean des = "0".equals(in.nextLine());
            int[][] score = new int[n][2];//姓名编号，成绩
            for(int i=0;i<n;i++){
                String[] nameAndScore = in.nextLine().split(" ");
                score[i][0] = i;
                score[i][1] = Integer.parseInt(nameAndScore[1]);
                map.put(i,nameAndScore[0]);
            }
            Arrays.sort(score,(o1, o2) ->{
                if(des){
                    return o2[1] - o1[1];
                }else{
                    return o1[1] - o2[1];
                }
            });
            for(int i=0;i<n;i++){
                System.out.println(map.get(score[i][0]) + " " + score[i][1]);
            }
        }
    }
}
