package review;

/**
 * 接雨水
 * @author 路飞
 * @create 2021/4/24 17:16
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static long trap(int[] height) {
        int len = height.length;
        if (len <=1)return 0;

        //找到最高点
        int max_height = 0;
        int max_index = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            temp = height[i];
            if (temp > max_height){
                max_height = temp;
                max_index = i;
            }
        }

        long area = 0;
        //从左往最高点遍历
        temp = height[0];
        for (int i = 0; i < max_index; i++) {
            if (height[i] > temp){
                temp = height[i];
            }else {
                area = area + (temp - height[i]);
            }
        }

        temp = height[height.length-1];
        for (int i = height.length-1; i > max_index; i--) {
            if (height[i] > temp){
                temp = height[i];
            }else {
                area = area + (temp - height[i]);
            }
        }
        return area;

    }
}
