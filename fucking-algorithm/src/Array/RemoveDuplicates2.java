package Array;

import java.util.Arrays;

/**
 * 80. 删除排序数组中的重复项 II
 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author 路飞
 * @create 2021/2/15 10:33
 */
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
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
        int j = 1;
        int count = 0;
        while (j < len){
            if (nums[i] == nums[j]){
                count ++;
            }else {
                count = 0;
            }

            if (count < 2){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
        return i+1;
    }
}
