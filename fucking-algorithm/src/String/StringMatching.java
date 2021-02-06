package String;

import java.util.*;

/**
 * 1408. 数组中的字符串匹配
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 *
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] 仅包含小写英文字母。
 * 题目数据 保证 每个 words[i] 都是独一无二的。
 *
 * @author 路飞
 * @create 2021/2/5 16:39
 */
public class StringMatching {
    public static void main(String[] args) {
    String[] words = {"mass","as","hero","superhero"};
        System.out.println(function(words));
    }

    public static List<String> stringMatching(String[] words){
        Set<String> set = new HashSet<>();
        for(int i = 0;i < words.length;i++){
            for(int j = 0;j < words.length;j++){
                if(i != j && words[j].indexOf(words[i]) > -1){
                    set.add(words[i]);
                }
            }
        }
        List<String> list = new ArrayList(set);
        return list;

    }

    public static List<String> function(String[] words){
        Set<String> set = new HashSet<>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && words[j].indexOf(words[i]) > -1){
                    set.add(words[i]);
                }
            }
        }
        List<String> list = new ArrayList<>(set);
        return list;
    }
}
