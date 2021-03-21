package bitoperation;

/**
 * easy
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
 * 任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
 * 异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
 *
 * @author 路飞
 * @create 2021/3/21 16:14
 */
public class SingleNumber1 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int nums[]){
        int single = 0;
        //性质 a^b^a=b
        for(int num : nums){
            single ^= num;
        }
        return single;
    }
}
