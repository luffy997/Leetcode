package String;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 * @author 路飞
 * @create 2021/2/8 20:35
 */
public class CanPermutePalindrome {
    public static void main(String[] args) {
        String s = "tactcoab";
        System.out.println(canPermutePalindrome(s));
    }

    /**
     * hash大法
     * @param s
     * @return
     */
    public static boolean canPermutePalindrome(String s){
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars){
            Integer count = map.get(c);
            count = count == null ? 1 : ++count;
            map.put(c,count);
        }

        //若每个k对应的v 都是偶数 true
        //若出现v为为奇数 且大于1 false

        int count = 0;

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iter = entrySet.iterator();
        while (iter.hasNext())
        {
            Map.Entry<Character, Integer> entry = iter.next();
            if (entry.getValue() % 2 != 0){ //为奇数
                ++ count ;
                if (count > 1) return false;
            }
        }

        return true;
    }
}
