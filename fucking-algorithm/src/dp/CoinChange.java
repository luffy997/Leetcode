package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * medium
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的
 *
 * @author 路飞
 * @create 2021/4/5 13:55
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(counChange(coins, 100));
    }

    private static List<Integer> list = new ArrayList<>();
    public static int counChange(int[] coins, int amount){
        //特判
        if (amount ==0 ) return 0;
        if ((coins.length == 1 && coins[0] > amount)) return -1;
        dfs(coins,0,amount,0);
        System.out.println("list-----"+list);
        Collections.sort(list);
        return list.isEmpty()? -1 : list.get(0);

    }

    private static void dfs(int[] coins,int index,int amount,int curKindCount){
        if (amount == 0){
            list.add(curKindCount);
            return;
        }
        if (coins[index] > amount) return;
        for (int i = index; i < coins.length && coins[i] <= amount; i++) {
            dfs(coins,index,amount-coins[i],curKindCount+1);
        }
    }
}
