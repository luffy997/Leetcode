package review;

import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * @author 路飞
 * @create 2021/4/17 11:23
 */
public class ConstructArr {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        constructArr(a);
    }

    public static int[] constructArr(int[] a){
        if (a == null || a.length == 0) return new int[0];

        int[] dpOne = new int[a.length];
        dpOne[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            dpOne[i] = dpOne[i-1]*a[i];
        }
        System.out.println(Arrays.toString(dpOne));
        int[] dpTwo = new int[a.length];
        dpTwo[a.length-1] = a[a.length-1];
        for (int i = a.length-2; i >= 0; i--) {
            dpTwo[i] = dpTwo[i+1]*a[i];
        }
        System.out.println(Arrays.toString(dpTwo));
        int[] res = new int[a.length];
        res[0] = dpTwo[1];
        res[a.length-1] = dpOne[a.length-2];
        for (int i = 1; i < a.length-1; i++) {
            res[i] =  dpOne[i-1] * dpTwo[i+1];
        }
       return res;
    }
}
