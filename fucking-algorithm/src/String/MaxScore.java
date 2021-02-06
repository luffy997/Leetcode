package String;

import java.util.Arrays;

/**
 * 1422. 分割字符串的最大得分
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 *
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 *
 * 2 <= s.length <= 500
 * 字符串 s 仅由字符 '0' 和 '1' 组成。
 *
 * @author 路飞
 * @create 2021/2/5 18:12
 */
public class MaxScore {
    public static void main(String[] args) {
    String s = "1111";
        System.out.println(maxScore(s));
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public static int maxScore(String s){
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] lenArray = new int[length -1];
        int countLeft = 0;
        int countRight = 0;
        int temp = 0;
        int result = 0;
        for (int i = 0,index = 1; i < length && index < length ; i++,index++) {
            if (i !=0){
                countLeft = temp;
            }
            //每个每个的划分
            if (chars[i] == '0'){
                ++countLeft;
            }

            while (index < length){
                if (chars[index] == '1'){
                    ++countRight;
                    index++;
                }else {
                    index++;
                }

            }
            lenArray[i] = countLeft + countRight;
            index = i +1;
            temp = countLeft;
            countLeft = 0;
            countRight = 0;
        }
        Arrays.sort(lenArray);
        return lenArray[length-2];
    }
}
