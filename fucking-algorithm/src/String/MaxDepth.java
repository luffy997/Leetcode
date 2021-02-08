package String;

import java.util.Stack;

/**
 * 1614. 括号的最大嵌套深度
 * <p>
 * 如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
 * <p>
 * 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
 * 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
 * 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
 * 类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
 * <p>
 * depth("") = 0
 * depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
 * depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
 * depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
 * 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
 * <p>
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 * <p>
 * 1 <= s.length <= 100
 * s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
 * 题目数据保证括号表达式 s 是 有效的括号表达式
 *
 * @author 路飞
 * @create 2021/2/7 10:23
 */
public class MaxDepth {
    public static void main(String[] args) {
        String s = "1+(2*3)/(2-1)";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int depthCount = 0;
        int ptCount = 0; //括号计数
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') ptCount++;
            if (c == ')') ptCount--;
            depthCount = Math.max(ptCount,depthCount);
        }
        return depthCount;

    }

}