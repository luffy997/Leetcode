package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 1189. “气球” 的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 *
 * @author 路飞
 * @create 2021/2/4 21:17
 */
public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        String text = "leetcode";

        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {
        //利用map存储单词次数
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = text.toCharArray();
        for (char c : chars) {
            Integer count = map.get(c);
            count = count == null ? 1 : ++count;
            map.put(c, count);
        }

        //balloon  b:1 a:1 l:2 o:2 n:1
        //木桶效应 balloon的个数由次数最小的决定
        if (map.get('b') == null || map.get('a') == null || map.get('l') == null || map.get('o') == null || map.get('n') == null)
            return 0;

        return Math.min(Math.min(Math.min(2 * map.get('b'), 2 * map.get('a')), Math.min(map.get('l'), map.get('o'))), 2 * map.get('n')) / 2;
    }
}
