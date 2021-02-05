package String;

/**
 * 1221. 分割平衡字符串
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的最大数量。
 * <p>
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * 分割得到的每个字符串都必须是平衡字符串。
 *
 * @author 路飞
 * @create 2021/2/4 21:40
 */
public class BalancedStringSplit {
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }

    /**
     * 和机器人是否能回到原点类似
     * @param s
     * @return
     */
    public static int balancedStringSplit(String s) {
        int num = 0;
        int n =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') n++;
            if (s.charAt(i) == 'L') n--;
            if (n == 0) num++;
        }
        return num;
    }
}
