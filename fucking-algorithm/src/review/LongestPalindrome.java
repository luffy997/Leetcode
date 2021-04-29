package review;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author 路飞
 * @create 2021/4/22 20:10
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s  = "abc1234321ab";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 有了递推公式，还要确定边界条件：
     * 如果s.charAt(left)！=s.charAt(right)，那么字符串从left到right是不可能构成子串的，直接跳过即可。
     * 如果s.charAt(left)==s.charAt(right)，字符串从left到right能不能构成回文子串还需要进一步判断
     * 如果left==right，也就是说只有一个字符，我们认为他是回文子串。即dp[left][right]=true（left==right）
     * 如果right-left<=2，类似于"aa"，或者"aba"，我们认为他是回文子串。即dp[left][right]=true（right-left<=2）
     * 如果right-left>2，我们只需要判断dp[left+1][right-1]是否是回文子串，才能确定dp[left][right]是否为true还是false。即dp[left][right]=dp[left+1][right-1]
     * 有了递推公式和边界条件，代码就很容易写了，来看下
     * @param s
     * @return
     */
    public static int longestPalindrome(String s){
        if (s.length() == 1)return 1;
        int n = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int right = 0; right < n; right++) {
            for (int left = 0;left < right;left++){
                //如果两种字符不相同，肯定不能构成回文子串
                if (s.charAt(right) != s.charAt(left)){
                    continue;
                }
                //下面是s.charAt(left)和s.charAt(right)两个
                //字符相同情况下的判断
                //如果只有一个字符，肯定是回文子串
                if (left == right){
                    dp[left][right]=true;
                }else if (right - left <=2){
                    dp[left][right]=true;
                }else {
                    //类似于"a******a"，要判断他是否是回文子串，只需要
                    //判断"******"是否是回文子串即可
                    dp[left][right]=dp[left+1][right-1];
                }
                //如果字符串从left到right是回文子串，只需要保存最长的即可
                if (dp[left][right] && right-left+1 > maxLen){
                    maxLen = right-left+1;
                }
            }
        }
        return maxLen;
    }
}
