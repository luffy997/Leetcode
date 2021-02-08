package String;

import java.util.ArrayList;

/**
 * 1668. 最大重复子字符串
 * <p>
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * <p>
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 * <p>
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和 word 都只包含小写英文字母。
 *
 * @author 路飞
 * @create 2021/2/7 11:28
 */
public class MaxRepeating {
    public static void main(String[] args) {
        String sequeue = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
//        String sequeue = "ababc";
        String word = "aaaba";
        System.out.println(maxRepeating(sequeue, word));
        System.out.println(function(sequeue, word));
    }

    /**
     * 没有通过第166个测试
     *
     * @param sequence
     * @param word
     * @return
     */
    public static int maxRepeating(String sequence, String word) {
        if (sequence.length() < word.length()) return 0;

        int count = 1;
        int wordLength = word.length();
        StringBuilder sb = new StringBuilder(sequence);
        int start = sequence.indexOf(word);
        if (start > -1) {
            for (int i = start + wordLength; i + wordLength <= sequence.length(); ) {
                if (sb.substring(i, i + wordLength).toString().equals(word)) {
                    ++count;
                    System.out.println("i----" + i);
                    System.out.println("count" + count);
//                    System.out.println(list);
                    i += wordLength;
                } else {
                    //i要返回
                    i++;
                    System.out.println("i:" + i);
                    //不连续 就把count置空
                    count = 0;
                }
            }
        } else {
            return 0;
        }
        return count;
    }

    //换一种思路，上面是sb进行拆分，现在用sb进行拼接

    public static int function(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }
}

