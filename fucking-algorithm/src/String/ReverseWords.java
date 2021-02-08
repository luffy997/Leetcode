package String;

import java.util.LinkedList;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author 路飞
 * @create 2021/2/8 18:28
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "a good   example";
        reverseWords(s);
    }

    public static String reverseWords(String s) {
        //去掉前后的空格
        String trim = s.trim();
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < trim.length(); ) {
            if (trim.charAt(i) != ' ') {
                temp.append(trim.charAt(i));
                ++i;
                if (i == trim.length()) list.addFirst(temp.toString());
            } else {
                ++i;
                if (trim.charAt(i) != ' ') {
                    list.addFirst(temp.toString());
                    list.addFirst(" ");
                    temp.delete(0, temp.length());
                }
            }
        }

        //
        for (String str : list) {
            result.append(str);
        }
        return result.toString();

    }
}
