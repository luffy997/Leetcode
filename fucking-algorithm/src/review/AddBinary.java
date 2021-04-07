package review;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * @author 路飞
 * @create 2021/4/6 10:31
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addDecimal("11", "1"));
    }

    public static String addBinary(String a,String b){

        int i = a.length() -1;
        int j = b.length() -1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (i >=0 || j>=0 || sum!=0){
            sum+= i>=0?a.charAt(i--)-'0' : 0;
            sum+= j>=0?b.charAt(j--)-'0' : 0;
            sb.append(sum%2);
            sum/=2;
        }
        return sb.reverse().toString();
    }

    public static String addDecimal(String a,String b){
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (i >=0 || j>=0 || sum !=0){
            sum+= i>=0 ? a.charAt(i--) - '0': 0;
            sum+= j>=0 ? b.charAt(j--) - '0': 0;
            sb.append(sum%10);
            sum/=10;
        }
        return sb.reverse().toString();
    }
}
