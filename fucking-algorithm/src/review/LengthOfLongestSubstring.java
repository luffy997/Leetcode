package review;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * medium
 * 最长不含重复字符的子字符串
 * @author 路飞
 * @create 2021/4/14 20:01
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(m2(s));
    }

    /**
     * set 判断释放重复
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (slow = 0,fast=0; fast < s.length();) {
            if (set.contains(s.charAt(fast))){
                set.remove(s.charAt(slow)); //连续的体现
                slow++;
            }else {
                set.add(s.charAt(fast));
                fast++;
                max = Math.max(max,set.size());
            }
        }
        return max;
    }

    public static int m2(String s){
        LinkedList<Character> queue = new LinkedList<>();
        int fast = 0;
        int max = 0;
        while (fast < s.length()){
            if (queue.contains(s.charAt(fast))){
                queue.pollFirst(); //队首出列
            }else {
                queue.addLast(s.charAt(fast));
                fast++;
                max = Math.max(max,queue.size());
            }
        }
        return max;
    }
}
