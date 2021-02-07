package String;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
 *
 * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 *
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
 * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
 * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
 * 字符串 S 的 「前缀」是 S 的任何前导连续子字符串。
 *
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence 由小写英文字母和空格组成。
 * searchWord 由小写英文字母组成。
 * 前缀就是紧密附着于词根的语素，中间不能插入其它成分，并且它的位置是固定的——-位于词根之前。（引用自 前缀_百度百科 ）
 *
 * @author 路飞
 * @create 2021/2/6 11:11
 */
public class IsPrefixOfWord {
    public static void main(String[] args) {
        String sentence = "i love eating burger";
        String searchword = "burger";
        System.out.println(isPrefixOfWord(sentence, searchword));
    }

    public static int isPrefixOfWord(String sentence, String searchWord){
        String[] target = sentence.split("\\s+");
        int i =0;
        for (String str : target){
            //看str是否包含searchword并且 是否是前缀（返回值0）
            if (str.indexOf(searchWord) > -1 && str.indexOf(searchWord) ==0){
                return ++i;
            }
            ++i;
        }
        return -1;
    }

    //优化后的代码
    public static int function(String sentence, String searchWord){
        String[] split = sentence.split("\\ ");
        for (int i = 0; i < split.length; i++) {
            int index = split[i].indexOf(searchWord);
            //这里进行优化~
            if(index != -1) {
                if(index != 0) {
                    continue;
                }else {
                    return  i + 1;
                }
            }
        }
        return -1;
    }

}
