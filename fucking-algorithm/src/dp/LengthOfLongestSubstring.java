package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * medium
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * @author 路飞
 * @create 2021/3/8 19:56
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s ="aue";
        lengthOfLongestSubstring(s);
    }

    /**
     * 双指针
     * @param s
     */
    public static void lengthOfLongestSubstring(String s){
        if (s.length() == 1) return ;

        int len = s.length();
        int slow = 0;
        int fast = 0;
        int res = 1;
        Set<Character> set = new HashSet<>();
        for (slow = 0,fast = 0;  fast < len;fast++) {
            while (set.contains(s.charAt(fast))){

            }
        }

        System.out.println(res);
    }
}
