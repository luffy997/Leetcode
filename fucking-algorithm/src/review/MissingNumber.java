package review;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @author 路飞
 * @create 2021/4/15 11:44
 */
public class MissingNumber {
    public static void main(String[] args) {

    }

    public static int missingNumber(int[] nums){
        int len = nums.length;
        if(len == 1 && nums[0] == 0) return 1;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right){
            mid = left + (right- left)/2;
            if(nums[mid] == mid){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
