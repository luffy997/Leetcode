package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * easy
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * @author 路飞
 * @create 2021/3/21 8:26
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        int taraget = 9;
        findContinuousSequence(9);
    }

    /**
     * 滑动窗口+双指针
     * @param target
     * @return
     */
    public static void findContinuousSequence(int target){

        int slow = 1;
        int fast = 2;
        int sum = 3;
        List<int[]> res = new ArrayList<>();

        while (slow < fast && fast < target){
            if (sum == target){
                int[] temp = new int[fast - slow + 1];
                for(int i = slow;i <=fast;i++){
                    temp[i - slow] = i;
                }
                res.add(temp);
            }
            if (sum >= target){
                sum -= slow;
                slow++;
            }else {
                fast++;
                sum +=fast;
            }

        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i)));
        }
    }
}
