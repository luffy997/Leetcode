package review;

import java.util.ArrayList;
import java.util.List;

/**
 * 零钱兑换
 * @author 路飞
 * @create 2021/4/23 9:11
 */
public class CoinChange {
    public static void main(String[] args) {

    }

    /**
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     *
     * @param coins
     * @param amount
     * @return
     */
    private static List<Integer> list = new ArrayList<>();
    public static void coinChange(int[] coins, int amount) {

    }

    private static void dfs(int[] coins,int amount,int countCoins){
        if (amount < 0) return;
        if (amount == 0){
            list.add(countCoins);
            return;
        }



    }
}
