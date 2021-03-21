package Array;

import java.util.*;

/**
 * medium
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 2 <= nums.length <= 10000
 * @author 路飞
 * @create 2021/3/21 15:57
 */
public class SingleNumbers {
    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

    /**
     * HashMap 时间复杂度和空间复杂度都是O(n) 不推荐使用
     * 这里可以使用位运算
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums){

        Map<Integer, Integer> map = new HashMap<>();
        int[] res= new int[2];
        for(int num : nums){
            Integer count = map.get(num);
            count = count == null ? 1 : ++count;
            map.put(num,count);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        int i = 0;
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue().equals(1)){
                res[i] = next.getKey();
                i++;
            }
        }
        return res;
    }

  }

