package String;

/**
 * 28.实现 strStr()
 *
 * @author 路飞
 * @create 2021/1/27
 */
public class StrStr {
    public static void main(String[] args) {

        String haystack = "hello";
        String needle = "ll";
        int i = strStr(haystack, needle);
        System.out.println(i);

    }

    /**
     * 字符串逐一比较
     * 滑动窗口
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        int count = haystack.length();
        int length = needle.length();

        for (int start = 0; start < count - length + 1; ++ start) {
            if (haystack.substring(start,start + length).equals(needle)){
                return start;
            }
        }
        return -1;
    }
}
