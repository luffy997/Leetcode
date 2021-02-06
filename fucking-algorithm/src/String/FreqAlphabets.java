package String;

/**
 * 1309. 解码字母到整数映射
 *
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 *
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 *
 * @author 路飞
 * @create 2021/2/5 10:39
 */
public class FreqAlphabets {
    public static void main(String[] args) {
        // a - i 1-9
//        System.out.println(Integer.valueOf('i'));  // a - i 97 105  -96
//        System.out.println(Integer.valueOf('z'));  // j - z 106 122  -96
        freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#");
    }

    /**
     * 反向遍历 是#就挪动两位
     * @param s
     * @return
     */
    public static String freqAlphabets(String s){
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int length = s.length();
        int index = length -1;
        while (index >= 0){
            char c = s.charAt(index);
            if (c == '#'){
                sb.append(s.charAt(index -2)).append(s.charAt(index -1));
                result.append((char)(Integer.valueOf(sb.toString())+96));
                sb.delete(0,sb.length());
                 index -=3;

            }else {
                sb.append(c);
                result.append((char)(Integer.valueOf(sb.toString())+96));
                sb.delete(0,sb.length());
                  index --;
            }

        }
        return result.reverse().toString();
    }
}
