package String;

import java.util.Stack;

/**
 * 58. 最后一个单词的长度
 *
 * @author 路飞
 * @create 2021/1/28
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
//        int length = lengthOfLastWord("a");
//        System.out.println("长度==="+length);
        int i = change("jelldc  ");
        System.out.println(i);
        int length = lengthOfLastWord("jelldc  ");
        System.out.println(length);
    }

    /**
     * 自己写的垃圾算法 还是实现了！
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s.trim().length() == 0) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

        }
        System.out.println(stack);

        while (true) {
            char c = stack.peek();
            if (c == ' ') {
                stack.pop();
            } else {
                break;
            }
        }

        System.out.println(stack);
        System.out.println(stack.peek());
        while (true) {
            char c = stack.peek();
            if (c != ' ') {

                sb.append(stack.pop());
                if (stack.size() == 0) {
                    break;
                }
            } else {
                break;
            }
        }
        return sb.length();
    }


    /**
     * 从后往前遍历字符串，遇到空格只有两种情况：
     * 1、开始计数
     * 2、结束计数
     */
    public static int change(String s) {

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    // 跳过末尾的空格
                    continue;
                } else {
                    // 结束统计
                    break;
                }
            }
            count++;
        }
        return count;
    }
}