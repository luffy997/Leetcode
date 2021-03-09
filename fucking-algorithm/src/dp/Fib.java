package dp;

/**
 * 动态规划DP
 * 求斐波那契数列
 * @author 路飞
 * @create 2021/2/15 16:23
 */
public class Fib {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(function01(n));
    }

    public static int function01(int n){
        if (n == 1 || n == 2)  return 1;
        return function01(n-1) + function01(n-2);
    }

    public static int m2(int n){
        int constant = 1000000007;
        int first = 0;
        int second = 1;
        while (n-- > 0) {
            int temp = first + second;
            first = second % constant;
            second = temp % constant;
        }
        return first;
    }
}
