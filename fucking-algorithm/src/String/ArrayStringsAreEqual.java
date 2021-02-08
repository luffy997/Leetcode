package String;

/**
 * 1662. 检查两个字符串数组是否相等
 *
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] 和 word2[i] 由小写字母组成
 *
 *
 * @author 路飞
 * @create 2021/2/7 11:16
 */
public class ArrayStringsAreEqual {
    public static void main(String[] args) {
        String[] word1 = {"a","cb"};
        String[] word2 = {"ab","c"};
        System.out.println(arrayStringsAreEqual(word1, word2));
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    /**
     * 这个题就很有趣了
     * @param word1
     * @param word2
     * @return
     */
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2){
        StringBuilder sbOne = new StringBuilder();
        StringBuilder sbTwo = new StringBuilder();

        for (String str : word1){
            sbOne.append(str);
        }
        for (String str : word2){
            sbTwo.append(str);
        }
        System.out.println(sbOne.toString());
        System.out.println(sbTwo.toString());

        //需要判断判断两个字符串是否相等，使用StringBuilder的比较无论是equals还是==总是会发现错误，原因在于没有覆写equals()方法，关于 编写equals方法 ，参考 这儿.
        //解决办法，使用toString()将StringBuilder转换为String再进行相应比较。
        return sbOne.toString().equals(sbTwo.toString());
    }

    /**
     * join
     * @param word1
     * @param word2
     * @return
     */
    public static boolean function(String[] word1, String[] word2){
        return String.join("", word1).toString().equals(String.join("", word2));
    }
}
