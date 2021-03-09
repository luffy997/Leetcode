package twohand;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * @author 路飞
 * @create 2021/3/9 10:50
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "the sky is        blue";
        reverseWords(s);
    }

    /**
     * 快慢双指针
     * @param s
     * @return
     */
    public static String reverseWords(String s){
        //去掉首尾空格
        String str = s.trim();
        if (str.length() <= 1) return str;

        int length = str.length();
        int i = length -1;
        int j = length -1;
        StringBuilder sb = new StringBuilder();


        char temp = ' ';
        while (i  >= 0){

            while (i  >= 0 && str.charAt(i) != ' '){ //找到空格
                -- i;
            }
            sb.append(str.substring(i+1,j+1)+" "); //找到单词
            System.out.println(sb.toString());
            while (i  >= 0 && str.charAt(i) == ' '){
                -- i;
            }
            j = i;
        }

        return sb.toString().trim();
    }
}
