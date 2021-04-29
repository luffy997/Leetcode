package nowcoder;

import java.util.*;

/**
 * @author 路飞
 * @create 2021/4/23 15:36
 */
public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-10,0,10,20,-10,-40};
        threeSum(nums);
    }
    private static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> threeSum(int[] num){
        boolean[] isVisited = new boolean[num.length];
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
        dfs(num,0,0,new ArrayList<>(),isVisited);
        System.out.println(res);
        return res;
    }
    private static void dfs(int[] num,int sum,int cur,List<Integer> list,boolean[] isVisited){
        if (list.size() == 3 && sum == 0){
            res.add(list);
            return;
        }
        if (list.size() > 3) return;
        if (list.size()!=0 && list.get(0) >0)return;
        for (int i = cur; i < num.length; i++) {
            //需要去重
            if (i >0 && !isVisited[i-1] && num[i] == num[i-1]) continue;
            if (isVisited[i]) continue;
            isVisited[i] = true;
            List<Integer> tempList = new ArrayList<>(list);
            tempList.add(num[i]);
            dfs(num,sum-num[i],i,tempList,isVisited);
            isVisited[i] = false;
        }
    }
}
