package String;

import java.util.*;

/**
 * 38. 外观数列
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * ........
 * @author 路飞
 * @create 2021/1/28
 */
public class CountAndSay {
    public static void main(String[] args) {
        String s = countAndSay(4);
        System.out.println(s);
    }

    public static String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        result.append(1);
        for (int i = 1; i < n; i++) {
            // 记录当前行的字符串
            StringBuilder s = new StringBuilder();
            // 记录每个数字的开始索引
            int start = 0;
            for (int j = 1; j < result.length(); j++) {
                // 当数字发生改变时执行
                if (result.charAt(j) != result.charAt(start)) {
                    s.append(j - start).append(result.charAt(start));
                    start = j;
                }
            }
            // 字符串最后一个数字
            s.append(result.length() - start).append(result.charAt(start));
            result = s;
        }
        return result.toString();
    }
}
