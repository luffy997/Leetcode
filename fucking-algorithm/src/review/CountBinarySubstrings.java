package review;

import java.util.LinkedList;
import java.util.List;

/**
 * 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
 * 重复出现的子串要计算它们出现的次数。
 *
 * @author 路飞
 * @create 2021/4/6 17:08
 */
public class CountBinarySubstrings {
    public static void main(String[] args) {
        String s = "10101";
        countBinarySubstrings(s);
    }

    //先统计连续的0和1分别有多少个，如：
    // 111100011000，得到4323；在4323中的任意相邻两个数字，取小的一个加起来，就是3+2+2 = 7.
    //用list超时了
    public static void countBinarySubstrings(String s) {
        int length = s.length();
        //if (length == 1) return 0;
        List<Integer> list = new LinkedList<>();

        int i = 0;
        while (i < length) {
            char c = s.charAt(i);
            int count = 0;
            while (i < length && s.charAt(i) == c) {
                ++i;
                ++count;
            }
            list.add(count);
        }
        System.out.println(list);
        int res = 0;
        for (int j = 1; j < list.size(); j++) {
            res += Math.min(list.get(j - 1), list.get(j));
        }
        System.out.println(res);
    }

    public static int m2(String s) {
        int length = s.length();
        if (length == 1) return 0;

        int i = 0;
        int res = 0;
        int last = 0;
        while (i < length) {
            char c = s.charAt(i);
            int count = 0;
            while (i < length && s.charAt(i) == c) {
                ++i;
                ++count;
            }
            //count 是每次在更新的
            //last会晚一步
            res += Math.min(count, last);
            last = count;
        }
        return res;
    }
}
