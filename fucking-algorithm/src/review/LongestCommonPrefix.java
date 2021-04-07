package review;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author 路飞
 * @create 2021/4/6 8:35
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"cir","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs){
        int length = strs.length;
        if (length == 0) return "";
        if (length == 1) return strs[0];

        int len = Integer.MAX_VALUE;
        for (String s : strs){
            len = Math.min(s.length(),len);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < length; j++) {
                if (strs[j].charAt(i) != c ){
                    return sb.toString();
                }
                if (j == length - 1) sb.append(c);
            }
        }
        return sb.toString();
    }
}
