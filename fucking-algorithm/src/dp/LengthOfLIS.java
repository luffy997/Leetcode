package dp;

import java.util.Arrays;

/**
 * medium
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @author 路飞
 * @create 2021/3/10 10:19
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * dp
     * @param nums
     */
    public static int lengthOfLIS(int[] nums){
        int len = nums.length;
        if (len <=1) return len;
        if  (len == 2) return nums[0] < nums[1] ? 2 : 1;
        int[] dp = new int[len];
        //初始化

        int res = 1;
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < len; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }

        return res;
    }
}
