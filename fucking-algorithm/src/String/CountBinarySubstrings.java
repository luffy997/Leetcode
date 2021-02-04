package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. 计数二进制子串
 *
 * 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，
 * 并且这些子字符串中的所有 0 和所有 1 都是连续的。
 *
 * 重复出现的子串要计算它们出现的次数
 *
 * 题目描述的跟个si一样
 *
 * @author 路飞
 * @create 2021/2/3 10:06
 */
public class CountBinarySubstrings {
    public static void main(String[] args) {
        String s = "00110";
        System.out.println(countBinarySubstrings(s));
        System.out.println(countBinarySubstrings(s));
    }

    /**
     * 我们可以将字符串 s 按照 0 和 1 的连续段分组，存在 counts 数组中，s=00111011，可以得到这样的 counts
     * 数组：{counts} = {2, 3, 1, 2}
     *
     * 这里counts 数组中两个相邻的数一定代表的是两种不同的字符。假设counts 数组中两个相邻的数字为 u 或者 v，
     * 它们对应着 u 个 0和 v 个 11，或者 u 个 1 和 v 个 0。它们能组成的满足条件的子串数目为min{u,v}，
     * 即一对相邻的数字对答案的贡献。
     *
     * 我们只要遍历所有相邻的数对，求它们的贡献总和，即可得到答案。
     *
     * @param s
     * @return
     */
    public static int countBinarySubstrings(String s){
        List<Integer> counts = new ArrayList<>();
        int ptr = 0;
        int n = s.length();
        while (ptr < n){
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c){
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans +=Math.min(counts.get(i),counts.get(i-1));
        }
        return ans;
    }

    public static int function(String s){
        List<Integer> list = new ArrayList<>();
        int pre = 0;
        int length = s.length();
        int res = 0;
        while (pre < length){
            char c = s.charAt(pre);
            int count = 0;
            while (pre < length && s.charAt(pre) == c){
                ++count;
                ++pre;
            }
        }
        for (int i = 1; i < list.size(); i++) {
            res += Math.min(list.get(i),list.get(i -1));
        }
        return res;
    }
}
