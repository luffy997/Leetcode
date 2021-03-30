package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * medium
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * @author 路飞
 * @create 2021/3/30 9:59
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums){
        //特判
        int length = nums.length;
        if (length == 1) return Arrays.asList(Arrays.asList(1));
        boolean[] isVisited = new boolean[length];
        dfs(length,nums,isVisited,new ArrayList());
        return res;
    }

    private static void dfs(int length,int[] nums,boolean isVisted[],List<Integer> temp){
        if (temp.size() == length){
            res.add(temp);
            return;
        }
        for (int i = 0; i < length; i++) {
            if (isVisted[i]) continue;
            isVisted[i] = true;
            List<Integer> list = new ArrayList<>(temp);
            list.add(nums[i]);
            dfs(length,nums,isVisted,list);
            isVisted[i] = false;
        }
    }
}
