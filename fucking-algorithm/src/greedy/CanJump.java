package greedy;

/**
 * medium
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * @author 路飞
 * @create 2021/3/31 15:25
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(canJump(nums));
    }

    //倒叙
    public static boolean canJump(int[] nums){
        //特判
        int length = nums.length;
        if (length <=0) return true;
        if (nums[0] == 0) return false;

        int maxDis = 0;
        for(int i = 0 ; i< length -1;i++){
            //举个例子
            // 2 3 1 1 4
            //其实当我们不知道全部数的情况下，是无法断定能不能到达最后一个数，但有个规则就是数列是递增的那就一定能到到达最后
            //当用贪心的思想，每步尝试去走最大的
            //第一步 2
            //第二步 3 这里不需要考虑的，因为是递增的，我们就顺理成章的把最大
            //但当我们到1 这就比之前的小了，就需要把最大的置换处理

            if (i <= maxDis){ //需要加= 不然不进入循环
                maxDis = Math.max(maxDis,i+nums[i]);
                if (maxDis >= length -1) return true; //直接一步登天，不走了！！
            }
        }
        return false;

    }
}
