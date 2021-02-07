package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 * @author 路飞
 * @create 2021/2/6 10:20
 */
public class MaxPower {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(maxPower(s));
    }

    /**
     *
     * @param s
     * @return
     */
    public static int maxPower(String s) {
        List<Integer> list = new ArrayList<>();
        int length = s.length();
        int count = 1;
        int i = 0;
        while (i < length ) {
            if (i == length -1) break;
            if (s.charAt(i) == s.charAt(i+1) ) {
                count++;
                i++;
            } else {
                list.add(count);
                i++;
                count = 1;
            }
        }
        list.add(count);
        Collections.sort(list);
        return list.get(list.size() -1);
    }

}
