package String;

/**
 * 1370. 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * <p>
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * <p>
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 * @author 路飞
 * @create 2021/2/5 11:35
 */
public class SortString {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        System.out.println(sortString(s));
    }

    public static String sortString(String s) {
        //创建26个桶
        int[] bucket = new int[26];
        char[] charArray = s.toCharArray();
        //把s中的字符分别放到对应的桶中
        for (char c : charArray) {
            bucket[c - 'a']++;
        }
        //存储计算的结果
        char[] res = new char[s.length()];
        int index = 0;
        while (index < s.length()) {
            //从左往右找，遍历26个桶，如果当前桶不为空
            //就从当前桶里拿出第一个元素
            for (int i = 0; i < 26; i++) {
                if (bucket[i] != 0) {
                    res[index++] = (char) (i + 'a');
                    bucket[i]--; //拿出之后桶中的元素个数要-1
                }
            }
            //从右往左拿，
            for (int i = 25; i >= 0; i--) {
                if (bucket[i] != 0) {
                    res[index++] = (char) (i + 'a');
                    bucket[i]--; //拿出之后桶中的元素个数要-1
                }
            }
        }
        return new String(res);
    }
}
