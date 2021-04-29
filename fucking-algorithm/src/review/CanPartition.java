package review;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @author 路飞
 * @create 2021/4/23 9:18
 */
public class CanPartition {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums){
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1]+nums[i];
        }
        System.out.println(Arrays.toString(dp));
        //奇数就直接返回
        if ((dp[nums.length-1]&1) == 1) return false;
        int half = dp[nums.length-1]/2;
        for (int i = nums.length-1; i >= 0; i--) {
            if (dp[i] == half) return true;
        }
        return false;
    }
}
