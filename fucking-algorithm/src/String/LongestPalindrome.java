package String;

/**
 * 中等
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * @author 路飞
 * @create 2021/2/14 11:48
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        longestPalindrome(s);
    }

    /**
     *
     * 中心扩散法
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < length - 1; i++) {
            int oddLen = expandAround(charArray,i,i);
            int evenLen = expandAround(charArray,i,i+1);
            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen){
                maxLen = curMaxLen;
                begin = i - (maxLen -1) /2;
            }
        }
        return s.substring(begin,begin + maxLen);
    }

    /**
     *
     * @param charArray
     * @param left 起始左边界
     * @param right  起始右边界
     * @return 回文串的长度
     */
    private static int expandAround(char[] charArray,int left ,int right){
        // 当left = right 的时候，会问中心是一个字符，回文串的长度是一个奇数
        // 当right = left +1 的时候，此时回文中心两个字符，回文串的长度是偶数
        int length = charArray.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < length){
            if (charArray[i] == charArray[j]){
                i--;
                j++;
            }else {
                break;
            }
        }

        //跳出while循环时，恰好满足 s.charAt(i) != s.charAt(j)
        return j - i -1 ;
    }
}
