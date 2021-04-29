package nowcoder;

import java.util.ArrayList;

/**
 * 括号生成器
 *
 * @author 路飞
 * @create 2021/4/27 15:13
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    private static ArrayList<String> res = new ArrayList<>();

    public static ArrayList<String> generateParenthesis(int n) {
        if (n < 1) return res;
        dfs(n, n, "");
        return res;
    }

    private static void dfs(int left, int right, String cur) {
        if (left == 0 && right == 0) {
            res.add(cur);
        }
            if (left > 0) dfs(left - 1, right, cur + "(");
            if (right > left) dfs(left, right -1, cur + ")");

    }
}
