package String;

import java.util.ArrayList;

/**
 * 434. 字符串中的单词数
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。(可以是符号啥的)
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * @author 路飞
 * @create 2021/1/29
 */
public class CountSegments {
    public static void main(String[] args) {
        char A = 'Z';
        char a = 'z';
        System.out.println(Integer.valueOf(A)); //65   90
        System.out.println(Integer.valueOf(a)); //97   122
        countSegments("Hell , ");

    }

    public static void countSegments(String s) {
        int length = s.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            //i==0 || s.charAt(i-1) == ' ' ||的短路机制 可以防止数组越界报错！！！！！！！！！
            if ((i==0 || s.charAt(i-1) == ' ') && s.charAt(i)!= ' '){
                count ++;
            }
        }
        System.out.println(count);

    }


}
