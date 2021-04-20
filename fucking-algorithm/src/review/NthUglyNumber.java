package review;

/**
 * 剑指 Offer 49. 丑数
 * @author 路飞
 * @create 2021/4/14 20:26
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(m2(10));
    }

    /**
     * dp
     * @param n
     * @return
     */
    public static int m1(int n) {
        if (n < 4) return n;
        int l2 = 0;
        int l3 = 0;
        int l5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int a = dp[l2] * 2;
            int b = dp[l3] * 3;
            int c = dp[l5] * 5;
            dp[i] = Math.min(a, Math.min(b, c));
            if (dp[i] == a) l2++;
            if (dp[i] == b) l3++;
            if (dp[i] == c) l5++;
        }
        return dp[n-1];
    }

    public static int m2(int n){
        if (n < 4) return n;
        int count = 1;
        while (n!= 0){
            count = count * (n-3);
            n/=3;
        }
        return count;
    }
}
