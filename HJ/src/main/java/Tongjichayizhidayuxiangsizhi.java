import java.util.Scanner;

public class Tongjichayizhidayuxiangsizhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line);
        String line1 = sc.nextLine();
        String[] strings = line1.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            String binaryStringOne = Integer.toBinaryString(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                //如果转换成二进制后，最高位不相同，那么异或后肯定大于同或
                String binaryStringTwo = Integer.toBinaryString(nums[j]);
                int len1 = binaryStringOne.length();
                int len2 = binaryStringTwo.length();
                //先判断二进制总的长度，不一样的话首位肯定不一样，长度一样的话，再比较首个二进制是否不同
                if (len1 != len2 || binaryStringOne.charAt(0) != binaryStringOne.charAt(0)) {
//                    System.out.println(" (" + i + ", " + j + ")");
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}

