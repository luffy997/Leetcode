package Array;

import java.util.*;

/**
 * medium
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序
 *
 * @author 路飞
 * @create 2021/3/31 14:50
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("abc",1);
        map.put("bcs",2);
        map.put("ddc",3);
        map.put("adsd",4);

        System.out.println(map.values());

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

       // map.get("ddc").
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values()); //返回map中的List<Stirng>
    }
}
