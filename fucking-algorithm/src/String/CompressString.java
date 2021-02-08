package String;

import java.util.*;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * @author 路飞
 * @create 2021/2/8 21:17
 */
public class CompressString {
    public static void main(String[] args) {
        String S = "abcccccaaa";
        compressString(S);
    }

    public static String compressString(String S){
        // 记录上一个字符出现了几次
        // 如果当前字符和上一个字符相等, 则频率+1
        // 如果当前字符和上一个字符不相等, 则把上一个字符和频率拼接上去

        if(S == null || S.length() == 0) {
            return S;
        }

        StringBuilder res = new StringBuilder();
        // 记录上一个字符
        char pre = S.charAt(0);
        // 记录上一个字符的频率
        int  times = 1;

        for(int i = 1; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (cur == pre) { //和上一个字符相等, 词频+1
                times++;
            } else { // 和上一个字符不相等, 把上一个字符以及频率拼接上去
                res.append(pre).append(times);
                pre = cur;
                times = 1;
            }
        }
        // 把最后一个字符以及频率拼接上去
        res.append(pre).append(times);
        // 判断压缩字符串是否比原字符串短
        if(res.length() >= S.length()) {
            return S;
        }
        return res.toString();
    }

}
