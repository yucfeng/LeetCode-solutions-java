import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class HJ20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String pwd = in.nextLine();
            if (pwd.length() <=8 || checkTypesFailed(pwd) || checkReplicatedFailed(pwd)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    private static boolean checkReplicatedFailed(String pwd) {
        if (pwd.length() < 6) return false;
        int l =0;
        int r=3;
        while (r < pwd.length()) {
            String subStr = pwd.substring(l, r);
            if (pwd.substring(r).contains(subStr)) {
                return true;
            }
            r++;
            l++;
        }
        return false;
    }

    private static boolean checkTypesFailed(String pwd) {
        Set<Integer> count = new HashSet<>(); // 1: number, 2: Upper 3 lower, 4: other
        for (Character c : pwd.toCharArray()) {
            int cInt = c - '0';
            if (0 <= cInt && cInt <= 9 ) {
                if (count.contains(1)) continue;
                count.add(1);
                if (count.size() >= 3) return false;
            } else if (cInt <=42 && cInt >=17) {
                if (count.contains(2)) continue;
                count.add(2);
                if (count.size() >= 3) return false;
            } else if (49 <=cInt && cInt <= 74) {
                if (count.contains(3)) continue;
                count.add(3);
                if (count.size() >= 3) return false;
            } else {
                if (count.contains(4)) continue;
                count.add(4);
                if (count.size() >= 3) return false;
            }
        }
        return true;
    }

    private static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str,l+1,r+1);
        }
    }
    // 检查是否满足正则
    private static boolean getMatch(String str){
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if(p1.matcher(str).find()){
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if(p2.matcher(str).find()){
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if(p3.matcher(str).find()){
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if(p4.matcher(str).find()){
            count++;
        }
        if(count >= 3){
            return false;
        }else{
            return true;
        }
    }
}
