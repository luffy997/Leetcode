package search;

/**
 * 33. 搜索旋转排序数组
 *
 整数数组 nums 按升序排列，数组中的值 互不相同 。

 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
 * @author 路飞
 * @create 2021/3/29 15:49
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = {1,3};
//        System.out.println(findMinIndex(nums));
//        System.out.println(binarySearch(4, nums.length-1, 0, nums));
        System.out.println(search(nums,3));
    }

    public static int search(int[] nums,int target){
        //先找异常点
        if (nums.length == 1 && nums[0] != target) return -1;
        int minIndex = findMinIndex(nums);
        if (nums[minIndex] == target) return minIndex;
        if (minIndex == 0){ //有序的 就直接对全部进行二分查找
            return binarySearch(0,nums.length-1,target,nums);
        }else if (target > nums[nums.length -1]){
            return binarySearch(0,minIndex-1,target,nums);
        }else {
            return binarySearch(minIndex+1,nums.length-1,target,nums);
        }

    }



    /**
     * 二分查找（递归）
     * @param left
     * @param right
     * @param target
     * @param nums
     * @return
     */
    private static int binarySearch(int left,int right,int target,int[] nums){

        if(left > right){ //这个要写在前面，不然会有数组越界的异常
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = nums[mid];
        if (target > midVal){ //向右递归
            return binarySearch(mid+1,right,target,nums);
        }else if (target < midVal){
            return binarySearch(left,mid-1,target,nums);
        }else {
            return mid;
        }
    }

    /**
     *  找到数组异常点 即：不满足递增的第一个数
     *  二分查找
     * @param nums
     * @return
     */
    private static int findMinIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

}
