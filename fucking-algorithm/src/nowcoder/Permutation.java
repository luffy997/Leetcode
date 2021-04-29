package nowcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 字符串排列
 * @author 路飞
 * @create 2021/4/24 16:34
 */
public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        permutation(str);

    }

    private static Set<String> set = new HashSet<>();
    public static ArrayList<String> permutation(String str) {
        boolean[] isVisited = new boolean[str.length()];
        dfs(str,"",isVisited);
        return  new ArrayList<>(set);
    }

    private static void dfs(String str,String curStr,boolean[] isVisited){
        if (curStr.length() == str.length()){
            set.add(curStr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isVisited[i])continue;
            isVisited[i] = true;
            dfs(str,curStr+ str.charAt(i),isVisited);
            isVisited[i] = false;
        }
    }
}
