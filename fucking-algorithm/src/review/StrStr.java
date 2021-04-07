package review;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * @author 路飞
 * @create 2021/4/6 9:21
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "aa";
        String needle = "aa";
        System.out.println(strStr(haystack, needle));
    }
    public static int strStr(String haystack, String needle){
        if (needle.length() == 0) return 0;

        String temp = "";
        for (int slow = 0, fast = needle.length();  fast<= haystack.length(); fast++) {
            temp = haystack.substring(slow,fast);
              if (haystack.substring(slow,fast).equals(needle)){
                  return slow;
              }else {
                  slow++;
              }
        }
        return -1;
    }
}
