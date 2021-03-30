package twohand;

/**
 * medium
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * @author 路飞
 * @create 2021/3/29 10:14
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,2};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){
        //双指针
        int len = height.length;
        int res = 0;
        int left = 0;
        int right = len - 1;
        while (left < right){
            res = height[left] < height[right] ?
                    Math.max(res,(right - left)*height[left++]):
                    Math.max(res,(right - left)*height[right--]);
        }
        return res;
    }
}
