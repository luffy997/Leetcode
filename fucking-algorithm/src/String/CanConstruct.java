package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom
 * 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。
 * 杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * @author 路飞
 * @create 2021/1/29 17:21
 */
public class CanConstruct {
    public static void main(String[] args) {
        String ransomNote = "aaa";
        String magazine =  "aba";
        boolean b = canConstruct(ransomNote, magazine);
        System.out.println(b);
    }

    public static boolean canConstruct(String ransomNote, String magazine){

        //利用map 存储元素:元素出现的次数
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Integer count = map.get(magazine.charAt(i));
            count = count == null ? 1 : ++count;
            map.put(magazine.charAt(i),count);

        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            System.out.println("c==="+c);
            if (map.get(c) == null || map.get(c) == 0){
                return false;
            }else {
                Integer count = map.get(c);
                map.put(c,--count);
            }
        }

        return true;
    }

    /**
     *
     */
    public static void change(String ransomNote, String magazine){

    }
}
