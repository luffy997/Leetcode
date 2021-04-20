package review;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * @author 路飞
 * @create 2021/4/16 11:49
 */
public class IsStraight {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(isStraight(nums));
    }

    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        //统计癞子的个数
        int countZero = 0;
        for (int num : nums){
            if (num > 0) break;
            countZero++;
        }
        System.out.println(countZero);
        //全是癞子也不行
        if (countZero == 5) return false;
        //看需要几个几个癞子
        int needsZero = 0;
        for (int j = countZero;  j < nums.length - 1; j++) {
            if (nums[j+1] - nums[j] != 1){
                needsZero+=(nums[j+1]-nums[j]-1);
            }
            if (nums[j+1] == nums[j]) return false;
        }
        //癞子多了不要紧
        return countZero >= needsZero ? true : false;

    }

}
