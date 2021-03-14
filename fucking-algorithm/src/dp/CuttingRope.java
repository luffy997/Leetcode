package dp;

/**
 * medium
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * @author 路飞
 * @create 2021/3/9 14:46
 */
public class CuttingRope {
    public static void main(String[] args) {
//        System.out.println(cuttingRope(5));
        System.out.println(m2(100));

    }

    /**
     * 算法
     * @param n
     */
    public static int cuttingRope(int n){
        if (n <= 3) return n-1;
        int a = n /3;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3,a);
        if (b == 1) return (int) Math.pow(3,a-1)*4;
        return (int)Math.pow(3,a)*2;
    }

    /**
     * 大数的情况下，需要考虑对1000000007取模
     * @param n
     * @return
     */
    public static int m2(int n){
        if (n < 4) return n-1;
        long res = 1L;
        int constant = 1000000007;
        while (n > 4){
            res = res * 3 % constant;
            n -=3;
        }
        return (int)(res * n % constant);
    }
}
