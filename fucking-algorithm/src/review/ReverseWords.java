package review;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @author 路飞
 * @create 2021/4/8 11:18
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWord(s));
    }

    public static String reverseWord(String s){
        String[] split = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i < split.length-1){
                res.append(reserve(split[i])).append(" ");
            }else {
                res.append(reserve(split[i]));
            }
        }
        System.out.println(res.toString());
        return res.toString();
    }

    private static StringBuilder reserve(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse();
    }
}
