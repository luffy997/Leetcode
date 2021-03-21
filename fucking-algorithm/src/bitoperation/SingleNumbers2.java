package bitoperation;

/**
 * medium
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @author 路飞
 * @create 2021/3/21 17:13
 */
public class SingleNumbers2 {
    public static void main(String[] args) {


    }

    /**
     * 与SingleNumber1 类似，但这里求的是两个出现一次的数字，不能直接通过异或求出
     * 想到的思路就是分组，再进行异或即可，本质上还是SingleNumber1
     * @param nums
     * @return
     */
    public static int[]  vsingleNumber(int[] nums){
        int x = 0;
        int y = 0;
        int m = 0;
        for(int num : nums){
            m ^=num;
        }
        while ((m&1) == 0){
            m<<=1;
        }
        for (int num : nums){
            if ((m&num) == 0){
                x ^=num;
            }else {
                y ^=num;
            }
        }
        return new int[]{x,y};
    }
}
