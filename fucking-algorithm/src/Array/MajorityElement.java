package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * easy
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 1 <= 数组长度 <= 50000
 * @author 路飞
 * @create 2021/3/20 16:30
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }

    /**
     * HashMap
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums){
        int length = nums.length;
        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            Integer count = map.get(num);
            if (count != null && count >= (length / 2)) //短路原理
                return num;
            else {
                count = count == null ? 1 : ++count;
                map.put(num,count);
            }
        }
        System.out.println(map);
        return -1;
    }
}
