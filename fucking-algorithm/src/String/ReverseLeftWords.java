package String;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @author 路飞
 * @create 2021/2/8 19:17
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s, 2));
    }

    public static String reverseLeftWords(String s, int n){
        return s.substring(n,s.length()) + s.substring(0,n);
    }
}
