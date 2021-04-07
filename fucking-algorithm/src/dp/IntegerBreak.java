package dp;

/**
 * 343. 整数拆分
 * @author 路飞
 * @create 2021/4/5 12:54
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n){
        if(n <=3) return n-1;
        int a = n / 3;
        if(n % 3 == 0) return (int)Math.pow(3,a);
        if(n % 3 == 1) return (int)Math.pow(3,a-1)*4;
        return (int)Math.pow(3,a)*2;
    }
}
