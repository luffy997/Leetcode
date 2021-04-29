package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 有重复字符串的所有排列
 * @author 路飞
 * @create 2021/4/28 19:52
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int[] num = {1,1,2};
        System.out.println(permuteUnique(num));
    }

    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0)return res;
        boolean[] isVisited = new boolean[num.length];
        dfs(num,isVisited,new ArrayList<Integer>());
        return res;
    }

    private static void dfs(int[] num,boolean[] isVisited,ArrayList<Integer> list){
        if (list.size() == num.length){
            res.add(list);
            return;
        }
        for (int j = 0; j < num.length; j++) {
            if (j > 0 && !isVisited[j-1] && num[j] == num[j-1])continue;
            if (isVisited[j])continue;
            isVisited[j] = true;
            ArrayList<Integer> temp = new ArrayList<>(list);
            temp.add(num[j]);
            dfs(num,isVisited,temp);
            isVisited[j]=false;
        }
    }
}
