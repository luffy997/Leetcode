package String;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 提示：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @author 路飞
 * @create 2021/1/30 16:39
 */
public class ReserveWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reserveWords(s));
    }

    public static String reserveWords(String s){
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int length = s.length();
        int index =0;
        while (index < length){
            if (index == length - 1){
                temp.append(s.charAt(index));
                result.append(temp.reverse());
                return result.toString();
            }
            if (s.charAt(index) == ' '){
                //反转 拼接
                result.append(temp.reverse().append(' '));
                //置空
                temp.setLength(0);
                index ++;
            }else {
                temp.append(s.charAt(index));
                index ++;
            }


        }
        return result.toString();
    }
}
