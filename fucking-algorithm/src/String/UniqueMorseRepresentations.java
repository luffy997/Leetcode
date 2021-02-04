package String;

import java.util.HashSet;

/**
 * 804. 唯一摩尔斯密码词
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，
 *  比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 * 单词列表words 的长度不会超过 100。
 * 每个单词 words[i]的长度范围为 [1, 12]。
 * 每个单词 words[i]只包含小写字母。
 *
 * @author 路飞
 * @create 2021/2/3 11:48
 */
public class UniqueMorseRepresentations {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));

    }

    /**
     * 利用set实现
     *
     * @param words
     * @return
     */
    public static int uniqueMorseRepresentations(String[] words) {
        String[] rule = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int count = words.length;
        String temp = "";
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        char[] charsTemp;
        for (int i = 0; i < count; i++) {
            temp = words[i];
            charsTemp = temp.toCharArray();
            for (int j = 0; j < charsTemp.length; j++) {
                sb.append(rule[charsTemp[j] - 97]);
                if (j == charsTemp.length -1){
                    set.add(sb.toString());
                    sb.delete(0,sb.length());
                }
            }
        }
        return set.size();
    }
}
