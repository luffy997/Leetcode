package Array;

import java.util.Arrays;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author 路飞
 * @create 2021/2/15 17:27
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {2,2,3,5,6};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    /**
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums,int val){
        int i = 0;
        int j = 0;
        for (j = 0; j < nums.length ; j++) {
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
}
