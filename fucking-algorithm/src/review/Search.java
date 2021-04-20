package review;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * @author 路飞
 * @create 2021/4/15 11:17
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(search(nums, 6));
    }

    public static int search(int[] nums,int target){
        int n = nums.length;
        if (n == 0) return 0;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        boolean flage = false;
        while (left < right){
            mid = left + (right-left)/2;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                flage = true;
                break;
            }
        }
        if (!flage) return 0;
        int index = mid;
        int count = 1;
        while (--index>=0){
            if (nums[index] == target){
                count++;
            }else {
                break;
            }
        }
        while (++mid <n){

            if (nums[mid] == target){
                count++;
            }else {
                break;
            }
        }
        return count;

    }

}
