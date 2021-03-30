package backtrack;

import java.util.*;

/**
 * medium
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * @author 路飞
 * @create 2021/3/30 10:16
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] nums = {2,5,2,1,2};
        System.out.println(combinationSum2(nums, 5));
    }
    private static Set<List<Integer>> set = new HashSet<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        int length = candidates.length;
        if ( length == 1 && candidates[0] != target) return new ArrayList<>(set);
        boolean[] isVisted = new boolean[length];
        Arrays.sort(candidates);
        dfs(length,candidates,target,isVisted,new ArrayList<>(),0);
        return new ArrayList<>(set);
    }

    private static void dfs(int length,int[] candidates, int target,boolean[] isVisted,List<Integer> temp,int index){
        if (target == 0){
            set.add(temp);
            return;
        }

        if (target < candidates[index]) return;
        for (int i = index; i < length; i++) {
            if (isVisted[i]) continue;
            isVisted[i] = true;
            List<Integer> list = new ArrayList<>(temp);
            list.add(candidates[i]);
            dfs(length,candidates,target-candidates[i],isVisted,list,i);
            isVisted[i] = false;
        }

    }
}
