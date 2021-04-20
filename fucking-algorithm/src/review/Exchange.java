package review;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @author 路飞
 * @create 2021/4/9 17:52
 */
public class Exchange {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(exchange(nums)));
    }

    public static int[] exchange(int[] nums){
        int length = nums.length;
        if(length <= 1) return nums;
        int left = 0;
        int right = length-1;
        int temp = 0;
        while(left < right){
            while(left < right && (nums[left]&1)==1) ++left; //找到偶数
            while(left < right && (nums[right]&1)==0) --right;//找奇数
            temp = nums[right];
            nums[right] = nums[left];
            nums[left]=temp;
        }
        return nums;

    }
}
