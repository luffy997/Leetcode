package dp;

/**
 * medium
 * 413. 等差数列划分
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * @author 路飞
 * @create 2021/4/5 12:42
 */
public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    //很容易想到 它的状态转移方程
    //dp[i] = dp[i]-1 ? +0 +1
    public static int numberOfArithmeticSlices(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int[] dp = new int[length];

        for (int i = 2; i < length; i++) {
            if ((nums[i] -nums[i-1]  == nums[i-1] - nums[i-2])){
                dp[i] = dp[i-1] +1;
            }
        }
        int sum = 0;
        for (int num : dp){
            sum+=num;
        }
        return sum;
    }
}
