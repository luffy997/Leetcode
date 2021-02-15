package Array;

import java.util.Arrays;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * @author 路飞
 * @create 2021/2/15 10:17
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] resArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    resArray[0] = i;
                    resArray[1] = j;
                    break;
                }
            }
        }
        return resArray;
    }
}
