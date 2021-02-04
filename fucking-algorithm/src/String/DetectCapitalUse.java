package String;

/**
 * 520. 检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * 。
 *
 * @author 路飞
 * @create 2021/1/30 10:23
 */
public class DetectCapitalUse {
    public static void main(String[] args) {

        //大写 65-90
        //小写 97-122
        String word = "G";
        boolean b = detectCapitalUse(word);
        System.out.println(b);

    }

    public static boolean detectCapitalUse(String word) {
        int length = word.length();
        if (word.length() ==1) return true;
        //第一个是否为大写
        if (rangeInDefined(Integer.valueOf(word.charAt(0)), 65, 90)) {
            //判断第二位开始是否为大写
            boolean b = rangeInDefined(Integer.valueOf(word.charAt(1)), 65, 90);
            if (b == true) {
                for (int i = 2; i < length; i++) {
                    if (rangeInDefined(Integer.valueOf(word.charAt(i)), 65, 90) == false) {
                        return false;
                    }
                }
                return true;

            }else {
                for (int i = 2; i < length; i++) {
                    if (rangeInDefined(Integer.valueOf(word.charAt(i)), 65, 90) == true) {
                        return false;
                    }
                }
                return true;
            }

            //第一位是小写 每一位都需要是小写
            } else {
                for (int i = 1; i < length; i++) {
                    if (rangeInDefined(Integer.valueOf(word.charAt(i)), 65, 90) == true) {
                        return false;
                    }
                }
                return true;
            }

        }



    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }
}
