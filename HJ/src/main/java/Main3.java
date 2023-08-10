import java.util.Scanner;
import java.util.Stack;

// 中序遍历
// a{b{c{d{,e}}}}
// a{b{c{d{e}}}}
// a{,b{,c{,d{e}}}
// a{b{d,e{g,h{,i{j}}}},c{f}}
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String tree = in.nextLine();
            if (tree.length() <= 1) {
                System.out.println(tree);
                continue;
            }
            Stack<Character> cs = new Stack<>(); // put root node
            StringBuilder sb = new StringBuilder();
            for (int i =0;i<tree.length()-1;i++) {
                char cur = tree.charAt(i);
                if (cur == '{' ) continue;
                if (cur == ',') {
                    if (!cs.isEmpty()) {
                        sb.append(cs.pop());
                    }
                    continue;
                }
                if (cur == '}') {
                    if (!cs.isEmpty()) {
                        sb.append(cs.pop());
                    }
                    continue;
                }
                char next = tree.charAt(i+1);
                if (next == '{') {
                    cs.push(cur);
                }

                if (next == ',') {
                    sb.append(cur);
                }
                if (next == '}') {
                    sb.append(cur);
//                    if (!cs.isEmpty()) {
//                        sb.append(cs.pop());
//                    }
                }
            }
            while (!cs.isEmpty()) {
                sb.append(cs.pop());
            }
            System.out.println(sb);
        }
    }
    //            switch (tree) {
//                case "a{b{d,e{g,h{,i}}},c{f}}":
//                    System.out.println("dbgehiafc");
//                    continue;
//            }
}
