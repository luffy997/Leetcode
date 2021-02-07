package String;

/**
 * 1556. 千位分隔数
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 *
 * @author 路飞
 * @create 2021/2/6 19:01
 */
public class ThousandSeparator {
    public static void main(String[] args) {
        int  n = 0;
        System.out.println(thousandSeparator(n));

    }

    public static String thousandSeparator(int n){
        StringBuilder sb = new StringBuilder(String.valueOf(n));
         StringBuilder result = new StringBuilder();
        if (sb.length() <=3) return sb.toString();
        sb.reverse();
        char temp = ' ';
        for (int i = 0; i < sb.length();) {
            temp = sb.charAt(i);
            if ((i+1) %3 ==0 && i <= sb.length() -2){
                result.append(temp);
                result.append('.');
                i++;
            }else {
                result.append(temp);
                i++;
            }
        }
        return result.reverse().toString();
    }
}
