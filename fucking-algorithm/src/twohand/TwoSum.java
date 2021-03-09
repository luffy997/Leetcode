package twohand;

import java.util.Arrays;

/**
 * 剑指 Offer 57. 和为 s 的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author 路飞
 * @create 2021/3/9 10:08
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
        System.out.println(Arrays.toString(m2(nums, 9)));

    }

    /**
     * 递增排序的数组
     * 快慢双指针
     * 超出时间限制
     * @param nums
     * @param target
     */
    public static int[] twoSum(int[] nums, int target){
        int length = nums.length;
        if (length <= 1) {
            int[] res = new int[0];
            return res;
        }

        int slow = 0;
        int fast = 1;
        int[] res = new int[2];
        for (slow = 0 ; slow < length -1; slow ++){
            for (fast = slow +1;fast < length;fast ++){
                if (nums[slow] > target){
                    return res;
                }
                if (nums[slow]+nums[fast] == target){
                    res[0] = nums[slow];
                    res[1] = nums[fast];
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 对撞双指针
     * @param nums
     * @param target
     */
    public static int[] m2(int[] nums,int target){
        int length = nums.length;
        if (length <= 1) {
            int[] res = new int[0];
            return res;
        }

        int left = 0;
        int right = length - 1;
        int sum = 0;
        int[] res = new int[2];
        while (left < right){
            sum = nums[left] + nums[right];
            if (sum < target){
                left ++;
            }else if (sum > target){
                right --;
            }else {
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            }
        }
        return res;
    }
}
