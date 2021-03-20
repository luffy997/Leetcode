package backtrack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * @author 路飞
 * @create 2021/3/19 9:49
 */
public class Permutation {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Arrays.toString(permutation(s)));
    }
     private static Set<String> set = new HashSet<>();

    public static String[] permutation(String s){

        int len = s.length();
        char[] array = s.toCharArray();
        boolean[] visited = new boolean[len];
        dfs(array,"",visited); //从空字符串开始
        String[] res = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()){
            String next = iterator.next();
            res[i] = next;
            i++;
        }
        return res;
    }

    private static void dfs(char[] array,String s,boolean[] visited){
        if(s.length() == array.length){
            set.add(s);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(array,s+String.valueOf(array[i]),visited);
            visited[i] = false;
        }
    }

}
