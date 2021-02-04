package String;

/**
 *
 * 67. 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * @author 路飞
 * @create 2021/1/28
 */
public class AddBinary {
    public static void main(String[] args) {

        String a = "11";
        String b = "1";
        String s = function2(a, b);
        System.out.println(s);
    }

    /**
     * Java内置函数
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(
              Integer.parseInt(a,2) + Integer.parseInt(b,2)

        );
    }

    public static String function2(String a,String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += i >= 0 ? a.charAt(i--) - '0' : 0; // 获取字符串a对应的某一位的值 当i<0是 sum+=0（向前补0） 否则取原值 ‘1’的char类型和‘0’的char类型刚好相差为1
            carry += j >= 0 ? b.charAt(j--) - '0' : 0; // 获取字符串a对应的某一位的值 当i<0是 sum+=0（向前补0） 否则取原值 ‘1’的char类型和‘0’的char类型刚好相差为1
            sb.append(carry % 2); //如果二者都为1  那么sum%2应该刚好为0 否则为1
            carry = carry / 2; // 如果二者都为1  那么ca 应该刚好为1 否则为0
        }
        return sb.reverse().toString();// 判断最后一次计算是否有进位  有则在最前面加上1 否则原样输出
    }
}
