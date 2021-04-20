package search;

import java.util.Arrays;

/**
 * medium
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * @author 路飞
 * @create 2021/4/12 8:31
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {123,4567};
        System.out.println(largestNumber(nums));
    }
    public static String largestNumber(int[] nums) {
        int length = nums.length;
        String[] numToWord = new String[length];
        for (int i = 0; i < length; i++) {
            numToWord[i] = String.valueOf(nums[i]);
        }
        System.out.println(Arrays.toString(numToWord));
        Arrays.sort(numToWord,(a,b)->{
            System.out.println("a---"+a);
            System.out.println("b---"+b);
            System.out.println("a+b---"+(a+b));
            System.out.println("b+a---"+(b+a));
            return (b+a).compareTo(a+b);
        });
        System.out.println(Arrays.toString(numToWord));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(numToWord[i]);
        }
        System.out.println(Runtime.getRuntime().availableProcessors());
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0":res;

    }
}
