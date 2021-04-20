package review;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * @author 路飞
 * @create 2021/4/15 15:54
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        findContinuousSequence(15);
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> lists = new LinkedList<>();
        int[] arr = new int[target];
        for (int i = 0; i < target; i++) {
            arr[i] = i+1;
        }
        int slow = 0;
        int fast = 1;
        int sum = 1;
        while (slow < fast && fast <= arr.length /2){
            if (sum < target){
                sum += arr[fast];
                fast++;
            }else if (sum > target){
                sum -= arr[slow];
                slow++;
            }else {
                int[] temp = new int[fast - slow];
                for (int i = slow; i <fast; i++) {
                    temp[i-slow] = arr[i];
                }
                lists.add(temp);
                sum -= arr[slow];
                slow ++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }
}
