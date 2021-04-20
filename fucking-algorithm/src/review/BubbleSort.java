package review;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author 路飞
 * @create 2021/4/19 16:10
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {2,3,-1,990,29,2,3,42,46};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums){
        int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (nums[j] > nums[j+1]){
                    flag = true;
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
            if (!flag){
                return;
            }else {
                flag = false;
            }
        }
    }
}
