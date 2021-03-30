package sort;

import java.util.Arrays;

/**
 * easy
 *
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 数组长度为 5
 * 数组的数取值为 [0, 13] .
 * @author 路飞
 * @create 2021/3/23 11:13
 */
public class IsStraight {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(isStraight(nums));
    }

    public static boolean isStraight(int[] nums){
        Arrays.sort(nums);
        //统计癞子的个数  0
        int zeroCount = 0;
        for(int num : nums){
            if (num == 0) zeroCount++;
        }
        int temp = 0;
        for (int i = zeroCount; i < nums.length - 1; i++) {
            if (nums[i+1] - nums[i] == 1) {
                continue;
            }else {
                temp = nums[i+1] - nums[i] - 1;
                zeroCount -=temp;
            }
            if (nums[i+1] == nums[i]) return false;// 出现相同的 直接false
        }
        System.out.println(zeroCount);
        //癞子个数可以多，但不能少
        return zeroCount >= 0 ? true : false;
    }
}
