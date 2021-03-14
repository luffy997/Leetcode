package dp;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * @author 路飞
 * @create 2021/3/8 21:06
 */
public class MaxProfit1 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static  int maxProfit(int[] prices){
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max,prices[i]  - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}
