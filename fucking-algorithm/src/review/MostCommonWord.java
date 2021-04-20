package review;

import java.util.*;

/**
 * 819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 * @author 路飞
 * @create 2021/4/7 18:22
 */
public class MostCommonWord {
    public static void main(String[] args) {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(s, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String trim = paragraph.trim();
        String str = trim.toLowerCase();
        str = str.replace('!', ' ');
        str = str.replace('?', ' ');
        str = str.replace(';', ' ');
        str = str.replace(',', ' ');
        str = str.replace('.', ' ');
        str = str.replace('\'', ' ');
        System.out.println(str);
        String[] s = str.split("\\s+"); //一个或者多个空格
        System.out.println(Arrays.toString(s));
        //HashMap存储
        //空格分开
        Map<String, Integer> map = new HashMap<>();

        for (String temp : s) {
            Integer count = map.get(temp);
            count = count == null ? 1 : ++count;

            map.put(temp, count);
        }


        //删除禁用单词
        for (String temp : banned) {
            map.remove(temp);
        }
        //根据value排序，取出value最大对应的key
        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
        return list.get(list.size() - 1).getKey();
    }
}
