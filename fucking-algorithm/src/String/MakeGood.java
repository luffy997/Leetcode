package String;

import java.util.Stack;

/**
 * 1544. 整理字符串
 * 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * <p>
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 *
 * @author 路飞
 * @create 2021/2/6 16:35
 */
public class MakeGood {
    public static void main(String[] args) {
        //大小写字母相差32
        String s = "abBAcC";
        System.out.println(makeGood(s));
        System.out.println(function(s));
        System.out.println(function2(s));
    }

    public static String makeGood(String s) {
        StringBuilder result = new StringBuilder(s);
        //大小写字母 ansic 相差32
        for (int i = 0; i <= result.length() - 2; ) {
            if (Math.abs(result.charAt(i) - result.charAt(i + 1)) == 32) {
                result.delete(i, i + 2);
                i = 0;
            } else {
                i++;
            }
        }
        return result.toString();
    }

    /**
     * 栈的使用
     *
     * @param s
     * @return
     */
    public static String function(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                if (Math.abs(stack.peek() - c) == 32) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    /**
     * StringBuilder
     * @param s
     * @return
     */
    public static String function2(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (sb.length() > 0) {
                if (Math.abs(sb.charAt(sb.length() - 1) - c) == 32) {
                    sb.deleteCharAt(sb.length() - 1);
                    continue;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}


