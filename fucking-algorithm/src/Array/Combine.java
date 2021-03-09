package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author 路飞
 * @create 2021/2/15 16:10
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println(function(4, 3));
        int[] res = {};
        for (int i = 0; i < res.length; i++) {

        }
    }

    /**
     * 套公式
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k <=0) return res;

        res = combine(n-1,k-1);

        if (res.size() == 0){
            res.add(new ArrayList<Integer>());
        }

        for (List<Integer> list : res){
            list.add(n);
        }

        res.addAll(combine(n-1,k));
        return res;

    }


    public static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<Integer> list = new ArrayList<>();
    public static int n;
    public static int k;

    /**
     * 回溯模板
     */
    public  static List<List<Integer>> function(int n,int k){


        backtrack(1);

        return res;
    }

    public static void backtrack(int start){
        //退出条件
        if (list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(i+1);
            list.remove(list.size() - 1);
        }
    }
}
