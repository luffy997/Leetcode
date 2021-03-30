package twohand;

import java.util.*;

/**
 * medium
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author 路飞
 * @create 2021/3/29 10:42
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len <= 2) return new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        if (nums == null || len < 3) return new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;

            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    L++;
                    R--;
                } else if (sum > 0) R--;
                else if (sum < 0) L++;
            }
        }

        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}
