package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 路飞
 * @create 2021/3/8 20:34
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        nthUglyNumber(10);
    }

    //1,2,3,5
    public static void   nthUglyNumber(int n){
        int a = 0,b=0,c=0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int n2 = dp[a] *2;
            int n3 = dp[b] *3;
            int n5 = dp[c] *5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (dp[i] == n2) a ++;
            if (dp[i] == n3) b ++;
            if (dp[i] == n5) c ++;
        }
        System.out.println(Arrays.toString(dp));


    }
}
