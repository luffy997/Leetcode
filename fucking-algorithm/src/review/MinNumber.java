package review;

import java.util.Arrays;

/**
 * medium
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @author 路飞
 * @create 2021/4/14 17:23
 */
public class MinNumber {
    public static void main(String[] args) {
        int[] num = {3,30,34,5,9};
        System.out.println(minNumber(num));
    }
    public static String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(x,y)->
            (x+y).compareTo(y+x)
        );
        System.out.println(Arrays.toString(strs));
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s);
        }
        return res.toString();
    }
}
