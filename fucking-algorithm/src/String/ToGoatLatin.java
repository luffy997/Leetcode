package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 824. 山羊拉丁文
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * 山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 *
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 *
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 *
 * S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
 * 1 <= S.length <= 150。
 *
 * @author 路飞
 * @create 2021/2/3 16:56
 */
public class ToGoatLatin {
    public static void main(String[] args) {
    String s = "I speak Goat Latin";
        System.out.println(toGoatLatin(s));
    }

    public static String toGoatLatin(String s){
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        char[] chars = s.trim().toCharArray();
        int length = s.trim().length();
        StringBuilder sbTemp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int index = 0;
        int i = 0;
        while (i <= length) {
            if (i == length ){
                i  ++;
                index ++;
                //1.判断是不是元音
                if (list.contains(sbTemp.charAt(0))){
                    result.append(sbTemp);
                    result.append("ma");
                    for (int j = 0;j < index ;j++){
                        result.append("a");
                    }
                    //清空sbTemp
                    result.append(' ');
                    sbTemp.delete(0,sbTemp.length());
                    //不是元音
                }else {
                    char temp = sbTemp.charAt(0);
                    //删除第一个
                    sbTemp.delete(0,1);
                    sbTemp.append(temp).append("ma");
                    result.append(sbTemp);
                    for (int j = 0;j < index ;j++){
                        result.append("a");
                    }
                    result.append(' ');
                    //清空sbTemp
                    sbTemp.delete(0,sbTemp.length());
                }
            }else if (chars[i] != ' ' ){
                //直接加入到sbTemp
                sbTemp.append(chars[i]);
                i++;
            }else {
                 i  ++;
                  index ++;
                //1.判断是不是元音
                if (list.contains(sbTemp.charAt(0))){
                    result.append(sbTemp);
                    result.append("ma");
                    for (int j = 0;j < index ;j++){
                        result.append("a");
                    }
                    //清空sbTemp
                    result.append(' ');
                    sbTemp.delete(0,sbTemp.length());
                //不是元音
                }else {

                   char temp = sbTemp.charAt(0);
                   //删除第一个
                   sbTemp.delete(0,1);
                   sbTemp.append(temp).append("ma");
                   result.append(sbTemp);
                    for (int j = 0;j < index ;j++){
                        result.append("a");
                    }
                    result.append(' ');
                    //清空sbTemp
                    sbTemp.delete(0,sbTemp.length());
                }
            }
        }
        return result.toString();
    }
}
