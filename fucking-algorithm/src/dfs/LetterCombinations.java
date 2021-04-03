package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * medium
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author 路飞
 * @create 2021/3/31 8:33
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static final String[] letters = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};




    private static List<String> res = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        int length = digits.length();
        //特判
       if (length == 0) return Collections.emptyList();

        dfs(digits, 0,"",length);
        return res;
    }


    private static void dfs(String digits,int index,String str,int length){
        if (index == length){
            res.add(str);
            return;
        }
        int num = digits.charAt(index) - '0';
        for (int i = 0; i < letters[num].length(); i++) {
            dfs(digits,index+1,str+letters[num].charAt(i),length);
        }
    }
}
