package search;

/**
 * easy
 * 剑指 Offer 53 - II. 0～n-1 中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * @author 路飞
 * @create 2021/3/20 15:33
 */
public class MissingNumber {
    public static void main(String[] args) {

    }

    /**
     * 暴力法 没有考虑数组是递增排序的
     * @param nums
     * @return
     */
    public static int m1(int[] nums){
        int len = nums.length;
        if(len == 1 && nums[0] == 0) return 1;
        for (int i = 0; i < len; i++) {
            if (i != nums[i]){
                return i;
            }
        }
        return nums[len - 1] +1;
    }

    /**
     * 数组是递增的 毫无疑问是用二分查找
     * @param nums
     * @return
     */
    public static int m2(int[] nums){
        int len = nums.length;
        if(len == 1 && nums[0] == 0) return 1;
        int i = 0;
        int j = len - 1;
        while (i < j){
            int mid = i + (j-i) / 2;
            int midVal = nums[mid];
            if (mid != midVal){
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }
        return i;
    }
}
