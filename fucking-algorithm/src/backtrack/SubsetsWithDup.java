package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * medium
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 * @author 路飞
 * @create 2021/3/30 11:04
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    private static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int length = nums.length;
        if (length == 1){
            res.add(Arrays.asList()); //空集
            res.add(Arrays.asList(nums[0]));
            return res;
        }
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[length];
        dfs(length,nums,new ArrayList<Integer>(),isVisited,0);
        return res;
    }


    private static void dfs(int length,int[] nums,List<Integer> temp,boolean[] isVisited,int index){
        res.add(temp);
        //去重
        for (int i = index; i < length; i++) {
            if ( i > 0 && !isVisited[i-1] && nums[i] == nums[i-1] ) continue; //剪枝
            if (isVisited[i]) continue;  //回溯
            isVisited[i] = true;
            List<Integer> list = new ArrayList<>(temp);
            list.add(nums[i]);
            dfs(length,nums,list,isVisited,i);
            isVisited[i] = false;
        }
    }
}
