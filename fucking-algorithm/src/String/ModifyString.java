package String;

import java.util.Arrays;

/**
 * 1576. 替换所有的问号
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 * 注意：你 不能 修改非 '?' 字符。
 *
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 *
 * 1 <= s.length <= 100
 *
 * s 仅包含小写英文字母和 '?' 字符
 *
 * @author 路飞
 * @create 2021/2/6 19:31
 */
public class ModifyString {
    public static void main(String[] args) {
        String s = "??yw?ipkj?";
        System.out.println(modifyString(s));
    }

    /**
     *
     * @param s
     * @return
     */
    public static String modifyString(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '?'){
                chars[i] = 'a';
                while (i < chars.length -1 && chars[i] == chars[i+1] || (i > 0 && chars[i] == chars[i-1])){
                    chars[i] +=1;
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars){
            sb.append(c);
        }
        return sb.toString();
    }
}
