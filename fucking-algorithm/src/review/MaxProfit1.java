package review;

/**
 * 剑指 Offer 63. 股票的最大利润
 * @author 路飞
 * @create 2021/4/17 10:23
 */
public class MaxProfit1 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        if (prices == null ||prices.length == 0) return  0 ;
        int buy = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy,prices[i]);
            max = Math.max(max,prices[i] - buy);
        }
        return max;
    }
}
