package nowcoder.knapsack;

import java.util.Arrays;
import java.util.Map;

/**
 * 01背包问题
 * @author 路飞
 * @create 2021/4/23 14:42
 */
public class Knapsack01 {
    public static void main(String[] args) {

    }

    public static int knapsack (int V, int n, int[][] vw) {
        if (V == 0 || n == 0 || vw == null) return 0;
        int[][] dp = new int[n+1][V+1];
        //第一列
        for (int i = 1;i <= n;i++){
            for (int j = 1;j <=V;j++){
                if (j - vw[i-1][0] < 0) {
                    //装不下了
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-vw[i][0]]+vw[i-1][1]);
                }
            }
        }
        return dp[n][V];
    }
}
