package String;

import java.util.HashSet;
import java.util.Set;

/**
 * 1684. 统计一致字符串的数目
 *
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * 请你返回 words 数组中 一致字符串 的数目。
 *
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 *
 * @author 路飞
 * @create 2021/2/7 16:22
 */
public class CountConsistentStrings {
    public static void main(String[] args) {
    String allowed ="abc";
    String[] words = {"a","b","c","ab","ac","bc","abc"};
    countConsistentStrings(allowed,words);
    }

    /**
     * 利用set不能重复添加元素的特点
     * @param allowed
     * @param words
     * @return
     */
    public static int countConsistentStrings(String allowed, String[] words){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        System.out.println(set);

        int count = 0;
        for (String str : words){
            boolean flag = true;
            for (int index = 0; index < str.length();index ++) {
                if (set.add(str.charAt(index))){
                    flag = false;
                    //很重要！！还原成初始set，不然后面受影响！！
                    set.remove(str.charAt(index));
                    break;
                }
            }
            if (flag) count++;

        }
        return count;
    }

}
