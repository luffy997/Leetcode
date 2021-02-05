package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893. 特殊等价字符串组
 *你将得到一个字符串数组 A。
 *
 * 每次移动都可以交换 S 的任意两个偶数下标的字符或任意两个奇数下标的字符。
 *
 * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是 特殊等价 的。
 *
 * 例如，S = "zzxy" 和 T = "xyzz" 是一对特殊等价字符串，因为可以先交换 S[0] 和 S[2]，然后交换 S[1] 和 S[3]，使得 "zzxy" -> "xzzy" -> "xyzz" 。
 *
 * 现在规定，A 的 一组特殊等价字符串 就是 A 的一个同时满足下述条件的非空子集：
 *
 * 该组中的每一对字符串都是 特殊等价 的
 * 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特殊等价）
 * 返回 A 中特殊等价字符串组的数量。
 *
 *  1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * 所有 A[i] 都具有相同的长度。
 * 所有 A[i] 都只由小写字母组成。
 *
 * @author 路飞
 * @create 2021/2/4 10:55
 */
public class NumSpecialEquivGroups {
    public static void main(String[] args) {
    String[] A = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        System.out.println(numSpecialEquivGroups(A));
    }

    public static int numSpecialEquivGroups(String[] A){
        Set<Long> hash = new HashSet<>();
        for(String a: A){
            long h1 = 0, h2 = 0;
            // 第一次hash
            for(int i = 0; i < a.length(); i++){
                if(i % 2 == 0){
                    h1 += (a.charAt(i)-'a'+1)<<(a.charAt(i)-'a');// 偶数位
                }else{
                    h2 += (a.charAt(i)-'a'+1)<<(a.charAt(i)-'a');// 奇数位
                }
            }
            // 第二次hash
            long h = (h1 + h2) * h1;
            if(!hash.contains(h))hash.add(h);
        }
        return hash.size();
    }

    //官方解题

    /**
     * 让我们试着表述一个特殊等价的字符串 SS，通过找到函数 \mathcal{C}C 使得 S \equiv T \iff \mathcal{C}(S) = \mathcal{C}(T)S≡T⟺C(S)=C(T)。
     *
     * 通过交换，我们可以排列偶数索引字母和奇数索引字母。这些排列的特征在于字母的数量：所有这样的排列都有相同的数量，不同的数量会产生不同的排列。
     *
     * 因此，函数 \mathcal{C}(S) =C(S)=（S 中偶数索引字母的数量，其后是 S 中奇数索引字母的数量）成功地刻画了这一等价关系。
     *
     * 然后，我们统计出满足 S \in AS∈A 的 \mathcal{C}(S)C(S) 的数量。
     *
     * @param A
     * @return
     */
    public int function(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
}
