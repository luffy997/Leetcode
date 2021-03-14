package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * medium
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * @author 路飞
 * @create 2021/3/10 13:07
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<Integer> son = new ArrayList<>();
        List<List<Integer>> parent = new ArrayList<>();
        parent.add(Arrays.asList(2));
        parent.add(Arrays.asList(3,4));
        parent.add(Arrays.asList(6,5,7));
        parent.add(Arrays.asList(4,1,8,3));
        System.out.println(parent);

        System.out.println(minimumTotal(parent));
    }

    public static int minimumTotal(List<List<Integer>> triangle){
        int len = triangle.size();
        if(len <= 1) return triangle.get(0).get(0);
        
        int[][] dp = new int[len + 1][len +1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }   
        }
        return dp[0][0];
        


    }
}
