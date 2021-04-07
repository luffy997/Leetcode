package onedayonetopic;

/**
 * medium
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 0 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 * @author 路飞
 * @create 2021/4/6 8:16
 */
public class RemoveDuplicates {
    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums){
        int length = nums.length;
        if (length <=2) return length;

        //快慢指针
        int slow = 2;
        int fast = 2;
        while (fast < length){
            if (nums[slow-2] == nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
