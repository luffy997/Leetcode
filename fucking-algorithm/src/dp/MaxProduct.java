package dp;

/**
 * medium
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * @author 路飞
 * @create 2021/3/10 20:08
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {-3,-1,-1};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums){
        int len = nums.length;
        if (len == 1) return nums[0];
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        for(int num : nums){
            int temp = max;
            max = Math.max(Math.max(max * num,min * num),num);
            min = Math.min(Math.min(temp * num,min * num ),num);
            //迭代
            res = Math.max(max,res);
        }
        return res;
    }
}
