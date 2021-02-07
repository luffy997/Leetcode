package String;

import java.util.LinkedList;

/**
 * 1592. 重新排列单词间的空格
 * <p>
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 * <p>
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 * <p>
 * 返回 重新排列空格后的字符串 。
 *
 * @author 路飞
 * @create 2021/2/6 22:11
 */
public class ReorderSpaces {
    public static void main(String[] args) {
        String text = "hello ";
        System.out.println(recorderSpaces(text));
    }

    /**
     * 也吐了 23点37分
     *
     * @param text
     */
    public static String recorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        LinkedList<String> stack = new LinkedList<String>();
        int countSpace = 0;
        int countWord = 0;
        int length = text.length();
        int index = 0;
        boolean flag = true;
        //求出空格个数
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                countSpace++;
            }
        }
        //去掉前后的空格
        String trim = text.trim();
        for (int i = 0; i < trim.length();) {
            while (trim.charAt(i) != ' ' ){
                sb.append(trim.charAt(i));
                ++i;
                if (i == trim.length() ) break;
            }
            if (sb.length() > 0){
                stack.push(sb.toString());
                ++i;
                //置空sb
                countWord++;
                sb.delete(0,sb.length());
            }else {
                ++i;
            }
        }
        if (countWord == 1 && countSpace ==0) return text;
        if (countWord ==1 && countSpace >=1){
            result.append(stack.pollLast());
            for (int i = 0; i < countSpace; i++) {
                result.append(' ');
            }
            return result.toString();
        }

        //每个间隔多少个空格
        int everySpace = countSpace / (countWord -1) ;
        if (countSpace % (countWord -1) == 0 ){
           while (stack.size() != 0){
            result.append(stack.pollLast());
               for (int i = 0; i < everySpace; i++) {
                   if (stack.size() > 0){
                       result.append(' ');
                   }
               }
           }
           return result.toString();
        }else {
            while (stack.size() != 0){
                result.append(stack.pollLast());
                for (int i = 0; i < everySpace; i++) {
                    if (stack.size() > 0){
                        result.append(' ');
                    }
                }
            }
            for (int i = 0; i < countSpace % (countWord - 1); i++) {
                result.append(' ');
            }
            return result.toString();
        }

    }

}

