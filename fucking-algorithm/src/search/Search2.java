package search;

/**
 * medium
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）
 * 上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给
 * 定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 相比33，这里是证数可能重复
 * @author 路飞
 * @create 2021/4/7 16:28
 */
public class Search2 {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,2,3,4,5,6,7,8,9,10,10,32};
        System.out.println(search2(nums, 1));
    }


    public static boolean search2(int[] nums,int target){
        int length = nums.length;
        if (length == 0 || nums == null) return false;

        int left = 0;
        int right = length - 1;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[left] == nums[mid]){
                left++;
                continue;
            }
            //前部分有序
            if (nums[left] < nums[mid]){
                if (nums[mid] > target && nums[left] <= target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if (nums[mid] < target && nums[right] >= target){
                    left = mid+1;
                }else {
                    right = mid -1;
                }
            }
        }
        return false;
    }

    /**
     * 递归实现二分查找
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    private static int binarySearch(int[] nums,int left,int right,int target){
        if(left > right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = nums[mid];
        if (target > midVal){
            return binarySearch(nums,mid+1,right,target);
        }else if (target < midVal){
            return binarySearch(nums,left,mid-1,target);
        }else {
            return mid;
        }
    }

    /**
     * 非递归实现二分查找
     * @param nums
     * @param target
     * @return
     */
    private static int binarySearch2(int[] nums,int target){
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            int mid = i + (j-i)/2;
            int midVal = nums[mid];
            if (target > midVal){
                i = mid+1;
            }else if (target < midVal){
                j = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
