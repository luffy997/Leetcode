package bitoperation;

import java.util.Arrays;

/**
 * medium
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * @author 路飞
 * @create 2021/3/21 19:40
 */
public class SingleNumber3 {
    public static void main(String[] args) {

    }

    /**
     * 位运算
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums){
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    /**
     * 排序 因为题目没有要求对时间和空间复杂度的要求
     * @param nums
     * @return
     */
    public static int m2(int[] nums){
        //快排
        int length = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < length - 2;i +=3 ){
            if (nums[i] != nums[i+2]){
                return nums[i];
            }
        }
        return nums[length-1];
    }
}
