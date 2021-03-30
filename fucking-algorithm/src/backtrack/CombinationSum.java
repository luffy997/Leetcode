package backtrack;

import java.util.*;

/**
 * medium
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * @author 路飞
 * @create 2021/3/30 9:10
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        System.out.println(combinationSum(nums, 8));
    }

    private static Set<List<Integer>> set = new HashSet<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 1 && target < candidates[0]) return new ArrayList<>(set);
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),0);
        return new ArrayList<>(set);

    }

    private static void dfs(int[] candidates,int target,List<Integer> temp,int index){
        if (target == 0){
            set.add(temp);
            return;
        }

        for (int i = index; i < candidates.length && candidates[i]<= target; i++) {
            List<Integer> list = new ArrayList<>(temp);
            list.add(candidates[i]);
            dfs(candidates,target-candidates[i],list,i);
        }

    }
}

