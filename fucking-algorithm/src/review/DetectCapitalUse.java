package review;

/**
 * 520. 检测大写字母
 *给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * @author 路飞
 * @create 2021/4/6 11:00
 */
public class DetectCapitalUse {
    public static void main(String[] args) {
        char a = 'a';
        char A = 'A';
        char z = 'z';
        char Z = 'Z';
        //小写 97 122
        //大写 65 90
        String world = "FlaG";
        System.out.println(detectCapitalUse(world));
    }

    public static boolean detectCapitalUse(String world){
        if (world.length() == 1) return true;

        //判断第一个是不是小写
        if (rangeInDefined(world.charAt(0),97,122)){
            //小写开头，就必须全部是小写
            for (int i = 1; i < world.length(); i++) {
                if (!rangeInDefined(world.charAt(i),97,122)) return false;
            }
        }else {
            //1.全部大写 或者 就只是首字母大写
            //判断第二个是不是大写
            if (rangeInDefined(world.charAt(1),65,90)){
                for (int i = 1; i < world.length(); i++) {
                    if (!rangeInDefined(world.charAt(i),65,90)) return false;
                }
            }else {
                for (int i = 1; i < world.length(); i++) {
                    if (!rangeInDefined(world.charAt(i),97,122)) return false;
                }
            }
        }
        return true;
    }

    //判断在不在范围
    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }
}
