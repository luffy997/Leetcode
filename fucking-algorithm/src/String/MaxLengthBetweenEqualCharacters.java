package String;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 1624. 两个相同字符之间的最长子字符串
 *
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 * 1 <= s.length <= 300
 * s 只含小写英文字母
 *
 * @author 路飞
 * @create 2021/2/7 10:50
 */
public class MaxLengthBetweenEqualCharacters {
    public static void main(String[] args) {
        String s = "cabbac";
        System.out.println(s.length());
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public static int maxLengthBetweenEqualCharacters(String s){

        int length = s.length();
        ArrayList<Integer> list = new ArrayList<>();
        char c = ' ';
        int index = 0; //内部指针
        for (int i = 0; i < length; i++) {
           c = s.charAt(i);
           //找到每个字母相同的,放入链表中
            index = i+1;
           while (index < length ){
               if (c == s.charAt(index)){
                    list.add(index - i- 1);
                    index ++;
               }else {
                   index ++;
               }
           }
        }

        Collections.sort(list);
        System.out.println(list);
        //取最大的
        if (list.size() ==0){
            return -1;
        }else {
            return list.get(list.size() -1);
        }
    }
}
