package nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author 路飞
 * @create 2021/4/22 10:26
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {20, 70, 110, 150};
        System.out.println(Arrays.toString(twoSum(nums, 90)));
    }

    public static int[] twoSum(int[] numbers, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int[] res = new int[2];
        for(int num : numbers){
            if (map.containsKey(target-num)){
                res[0] = map.get(target-num)+1;
                res[1] = i+1;
                break;
            }
            map.put(num,i);
            i++;
        }
        return res;
    }
}
