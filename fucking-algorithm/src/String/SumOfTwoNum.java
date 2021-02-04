package String;

import sun.security.krb5.internal.crypto.Aes128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数求和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 *
 * @author 路飞
 * @create 2021/1/27
 */
public class SumOfTwoNum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int[] num = find(nums, 6);
        System.out.println(Arrays.toString(num));

    }

    /**
     * 暴力匹配
     * @param nums
     * @param target
     * @return
     */
    public static int[] findNumS(int[] nums, int target) {

        int len = nums.length;

        for (int f = 0; f < len - 1; f++) {
            for (int i = f + 1; i <= len - 1; i++) {
                if (nums[f] + nums[i] == target) {
                    return new int[]{f, i};
                }
            }
        }
        return null;
    }

    /**
     * 利用hash表改进
     * 分析：题目要求很低，只需要找到数组中两个数之和为目标值即可，比较暴力解法，很严重的耗时问题在遍历那块，很多数都在重复遍历，
     * 所以利用HashMap不能重复插入key这个特点，可以很方便的找到target - num[i]这个值
     * @param nums
     * @param target
     * @return
     */
    public static int[] find(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return  null;
    }
}
