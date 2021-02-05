package String;

/**
 * 1071. 字符串的最大公因子
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 * @author 路飞
 * @create 2021/2/4 20:47
 */
public class GcdOfStrings {
    public static void main(String[] args) {
        String str1 = "1234567";
        String str2 = "ABC";

        System.out.println(gcdOfStrings(str1, str2));

    }

    /**
     * 枚举
     * 1.前缀串的长度是两个字符串长度的约束
     * 2.枚举符合长度条件的前缀串，再去批判这个前缀串拼接若干次以后是否等于str1 和 str2
     * 3.按长度从大到小枚举前缀串，碰到第一个满足要求的前缀串就返回
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) { //从长度大的开始枚举
            if (len1 % i == 0 && len2 % i == 0) {
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }

    public static boolean check(String t, String s) {
        int lenx = s.length() / t.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= lenx; ++i) {
            sb.append(t);
        }
        return sb.toString().equals(s);
    }

    /**
     * 辗转相除法
     * @param str1
     * @param str2
     * @return
     */
    public static String function(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public static int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
