package review;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * @author 路飞
 * @create 2021/4/6 10:21
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s){
        String trim = s.trim();
        if (trim.length() <= 1) return trim.length();
        int res = 0;
        for (int i = trim.length()-1;i>=0;i--){
            if (trim.charAt(i) == ' ') break;
            res ++;
        }
        return res;
    }
}
