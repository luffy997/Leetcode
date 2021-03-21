package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * medium
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中
 * 除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * @author 路飞
 * @create 2021/3/21 10:05
 */
public class ConstructArr {
    public static void main(String[] args) {
        int[] a = {2,3,4,5,6};
        System.out.println(Arrays.toString(constructArr(a)));
        m2(a);
    }

    /**
     * dp
     * @param a
     * @return
     */
    public static int[] constructArr(int[] a){
        int length = a.length;
        if (length == 0) return new int[0];
        int[] b = new int[length];
        b[0] = 1;
        int temp = 1;
        for (int i = 1; i < length; i++) {
            b[i] = b[i-1] * a[i-1];
        }
        for (int i = length - 2;i>=0;i--){
            temp *=a[i+1];
            b[i] *=temp;
        }
        return b;
    }

    /**
     * 自己写的dp 效率还行 本质上和第一种一样
     * @param a
     * @return
     */
    public static void m2(int[] a){
        int length = a.length;
        //if (length == 0) return new int[0];
        int[] dp_one = new int[length];
        int[] dp_two = new int[length];
        int[] res = new int[length];
        dp_one[0] = a[0];
        dp_two[length-1] = a[length-1];
        for (int i = 1; i < length; i++) {
            dp_one[i] = dp_one[i-1]*a[i];
        }

        System.out.println(Arrays.toString(dp_one));

        for (int i = length -2; i >=0; i--) {
            dp_two[i] = dp_two[i+1] * a[i];
        }
        System.out.println(Arrays.toString(dp_two));

        res[0] = dp_two[1];
        res[length - 1] = dp_one[length-2];

        for(int i = 1;i < length -1;i++){
            res[i] = dp_one[i-1] * dp_two[i+1];
        }
        System.out.println(Arrays.toString(res));
    }
}
