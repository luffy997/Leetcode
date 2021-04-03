package twohand;

import java.util.Arrays;

/**
 * hard
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 找缝隙 缝隙就可以用来装水
 * @author 路飞
 * @create 2021/4/2 8:23
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int sum = 0;
        int maxL = 0;
        int length = height.length;
        int[] left = new int[length];
        //从左到右扫描可能存水的高度
        for (int i = 0; i < length; i++) {
            if (maxL <= height[i]){
                maxL = height[i];
                left[i] = 0;
            }else {
                left[i] = maxL - height[i];
            }
        }

        //观察left的前部分 其实就是真实的存水高度，但后面的部分就不是了，因为maxL在迭代，越到最后就越大
        //进入else的情况越来越多，特别是当maxL达到数组最大，那后面的小于maxL的情况就很多很多 等于就不管 不会蓄水
        //所以真实的后部分的蓄水高度就需要从右到左进行扫描了，但同样会出现这个情况
        //所以最好取两个数字中较小的一项，累加即可
        //从右到左扫描可能存水的高度
        int maxR = 0;
        int[] right = new int[length];

        for (int i = length - 1; i >= 0; i --) {
            if (maxR <= height[i]){
                maxR = height[i];
                right[i] = 0;
            }else {
                right[i] = maxR - height[i];
            }
        }
        for (int i = 0; i < length; i++) {
            sum += Math.min(left[i],right[i]);
        }
        return sum;
    }
}
