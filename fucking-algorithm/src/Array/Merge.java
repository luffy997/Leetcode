package Array;

import java.util.Arrays;

/**
 * easy
 * 每日一题
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * @author 路飞
 * @create 2021/4/5 11:42
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {-1000, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1.length == 0 || n == 0) return;

        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while (j >=0){
            if (i>=0 && nums1[i] >= nums2[j]){
                nums1[index--] = nums1[i--];
            }else {
                nums1[index--] = nums2[j--];
            }
            System.out.println(Arrays.toString(nums1));
        }
    }
}

