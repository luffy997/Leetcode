package String;

/**
 * 709. 转换成小写字母
 *
 *实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，
 * 之后返回新的字符串。
 *
 * @author 路飞
 * @create 2021/2/3 10:33
 */
public class ToLowerCase {
    public static void main(String[] args) {
        //ansic 大小写相差32  'a' - 'A' = 32  97 - 65
        //'z' - 'Z' = 122 -90
       String s = "HeloJ#";
        System.out.println(function02(s));
    }

    //可以直接调用Java的内置函数
    public static String function01(String s){
        return s.toUpperCase();
    }

    //当然直接调用toUpperCase没意思了，需要我们手动实现转大写
    public static String function02(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if (rangeInDefined(Integer.valueOf(c),65,90)){
                sb.append((char)(Integer.valueOf(c) +32));
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }
}
