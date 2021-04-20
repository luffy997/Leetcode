package review;

import java.util.Arrays;

/**
 * easy
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author 路飞
 * @create 2021/4/12 17:29
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(m2(nums));
    }

    //map 时间和空间效率都很低 这里不写了
    public static void majorityElement(int[] nums) {

    }

    //排序
    public static int m2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
