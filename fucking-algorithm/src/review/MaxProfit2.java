package review;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author 路飞
 * @create 2021/4/17 10:32
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProFit(prices));
    }

    public static int maxProFit(int[] prices){
        if (prices == null || prices.length == 0) return 0;
        int slow = 0;
        int fast = 1;
        int proFit = 0;
        for (slow = 0,fast = 1; fast < prices.length; slow++,fast++) {
            //只要后一天的比前一天的大 那我就卖
            if (prices[fast] > prices[slow]) proFit += (prices[fast] - prices[slow]);
        }
        return proFit;
    }
}
