package review;

import java.util.*;

/**
 * 377. 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 * <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 * @author 路飞
 * @create 2021/4/24 15:08
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,10};
        System.out.println(m2(nums,10));
    }
    public static int combinationSum4(int[] nums, int target) {
        return dfs(nums,target,new HashMap<Integer, Integer>());
    }

    private static int dfs(int[] nums, int target, Map<Integer,Integer> map){
        if(target == 0){
            return 1;
        }
        if (target < 0) return 0;
        if (map.containsKey(target))return map.get(target);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
           res+=dfs(nums,target-nums[i],map);
        }
        map.put(target,res);
        return res;
    }

    //完全背包
    private static int m2(int[] nums,int target){
        int[]dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
