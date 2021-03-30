package Array;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 *
 * @author 路飞
 * @create 2021/2/15 10:33
 */
public class RemoveDuplicates1 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,34,5};
        System.out.println(removeDeplicates(nums));
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public static int removeDeplicates(int[] nums){
        if (nums.length == 0) return 0;
        int len = nums.length;
        int i = 0 ;
        for (int j = 1; j < len; j++) {
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i+1;
    }
}
