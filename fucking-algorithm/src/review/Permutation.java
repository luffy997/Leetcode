package review;

import java.util.*;

/**
 * medium
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @author 路飞
 * @create 2021/4/12 17:05
 */
public class Permutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abc")));
    }
    private static Set<String> set = new HashSet<>();
    public static String[] permutation(String s) {
        char[] strArr = s.toCharArray();
        int length = s.length();
        boolean[] isVisited = new boolean[length];
        dfs(strArr,0,isVisited,"",length);
        System.out.println(set);
        return set.toArray(new String[0]);
    }

    private static void dfs(char[] strArr,int index,boolean[] isVisted,String cur,int len){
        if (cur.length()== len){
            set.add(cur);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (set.contains(cur))continue;
            if (isVisted[i]) continue;
            isVisted[i] = true;
            dfs(strArr,i,isVisted,cur+strArr[i],len);
            isVisted[i] = false;
        }
    }
}
