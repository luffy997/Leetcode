package search;

import java.util.*;

/**
 * easy
 * 剑指 Offer 50. 第一个只出现一次的字符
 * @author 路飞
 * @create 2021/3/19 16:13
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "abcdsa";
        firsyUniqChar(s);
    }

    public static char firsyUniqChar(String s){
        if (s.length() <=1) return ' ';
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            count = count == null ? 1 : ++ count;
            map.put(s.charAt(i),count);
        }

        //最快遍历map
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue().equals(1)){  //Integer的缓存-128——127 所以这里可以用== 也可以equals
                return next.getKey();
            }
        }
        return ' ';
    }
}
