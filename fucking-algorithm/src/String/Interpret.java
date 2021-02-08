package String;

/**
 * 1678. 设计 Goal 解析器
 *
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 *
 * @author 路飞
 * @create 2021/2/7 16:05
 */
public class Interpret {
    public static void main(String[] args) {
        String command = "G()(al)";
        interpret(command);
    }

    public static String interpret(String command){

        StringBuilder sb = new StringBuilder();
        int length = command.length();
        char c = ' ';
        for (int i = 0; i < length;) {
            c = command.charAt(i);
            if (c == 'G'){
                sb.append("G");
                i++;
            }else if (c == '('){
                if (command.charAt(i+1) == ')'){
                    sb.append("o");
                    i+=2;
                }else {
                    sb.append("al");
                    i+=4;
                }
            }else {
                i++;
            }

        }

      return   sb.toString();
    }
}
