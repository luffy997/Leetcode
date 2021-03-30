package search;

/**
 * medium
 * 153. 寻找旋转排序数组中的最小值
 *假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * 请找出其中最小的元素。
 * @author 路飞
 * @create 2021/3/29 16:04
 */
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums){
        return binarySearchMin(nums);
    }

    /**
     * 找到最小数
     * @param nums
     * @return
     */
    private static int binarySearchMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
            return nums[left];
        }

}
