package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 中等
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @author 路飞
 * @create 2021/2/14 10:43
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabc";
//        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(function(s));
    }

    //set
    //线性法
    //双指针
    public static int lengthOfLongestSubstring(String s){

        Set<Character> set = new HashSet<>();
        int max= 0;
        int left = 0;
        int right = 0;
        for (left = 0 ,right = 0 ; right < s.length() ; right++) {
         while (set.contains(s.charAt(right))){
             set.remove(s.charAt(left));
             left ++;
         }
         set.add(s.charAt(right));
         //更新max
         max = Math.max(max,set.size());
        }
        return max;
    }

    //优化线性法
    //hashmap
    public static int function(String s){
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0,j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)) + 1 );
            }
            System.out.println(map);
            map.put(s.charAt(j),j);
            max = Math.max(max,j -i +1);
        }
        return max;
    }
}
