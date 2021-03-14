package dp;

/**
 * easy
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author 路飞
 * @create 2021/3/11 15:00
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));

    }

    /**
     * 简化为今天比昨天大 就可以卖出
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        int len = prices.length;
        if (len <= 1) return 0;

        int res = 0;
        int slow = 0;
        int fast = 1;


        for(slow = 0,fast =1;fast < len;slow ++,fast++){
            if (prices[fast] > prices[slow]){
                res += prices[fast] - prices[slow];
            }
        }
        return res;
    }
}
