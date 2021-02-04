package String;


import java.util.*;

/**
 * 819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 * @author 路飞
 * @create 2021/2/3 15:26
 */
public class MostCommonWord {
    public static void main(String[] args) {
        //ansic 大小写相差32  'a' - 'A' = 32  97 - 65
        //'z' - 'Z' = 122 -90
        String paragraph = "Bob";
        String[] banned = {};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned){
        //paragraph 转小写 转数组

        char[] chars = (paragraph+" ").toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();

        for (char c : chars){
            //判断是不是小写
            if (rangeInDefined(Integer.valueOf(c),97,122)){
                sb.append(c);
            }else {
                //不是小写的 以 "":? 存储在map中
                Integer count = map.get(sb.toString());
                count = count == null ? 1 : ++ count;
                map.put(sb.toString(),count);
                sb.delete(0,sb.length());
            }
        }
        map.remove("");

        //删除列表中的单词
        if (banned.length ==0 || banned[0] == null){

            List<Map.Entry<String,Integer>> list = new ArrayList(map.entrySet());
            Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
            return list.get(list.size() -1).getKey();

        }

        for (int i = 0; i < banned.length; i++) {
            map.remove(banned[i]);
        }

        List<Map.Entry<String,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
        return list.get(list.size() -1).getKey();

    }


    //判断在不在范围
    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }
}
