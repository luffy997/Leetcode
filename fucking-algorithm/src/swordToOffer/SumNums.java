package swordToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 路飞
 * @create 2021/4/8 12:12
 */
public class SumNums {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findContinuousSequence(9)));
    }

    //滑动窗口 左开右闭
    public static int[][] findContinuousSequence(int target){

        int start = 1;
        int end = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (start <= target / 2){
            if (sum < target){
                sum+=end;
                end++;
            }else if (sum > target){
                sum -= start;
                start++;
            }else {
                int[] arr = new int[end-start];
                for (int i = start; i < end; i++) {
                    arr[i-start] = i;
                }
                res.add(arr);
                sum-=start;
                start++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
