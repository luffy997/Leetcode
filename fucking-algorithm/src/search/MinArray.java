package search;

import java.util.Arrays;

/**
 * easy
 * 剑指 Offer 11. 旋转数组的最小数字
 * 这题我是没看懂，反正就是直接排序，输出最小的即可
 * @author 路飞
 * @create 2021/3/19 16:08
 */
public class MinArray {
    public static void main(String[] args) {

    }
    public static int minArray(int[] nums){
        Arrays.sort(nums);
        return nums[0];
    }
}
