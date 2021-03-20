package dfs;

/**
 * medium
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author 路飞
 * @create 2021/3/19 15:05
 */
public class SumNums {
    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }

    public static int sumNums(int n){
        return (int) (Math.pow(n,2) +n)>>1;
    }
}
