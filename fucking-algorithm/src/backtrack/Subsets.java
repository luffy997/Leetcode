package backtrack;

import java.util.*;

/**
 * medium
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author 路飞
 * @create 2021/3/30 10:40
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(subsets(nums));
    }


    private static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        if (length == 1){
            res.add(Arrays.asList()); //空集
            res.add(Arrays.asList(nums[0]));
            return res;
        }
        boolean[] isVisited = new boolean[length];
        dfs(length,nums,new ArrayList<Integer>(),isVisited,0);
        return res;

    }

    private static void dfs(int length,int[] nums,List<Integer> temp,boolean[] isVisited,int index){
        res.add(temp);
        for (int i = index; i < length; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            List<Integer> list = new ArrayList<>(temp);
            list.add(nums[i]);
            dfs(length,nums,list,isVisited,i);
            isVisited[i] = false;
        }
    }
}
