package String;

import java.util.ArrayList;

/**
 * 345. 反转字符串中的元音字母
 *编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * @author 路飞
 * @create 2021/1/29
 */
public class ReverseVowels {
    public static void main(String[] args) {
        String s = "aA";
        String s1 = reverseVowels(s);
        System.out.println(s1);
    }

    public static String reverseVowels(String s){
        char[] chars = s.toCharArray();
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
        //双指针
        int length = chars.length;
        int left = 0;
        int right = length -1;
        StringBuilder sb = new StringBuilder();
        for (left = 0 , right = length -1;left <=right;){
            if (list.contains(chars[left])){
                if (list.contains(chars[right])){
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }else {
                    right --;
                }

            }else {
                left ++;
            }
        }
        for (int i = 0; i < length; i++) {
            sb.append(chars[i]);
        }
       return sb.toString();
    }
}
