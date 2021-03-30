package dfs;

import java.util.Arrays;

/**
 * easy
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * @author 路飞
 * @create 2021/3/24 11:50
 */
public class printNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumber(4)));
    }
    public static int[] printNumber(int n){
        //看需要几个9
        int end = 9;
        for (int i = 1; i < n; i++) {
            end = end * 10 +9;

        }
        int[] res = new int[end];
        for (int i = 0; i < res.length; i++) {
            res[i] = i+1;
        }
        return res;
    }
}
