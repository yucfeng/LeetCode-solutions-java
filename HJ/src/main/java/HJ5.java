import java.util.Scanner;

public class HJ5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            System.out.println(Integer.parseInt(s.substring(2),16));
        }
    }
}
