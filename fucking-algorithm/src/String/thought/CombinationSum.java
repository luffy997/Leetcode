package String.thought;

import java.util.List;

/**
 * medium
 * 39. 组合总和
 * 回溯算法的实践
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 模板：
 * function fn(n){
 *   //第一步：判断输入或者状态是否合法
 *   if(input/state is invalid){
 *       return;
 *   }
 *   //第二步：判断递归是否应该结束
 *   if(match codition){
 *       return some value;
 *   }
 *   //遍历所有可能出现的情况
 *   for(all possible cases){
 *      //第三步：尝试下一步的可能性
 *       solution.push(case)
 *      //递归
 *      result = fn(m)
 *      //第四步：回溯到上一步
 *      solution.pop(case)
 *   }
 * }
 *
 * @author 路飞
 * @create 2021/2/15 9:55
 */
public class CombinationSum {
    public static void main(String[] args) {

    }

    public static void combinationSum(int[] candidates, int target){

    }
}
