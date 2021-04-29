package nowcoder;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长的括号字串长度
 * @author 路飞
 * @create 2021/4/29 17:58
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "(())))";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i - stack.peek());
                }
            }
        }
        return max;

    }
}
