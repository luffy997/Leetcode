package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 中等
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author 路飞
 * @create 2021/2/14 18:15
 */
public class LetterCombinations {
    public static void main(String[] args) {

    }

    public static void letterCombinations(String digits){
        List<String> list = new ArrayList<>();
        //去掉1
        String replace = digits.replace("0", "");

        //
    }

}
