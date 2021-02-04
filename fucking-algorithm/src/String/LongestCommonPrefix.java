package String;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author 路飞
 * @create 2021/1/27
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"cir", "car"};
        String s = findLongest(str);
        System.out.println(s);
    }

//    public static String longestCommonPrefix(String[] strs) {
//        int len = strs.length;
//        Map<Character, Integer> map = new HashMap<>();
//        StringBuilder stringBuilder = new StringBuilder();
//
//    if (strs.length ==1){
//        return strs[0];
//    }
//        for (int j = 0; j < len-1; j++) {
//            map.clear();
//            if (stringBuilder.length() == 0){
//                for (int i = 0; i < strs[j].length(); i++) {
//                    map.put(strs[0].charAt(i), i);
//                }
//            }else {
//                for (int i = 0; i < stringBuilder.length(); i++) {
//                    map.put(stringBuilder.charAt(i), i);
//                }
//            }
//
//        stringBuilder.delete(0,stringBuilder.length());
//
//            for (int i = 0; i < strs[j + 1].length(); i++) {
//                if (!map.containsKey(strs[j + 1].charAt(i)) && map.get(strs[j+1].charAt(i)) != i) {
//                  break;
//
//                }
//                stringBuilder.append(strs[j+1].charAt(i));
//
//            }
//
//        }
//        return  stringBuilder.toString();
//
//
//    }

    /**
     * 横向 两个一对比，取出公共子串，再与下一个对比
     * @param strs
     */
    public static void longestCommonPrefix01(String[] strs) {

    }

    /**
     * 纵向对比
     * 纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，
     * 如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，
     * 当前列之前的部分为最长公共前缀。
     *
     * @param strs
     */
    public static String longestCommonPrefix02(String[] strs) {
        if (strs.length == 0 || strs == null){
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            //拿第一个和其他的字符串作比较，遇到不一样的，就取前面一样的部分
            char c = strs[0].charAt(i);
            for (int j = 0; j < count; j++) {
                //i == strs[j].length() 木桶效应 若较短字符串长度一样 而且已经比较的都相等，直接返回！
                if (i == strs[j].length() || strs[j].charAt(i) !=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }


    public static String findLongest(String[] str){
        if (str == null || str.length ==0){
            return "";
        }
        int length = str[0].length();
        int count = str.length;

        for (int i = 0; i < length; i++) {
            char c = str[0].charAt(i);
            for (int j = 0; j < count; j++) {
                if (i == str[j].length() || str[j].charAt(i) != c){
                    return str[0].substring(0,i);
                }
            }

        }
        return str[0];
    }
}
