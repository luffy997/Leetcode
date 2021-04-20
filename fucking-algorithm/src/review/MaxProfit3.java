package review;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author 路飞
 * @create 2021/4/17 10:54
 */
public class MaxProfit3 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }

    /**
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        if (prices == null || prices.length == 0) return 0;
        int firstBuy = Integer.MIN_VALUE,firstSell = 0;
        int seconedBuy = Integer.MIN_VALUE,seconedSell = 0;
        for (int p : prices){
            firstBuy = Math.max(firstBuy,-p);
            firstSell = Math.max(firstSell,firstBuy + p);
            seconedBuy = Math.max(seconedBuy,firstSell - p);
            seconedSell = Math.max(seconedBuy,seconedBuy + p);
        }
        return seconedSell;
    }
}
