package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * medium
 *数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @author 路飞
 * @create 2021/3/29 15:15
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }

    private static void dfs(int left,int right,String str){
        if (left ==0 && right == 0){
            res.add(str);
            return;
        }
        if (left >0) dfs(left-1,right,str+"(");
        if (right >left) dfs(left,right-1,str+")");
    }
}
