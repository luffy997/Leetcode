package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 加起来和为目标值的组合
 *
 *
 * @author 路飞
 * @create 2021/4/29 17:19
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] nums ={100,10,20,70,60,10,50};
        System.out.println(combinationSum2(nums, 80));
    }
    //num是递减的
    //题目中所有的数字（包括目标数）都是正整数
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0)return res;
        Arrays.sort(num);
        boolean[] isVisited = new boolean[num.length];
        dfs(num,0,target,new ArrayList<Integer>(),isVisited);
        return res;
    }

    private static void dfs(int[] num,int index,int target,ArrayList<Integer> list,boolean[] isVisited){

       // if (num[index] > target)return;
        if (target < 0) return;
        if (target == 0){
            res.add(list);
            return;
        }
        if (num[index] > target)return;
        for (int i = index; i < num.length; i++) {
            //剪枝
            if ( i > 0 && !isVisited[i-1] && num[i] == num[i-1] ) continue;
            if (isVisited[i])continue;
            isVisited[i] = true;
            ArrayList<Integer> temp = new ArrayList<>(list);
            temp.add(num[i]);
            dfs(num,i,target-num[i],temp,isVisited);
            isVisited[i] = false;
        }
    }
}
