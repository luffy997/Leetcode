package review;

import java.util.Arrays;

/**
 * 137. 只出现一次的数字 II
 * @author 路飞
 * @create 2021/4/30 8:47
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length-2; i+=3) {
            if (nums[i] != nums[i+2])return nums[i];
        }
        return nums[nums.length-1];
    }
}
