package cup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 采购方案
 * @author 路飞
 * @create 2021/4/5 15:06
 */
public class PurchasePlans {
    public static void main(String[] args) {
        int[] nums = {2,2,1,9};
        System.out.println(purchasePlans(nums, 10));
    }
    private static long count = 0;
    public static int purchasePlans(int[] nums, int target) {
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,isVisited,target,0);
       return (int) (count%1000000007);
    }

    public static void dfs(int[] nums,int index,boolean[] isVisited,int target,int counNum) {
        if (target >= 0 && counNum == 2) {
            count++;
            count = count % 1000000007;
            return;
        }
        if (nums[index] > target) return;
        for (int i = index; i < nums.length; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            dfs(nums, i, isVisited, target - nums[i], counNum + 1);
            isVisited[i] = false;
        }
    }
        //1.先排序(这里使用的是快速排序){1,3,4,6,7,8,9};
//        Arrays.sort(nums);
//        //2.次数num是已经排序好的数组,从两边遍历已排序的数组
//        int count = 0;
//        for (int left = 0, right = nums.length - 1; left < right; ) {
//            //2.1.相等的话,直接输出即可
//            if (nums[left] + nums[right] == target) {
//                System.out.println(nums[left] + "+" + nums[right] + "=" + target);
//                count +=(count+1)%1000000007;
//                left++;
//                right--;
//            } else if (nums[left] + nums[right] < target) {
//                count +=(count+1)%1000000007;
//                //2.2.相加小于目标值,则left++
//                left++;
//            } else {
//                //2.3.相加大于目标值,则 right--
//                right--;
//            }
//        }
//        System.out.println(count%1000000007);
//    }
}
