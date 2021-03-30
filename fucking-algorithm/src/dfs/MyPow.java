package dfs;

/**
 * medium
 * 剑指 Offer 16. 数值的整数次方
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * @author 路飞
 * @create 2021/3/24 11:10
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(3, 4));
    }

    /**
     *折半求幂
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x,int n){
        if (n == 0) return 1;
        double half = myPow(x,n/2);
        if (n % 2 == 0) return half*half;
        if (n > 0 ) return half*half*x;
        return half*half/x;
    }
}
