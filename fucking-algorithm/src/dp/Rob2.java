package dp;

import java.util.Arrays;

/**
 * medium
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * @author 路飞
 * @create 2021/3/11 11:51
 */
public class Rob2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
//        int[] nums = {2,3,2};
        System.out.println(bob2(nums));
    }

    public static int bob2(int[] nums){
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0],nums[1]);

        //与打家劫舍1的区别是引入了环形，也是该题的难点，意味着：
        //第一个房子和最后一个房子只能选一个
        //我们可以分解成两个单队列，分别取最大，最后取最大即可

        int[] one = new int[len];
        int[] two = new int[len];

        //要第一房子，不要最后一个
        one[0] = nums[0];
        one[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len - 1; i++) {
            one[i] = Math.max(one[i-2]+nums[i],one[i-1]);
        }
        System.out.println(Arrays.toString(one));
        //不要第一个房子，要最后一个房子
        two[0] = 0;
        two[1] =nums[1];
        two[2] = Math.max(nums[1],nums[2]);
        for (int i = 3; i < len; i++) {
            two[i] = Math.max(two[i-2]+nums[i],two[i-1]);
        }
        System.out.println(Arrays.toString(two));

        return Math.max(one[len-2],two[len-1]);
    }
}
