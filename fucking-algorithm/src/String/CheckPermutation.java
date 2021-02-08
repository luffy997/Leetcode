package String;

import java.util.*;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * <p>
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * @author 路飞
 * @create 2021/2/8 19:25
 */
public class CheckPermutation {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bad";
        //System.out.println(checkPermutation(s1, s2));
        System.out.println(function(s1, s2));
    }

    /**
     * hash大法
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutation(String s1, String s2) {

        Map<Character, Integer> map_one = new HashMap<>();
        Map<Character, Integer> map_two = new HashMap<>();
        char[] chars_one = s1.toCharArray();
        char[] chars_two = s2.toCharArray();

        for (char c : chars_one) {
            Integer count = map_one.get(c);
            count = count == null ? 1 : ++count;
            map_one.put(c, count);
        }

        for (char c : chars_two) {
            Integer count = map_two.get(c);
            count = count == null ? 1 : ++count;
            map_two.put(c, count);
        }

        System.out.println(map_one);
        System.out.println(map_two);

        if (map_one.size() != map_two.size()) return false;

        //最快遍历hashmap的方法
        Set<Map.Entry<Character, Integer>> entrySet = map_one.entrySet();
        Iterator<Map.Entry<Character, Integer>> iter = entrySet.iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> entry = iter.next();
            //第二个map的key不存在 或者 key对应的v与第一个map的value不相等就返回false
            if ((map_two.get(entry.getKey()) == null) || !(map_two.get(entry.getKey()).equals(entry.getValue())))
                return false;
        }

        return true;

    }

    //asci码
    public static boolean function(String s1, String s2){

        if (s1.length() != s2.length()) return false;

        int length = s1.length();
        int[] intOne = new int[length];
        int[] intTwo = new int[length];

        for (int i = 0; i < length; i++) {
            intOne[i] = s1.charAt(i);
        }

        for (int i = 0; i < length; i++) {
            intTwo[i] = s2.charAt(i);
        }


        //排序
        Arrays.sort(intOne);
        Arrays.sort(intTwo);

       return Arrays.equals(intOne,intTwo);

    }
}
