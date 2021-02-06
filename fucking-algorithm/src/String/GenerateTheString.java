package String;

import java.util.Random;

/**
 * 1374. 生成每种字符都是奇数个的字符串
 *
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 *
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 *
 * @author 路飞
 * @create 2021/2/5 12:16
 */
public class GenerateTheString {
    public static void main(String[] args) {
        System.out.println(generateTheString(5));
    }

    public static String generateTheString(int n){
      //n为奇数 或者 偶数
        StringBuilder sb = new StringBuilder();

        if (n ==1) return "a";
        if (n ==3) return "abc";

        //偶数
        if (n % 2 == 0){
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
       }else {
            for (int i = 0; i < n - 2; i++) {
                sb.append('a');
            }
            sb.append('b').append('c');
       }
        return sb.toString();
    }
}
