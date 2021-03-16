package dfs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * medium
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * @author 路飞
 * @create 2021/3/16 10:49
 */
public class Permutation {
    private static LinkedList<String> result = new LinkedList<>();
    private static StringBuilder curPath = new StringBuilder();
    private  static boolean[] used;
    public static void main(String[] args) {
        String  s = "abc";
        System.out.println(Arrays.toString(permutation(s)));
    }

    public static String[] permutation(String s){
        if (s == null) return null;
        used = new boolean[s.length()];
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray); //排序，方便后面的剪枝

        dfs(charArray,s.length(),0);
        return result.toArray(new String[result.size()]);
    }

    private static void dfs(char[] charArray,int targetLength,int curLength){
        if (targetLength == curLength){
            result.add(curPath.toString());
            return;
        }
        //遍历原字符串的每一个字符，将每个字符都在当前位置设置，并递归计算所有可能结果
        for (int i = 0; i < targetLength; i++) {
            if (!used[i]){
                if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1]) //剪枝
                    continue;
            }
            used[i] = true;
            curPath.append(charArray[i]);
            dfs(charArray,targetLength,curLength + 1);
            curPath.deleteCharAt(curPath.length() - 1);
            used[i] = false;
        }
    }
}
