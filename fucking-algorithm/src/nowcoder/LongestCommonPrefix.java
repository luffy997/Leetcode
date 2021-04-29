package nowcoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 最长公共前缀
 * @author 路飞
 * @create 2021/4/29 19:38
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"abca","abc","abca","abc","abcc","av"};
        System.out.println(m2(strs));
    }
    public static String longestCommonPrefix (String[] strs) {
        if (strs == null || strs.length == 0)return "";
        int minLen = strs[0].length();
        for (String str : strs){
            minLen = Math.min(str.length(),minLen);
        }
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < strs.length;j++) {
                if (strs[0].charAt(i)!= strs[j].charAt(i)){
                    return strs[0].substring(0,res);
                }
            }
          res++;
        }
        return strs[0].substring(0,res);
    }

    public static String m2(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        int len = strs.length;
        int l = Math.min(strs[0].length(),strs[len-1].length());
        int i = 0;
        for (i = 0; i < l; i ++) {
            if (strs[0].charAt(i) != strs[len-1].charAt(i))
                break;
        }
        return strs[0].substring(0,i);
    }
}
