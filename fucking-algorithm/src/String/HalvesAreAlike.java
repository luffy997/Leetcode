package String;

import java.util.ArrayList;

/**
 * 1704. 判断字符串的两半是否相似
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 *
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 *
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 *
 * 2 <= s.length <= 1000
 * s.length 是偶数
 * s 由 大写和小写 字母组成
 *
 * @author 路飞
 * @create 2021/2/8 17:37
 */
public class HalvesAreAlike {
    public static void main(String[] args) {
        String s = "AbCdEfGh";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s){
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        int length = s.length();
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (i < length /2 ){
                if (list.contains(chars[i])){
                    ++ left;
                }
            }else {
                if (list.contains(chars[i])){
                    ++ right;
                }
            }
        }
    return left==right;
    }
}
