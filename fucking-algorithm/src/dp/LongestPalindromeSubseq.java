package dp;

/**
 * medium
 * 516. 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 *
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 ** @author 路飞
 * @create 2021/3/11 15:33
 */
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        int[][] dp = {{1,2,3},{2,3,4},{2,3,3}};
        String s = "ababa";
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s){
        int len = s.length();
        if (len <= 1) return len;

        int[][] dp = new int[len][len];
        //对角线为1
        for (int i = 0;i< len;i++){
            dp[i][i] = 1;
        }
        showMap(dp);

        //倒着遍历
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i +1;j < len;j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
                showMap(dp);
            }
        }
        return dp[0][len - 1];



    }

    public static void showMap(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
