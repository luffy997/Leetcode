package review;

import java.util.HashSet;
import java.util.Set;

/**
 * medium
 * 522. 最长特殊序列 II
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1
 * @author 路飞
 * @create 2021/4/6 11:38
 */
public class FindLUSlength2 {
    public static void main(String[] args) {
        String[] strs = {"aba","aba","eae"};
        System.out.println(findLUSlength(strs));
    }

    public static int findLUSlength(String[] strs) {
        Set<String> set = new HashSet<>();
        int res = 0;
        for (String s : strs){
            if (!set.add(s)) return -1;
            res = Math.max(res,s.length());
        }
        return res;
    }
}
