package writeExam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 路飞
 * @create 2021/4/27 20:07
 */
public class M3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int diamondCount = Integer.parseInt(input.nextLine().trim());
        int knapsackCap = Integer.parseInt(input.nextLine().trim());
        String[] weightsStr = input.nextLine().split(" ");
        int[] weights = new int[weightsStr.length];
        for (int i = 0; i < weightsStr.length; i++) {
            weights[i] = Integer.parseInt(weightsStr[i].trim());
        }
        String[] valuesStr = input.nextLine().split(" ");
        int[] values = new  int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }
        System.out.println(method(diamondCount, knapsackCap, weights, values));
        input.close();
    }
   public static int method(int diamondCount,int knapsackCapacity,int[] weights,int[] values){
        int[] [] dp = new int[diamondCount+1][knapsackCapacity+1];
       for (int i = 0; i < dp.length; i++) {
           dp[i][0] = 1;
       }
       for (int i = 1; i < diamondCount+1; i++) {
           for (int j = 1; j < knapsackCapacity+1; j++) {
               if(weights[i-1] > j){
                   dp[i][j] = dp[i-1][j];
               }else {
                   dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]+values[i-1]]);
               }
           }
       }
       return dp[diamondCount][knapsackCapacity];

   }
}
