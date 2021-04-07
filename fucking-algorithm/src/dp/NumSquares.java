package dp;

import java.util.Arrays;

/**
 * medium
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * @author 路飞
 * @create 2021/4/5 13:22
 */
public class NumSquares {
    public static void main(String[] args) {
        numSquares(16);
    }
    public static int numSquares(int n){
        //特判
        int[] dp = new int[n+1];
        for (int i = 1; i < n; i++) {
            dp[i] = i;
            for (int j=1;i-j*j >= 0;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);

            }
            System.out.println(Arrays.toString(dp));
        }
       return dp[n];
    }
}
