package String;

/**
 * 859. 亲密字符串
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个
 * 字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i]
 * 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 * @author 路飞
 * @create 2021/2/3 19:33
 */
public class BuddyStrings {
    public static void main(String[] args) {

    }

    public static boolean buddyStrings(String A, String B){
        if (A.length() != B.length())
            return false; //如果A、B长度都不等，返回false
        if (A.equals(B)) {
            for (int i = 0; i < A.length() - 1; i++) {
                if (A.indexOf(A.charAt(i), i + 1) != -1) { //如果A == B，则检查A/B中有无重复字符，如果有，重复字符对调一下就可以，满足条件。
                    return true;
                }
            }
            return false;
        }
        int index1 = -1, index2 = -1, count = 0;
        for (int i = 0; i < A.length(); i++) { //一次遍历找出2个不同元素的下标
            if (A.charAt(i) != B.charAt(i)) {
                count++;
                if (count == 1)
                    index1 = i;
                else if (count == 2)
                    index2 = i;
                else
                    return false;
            }
        }
        return count == 2 && A.charAt(index1) == B.charAt(index2) && A.charAt(index2) == B.charAt(index1);
    }
}
