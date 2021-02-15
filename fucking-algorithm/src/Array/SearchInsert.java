package Array;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 * @author 路飞
 * @create 2021/2/15 10:56
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(searchInsert(nums, 3));
    }

    public static int searchInsert(int[] nums, int target){
        int len = nums.length;
        if (nums[0] >= target) return 0;
        if (nums[len -1] < target ) return len;
        if (nums[len -1] == target) return len -1;
        for (int i = 0; i < len -1; i++) {
            if (nums[i] == target) return i;
            if (target > nums[i] && target < nums[i+1]) return i + 1;

        }
        return 0;
    }
}
