package dfs;

/**
 * hard
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 0 <= 数组长度 <= 50000
 * @author 路飞
 * @create 2021/3/24 16:56
 */
public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        System.out.println(reversePairs(nums));
    }

    /**
     * 暴力 觉得多半会超时
     * @return
     */
    public static int reversePairs(int[] nums){

        if (nums.length == 0) return 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
        }
        return count;
    }
}
