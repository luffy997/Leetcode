package search;

import java.util.Arrays;

/**
 * medium
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author 路飞
 * @create 2021/3/19 16:25
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {2,2};
        int[] ints = searchRange(nums, 2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 排序数组中查找 --> 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums,int target){
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        int[] res = {-1,-1};
        if (nums.length == 0) return res;
        while (i <= j){
            int mid = i + (j - i) / 2;
            int midValue = nums[mid];
            if (midValue > target){
                j = mid -1;
            }else if (midValue < target){
                i = mid + 1;
            }else {
                //找到了target的下标
                index = mid;
                break;
            }
        }
        //没有目标数
        if (index == -1) return res;
        int temp = index;
        //index 分别向左向右 查找起始位置
        //向左
        for (int n = index; n >=0; n--) {
            if (nums[n] != target) {
                temp = n+1;
                break;
            }
            if (n == 0) {
                temp = n;
                break;
            }
        }
        for (int n = index; n < nums.length; n++) {
            if (nums[n] != target) {
                index = n-1;
                break;
            }
            if (n == nums.length -1) {
                index = n;
                break;
            }
        }
        res[0] = temp;
        res[1] = index;
        return res;
    }
}
